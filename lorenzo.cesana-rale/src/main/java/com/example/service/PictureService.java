package com.example.service;

import com.example.demo.dto.PictureDto;
import com.example.demo.model.PictureModel;
import com.example.demo.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureService {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public PictureModel addPicture(PictureDto pictureDto) {
        PictureModel picture = new PictureModel(pictureDto.getTitle(), pictureDto.getPhotographer(), pictureDto.getReleaseDate(), pictureDto.getStatus());
        return pictureRepository.save(picture);
    }

    public List<PictureModel> getAllPictures() {
        return pictureRepository.findAll();
    }

    public Optional<PictureModel> getPictureById(Long id) {
        return pictureRepository.findById(id);
    }

    public boolean updatePicture(Long id, PictureDto pictureDto) {
        Optional<PictureModel> pictureOpt = getPictureById(id);
        if (pictureOpt.isPresent()) {
            PictureModel picture = pictureOpt.get();
            picture.setTitle(pictureDto.getTitle());
            picture.setPhotographer(pictureDto.getPhotographer());
            picture.setReleaseDate(pictureDto.getReleaseDate());
            picture.setStatus(pictureDto.getStatus());
            pictureRepository.save(picture);
            return true;
        }
        return false;
    }

    public boolean deletePicture(Long id) {
        return pictureRepository.delete(id);
    }
}
