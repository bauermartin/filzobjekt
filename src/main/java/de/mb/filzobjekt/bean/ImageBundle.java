package de.mb.filzobjekt.bean;

import java.util.List;

/**
 * @author Martin Bauer (22.06.2016)
 *
 */
public class ImageBundle extends SimpleBundle<Image> {

	public ImageBundle() {
	}
	
	public ImageBundle(String id, Image[] images) {
		super(id, images);
	}

	@Override
	public Image[] getImages() {
		return content.toArray(new Image[0]);
	}
	
	public void setImages(List<Image> img){
		content = img;
	}

}
