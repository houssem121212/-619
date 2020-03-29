package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Image;


public interface IImageService {
	public	long addImage(Image image);
	 public long updateImage(List<Image> image);
	 public long deleteImage(long id);
	 public List<Image> getAllImage();
	 public List<Image> getImagebyProduct(long productId);
	 public Image getImageById(long id);
	 
}
