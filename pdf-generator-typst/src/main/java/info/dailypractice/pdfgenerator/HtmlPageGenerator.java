package com.dailypractice.info.pdfgenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@ShellComponent
public class HtmlPageGenerator {
    private final PageConfigurationProvider pageConfigurationProvider;

    public HtmlPageGenerator(PageConfigurationProvider pageConfigurationProvider) {
        this.pageConfigurationProvider = pageConfigurationProvider;
    }

    @ShellMethod("generate HTML pages")
    public void generateHtmlPages(String dataFilepath) throws IOException, RuntimeException {
        pageConfigurationProvider.getPageConfiguration(dataFilepath).
                forEach(htmlPageConfiguration -> {
                    try {
                        doProcess(htmlPageConfiguration);
                    } catch (TemplateException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private void doProcess(PageConfiguration pc) throws TemplateException, IOException {
        validatePageConfiguration(pc);
        generateHtml(pc);
    }

    private static void validatePageConfiguration(PageConfiguration pc) throws FileNotFoundException {
        if (!Files.exists(Path.of(pc.getTemplateFilename()))) {
            System.out.println("File does not exist: " + pc.getTemplateFilename());
            throw new FileNotFoundException(pc.getTemplateFilename());
        }
    }

    public void generateHtml(PageConfiguration pc) throws IOException, TemplateException {
        Path template = Paths.get(pc.getTemplateFilename());
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

        try (OutputStream outputStream = new FileOutputStream(Paths.get(pc.getOutputFilename()).toString());
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            String information = MessageFormat.format("Processing template for: {0} -  Output File: {1}", pc.getPageHeading(), pc.getOutputFilename());
            System.out.println(information);
            Map data = new HashMap();
            data.put("pc", pc);
            temp.process(data, outputStreamWriter);

        }
    }
}
