package com.adrianwong.learninggraphql.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/images")
@RestController
public class ImageController {

    @PostMapping
    public void getImages(@RequestBody String query) {

    }
}
