package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.PictureDto;
import com.example.demo.model.PictureModel;
import com.example.service.PictureService;

@RestController
@RequestMapping("/lorenzo")
public class PictureController {

    @Autowired
    private PictureService service;

    @GetMapping("/pictures")
    public @ResponseBody Iterable<PictureModel> getControllerPictures() {
        return this.service.getAllPictures();
    }

    @GetMapping("/pictures/{id}")
    public @ResponseBody Optional<PictureModel> getControllerPicture(@PathVariable("id") Long id) {
        return this.service.getPictureById(id);
    }

    @PostMapping("/pictures")
    public @ResponseBody PictureModel postControllerPictures(@RequestBody PictureDto pictureDto) {
        return this.service.addPicture(pictureDto);
    }

    @PutMapping("/pictures/{id}")
    public @ResponseBody boolean putControllerPicture(@RequestBody PictureDto pictureDto, @PathVariable("id") Long id) {
        return this.service.updatePicture(id, pictureDto);
    }

    @DeleteMapping("/pictures/{id}")
    public @ResponseBody boolean deleteControllerPictures(@PathVariable Long id) {
        return this.service.deletePicture(id);
    }
}
