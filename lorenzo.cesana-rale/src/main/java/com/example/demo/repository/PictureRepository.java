package com.example.demo.repository;

import com.example.demo.model.PictureModel;

import java.util.List;
import java.util.Optional;

public interface PictureRepository {
    List<PictureModel> findAll();
    Optional<PictureModel> findById(Long id);
    PictureModel save(PictureModel pictureModel);
    boolean delete(Long id);
}