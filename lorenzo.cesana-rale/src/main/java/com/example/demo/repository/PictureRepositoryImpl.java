package com.example.demo.repository;

import com.example.demo.model.PictureModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PictureRepositoryImpl implements PictureRepository {

    private List<PictureModel> pictures = new ArrayList<>();
    private long currentId = 1;

    @Override
    public List<PictureModel> findAll() {
        return pictures;
    }

    @Override
    public Optional<PictureModel> findById(Long id) {
        return pictures.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public PictureModel save(PictureModel pictureModel) {
        pictureModel.setId(currentId++);
        pictures.add(pictureModel);
        return pictureModel;
    }

    @Override
    public boolean delete(Long id) {
        return pictures.removeIf(p -> p.getId().equals(id));
    }
}
