package com.example.service;

import com.example.demo.dto.PictureDto;
import com.example.demo.model.PictureModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PictureService {

    private List<PictureModel> pictures = new ArrayList<>();
    private long currentId = 1;

    public PictureModel addPicture(PictureDto pictureDto) {
        PictureModel picture = new PictureModel(pictureDto.getTitle(), pictureDto.getPhotographer(), pictureDto.getReleaseDate(), pictureDto.getStatus());
        picture.setId(currentId++);
        pictures.add(picture);
        return picture;
    }

    public List<PictureModel> getAllPictures() {
        return pictures;
    }

    public Optional<PictureModel> getPictureById(Long id) {
        return pictures.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public boolean updatePicture(Long id, PictureDto pictureDto) {
        Optional<PictureModel> pictureOpt = getPictureById(id);
        if (pictureOpt.isPresent()) {
            PictureModel picture = pictureOpt.get();
            picture.setTitle(pictureDto.getTitle());
            picture.setPhotographer(pictureDto.getPhotographer());
            picture.setReleaseDate(pictureDto.getReleaseDate());
            picture.setStatus(pictureDto.getStatus());
            return true;
        }
        return false;
    }

    public boolean deletePicture(Long id) {
        return pictures.removeIf(p -> p.getId().equals(id));
    }
}
