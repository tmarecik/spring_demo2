package com.example.demo2.controller6;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RequestMapping("/image")
@RestController
public class ImageController {

    @GetMapping(produces = "image/jpg")
    public byte[] kot() throws IOException {
        InputStream stream = this.getClass()
                                .getClassLoader()
                                .getResourceAsStream("kot.jpg");
        return stream.readAllBytes();
    }

}
