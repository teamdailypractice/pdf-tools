package com.dailypractice.info.pdf_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfGeneratorApplication {

	public static void main(String[] args) {

		SpringApplication.run(PdfGeneratorApplication.class, args);

		System.out.println("hello world!");
	}

}
