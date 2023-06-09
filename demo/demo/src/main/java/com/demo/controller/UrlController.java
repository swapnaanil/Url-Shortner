package com.demo.controller;

import com.demo.modal.Url;
import com.demo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("url/shortner")
@CrossOrigin(origins = "http://localhost:4200")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @GetMapping("/{id}")
    public String getOriginlUrl(@PathVariable String id) {
        return urlService.getOriginlUrl(id);
    }

    @PostMapping
    public Url generateShortUrl(@RequestBody String url) {
        return urlService.generateShortUrl(url);
    }
}
