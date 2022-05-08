package com.project.FoodDeliveryService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.project.FoodDeliveryService.Model.ImageModel;
import com.project.FoodDeliveryService.repository.ImageRepository;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @PostMapping("/upload")
    public ImageModel uplaodImage(@RequestParam("myFile") MultipartFile file) throws IOException {

        ImageModel img = new ImageModel( file.getOriginalFilename(),file.getContentType(),file.getBytes() );


        final ImageModel savedImage = imageRepository.save(img);


        System.out.println("Image saved");


        return savedImage;


    }
}