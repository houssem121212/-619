package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Image;
import tn.esprit.spring.repository.ImageRepository;

@Service
public class ImageServiceImpl implements IImageService {

	@Autowired
	ImageRepository imageRepository;
	@Override
	public long addImage(Image image) {
		imageRepository.save(image);
		return image.getId();
	}

	@Override
	public long updateImage(List<Image> p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long deleteImage(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Image> getAllImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> getImagebyProduct(long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImageById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
