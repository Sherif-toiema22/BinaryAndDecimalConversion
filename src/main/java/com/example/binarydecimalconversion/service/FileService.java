package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.StringJoiner;

@Service
public class FileService {

    public String processFile(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();  // Read file content as bytes
        StringJoiner result = new StringJoiner("<br/>");

        for (byte b : bytes) {
            // Convert to binary and decimal
            String binaryString = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            String line = "Decimal: " + (b & 0xFF) + " | Binary: " + binaryString;
            result.add(line);
        }

        return result.toString();
    }
}
