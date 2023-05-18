package com.vti.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class PdfController {

	@GetMapping("pdfContent")
	public String getPdfContent() throws IOException {
		String filePath = "D:\\Test/Test.pdf";
        // Load the PDF file
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);

        // Convert the PDF file to byte array
        byte[] bytes = new byte[(int) file.length()];
        inputStream.read(bytes);

        // Convert the byte array to Base64 string
        String base64String = Base64.getEncoder().encodeToString(bytes);

        // Close the input stream
        inputStream.close();

        return base64String;
	}
	
}

