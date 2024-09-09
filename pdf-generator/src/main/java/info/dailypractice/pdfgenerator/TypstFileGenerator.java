package info.dailypractice.pdfgenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import info.dailypractice.pdfgenerator.PageConfigurationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@ShellComponent
public class TypstFileGenerator {
    @Autowired
    private BookConfigurationProvider bookConfigurationProvider;

    public TypstFileGenerator() {
    }

    public TypstFileGenerator(BookConfigurationProvider bookConfigurationProvider) {
        this.bookConfigurationProvider = bookConfigurationProvider;
    }

    @ShellMethod("generate typst file for book")
    public void generateBookTypeSetting(String dataFilepath) throws IOException, RuntimeException {
        bookConfigurationProvider.getBookConfiguration(dataFilepath).
                forEach(bookConfiguration -> {
                    try {
                        doProcess(bookConfiguration);
                    } catch (TemplateException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private void doProcess(BookConfiguration bc) throws TemplateException, IOException {
        validatePageConfiguration(bc);
        generateTypstFile(bc);
    }

    private static void validatePageConfiguration(BookConfiguration bc) throws FileNotFoundException {
        if (!Files.exists(Path.of(bc.getTemplateFileAbsolutePath()))) {
            System.out.println("File does not exist: " + bc.getTemplateFileAbsolutePath());
            throw new FileNotFoundException(bc.getTemplateFileAbsolutePath());
        }
    }

    private void generateTypstFile(BookConfiguration bc) throws IOException, TemplateException {
        Path template = Paths.get(bc.getTemplateFileAbsolutePath());
        String templateFileDirectory = template.getParent().toString();
        String templateFilename = template.getFileName().toString();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setDirectoryForTemplateLoading(new File(templateFileDirectory));
        // Recommended settings for new projects:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        Template temp = cfg.getTemplate(templateFilename);

        try (OutputStream outputStream = new FileOutputStream(Paths.get(bc.getOutputFileAbsolutePath()).toString());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            String information = MessageFormat.format("Processing template for: {0} -  Output File: {1}", bc.getBookName(), bc.getOutputFileAbsolutePath());
            System.out.println(information);
            Map data = new HashMap();
            data.put("bc", bc);
            temp.process(data, outputStreamWriter);
        }
    }
}
