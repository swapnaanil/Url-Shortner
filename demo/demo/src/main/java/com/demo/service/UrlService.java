package com.demo.service;

import com.demo.modal.Url;
import com.demo.repository.UrlRepository;
import org.springframework.stereotype.Service;

import static com.demo.logic.GenerateShortUrl.getShortUrl;
import static com.demo.logic.GenerateShortUrl.isUrlValid;

@Service
public class UrlService {
    private UrlRepository urlRepository;
    public String getOriginlUrl(String id) {
        return urlRepository.findByShortUrl(id);
    }

    public Url generateShortUrl(String url) {
        if(! isUrlValid(url)) {
            System.out.println("URL is not valid");
            return null;
        }

        Url urlObject = new Url();
        urlObject.setOriginalurl(url);
        urlObject.setShorturl(getShortUrl(url));

        return urlRepository.save(urlObject);
    }

    }

