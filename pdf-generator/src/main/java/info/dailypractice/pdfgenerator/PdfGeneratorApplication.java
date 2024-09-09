package info.dailypractice.pdfgenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@SpringBootApplication
public class PdfGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfGeneratorApplication.class, args);
	}

	@Autowired
	private ObjectMapper objectMapper1;

	@Autowired
	private ObjectMapper objectMapper2;

	@ShellMethod()
	public String hi() {

		return "hi";
	}

	@ShellMethod()
	public String om() {
		String test = objectMapper1.toString() + System.lineSeparator() + objectMapper2.toString();
		return test;
	}
}
