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
        if (pictureModel.getId() == null) {
            pictureModel.setId(currentId++);
            pictures.add(pictureModel);
        } else {
            int index = -1;
            for (int i = 0; i < pictures.size(); i++) {
                if (pictures.get(i).getId().equals(pictureModel.getId())) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                pictures.set(index, pictureModel);
            }
        }
        return pictureModel;
    }

    @Override
    public boolean delete(Long id) {	
        return pictures.removeIf(p -> p.getId().equals(id));
    }
}
