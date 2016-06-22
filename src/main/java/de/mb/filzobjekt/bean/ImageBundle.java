package de.mb.filzobjekt.bean;

/**
 * @author Martin Bauer (22.06.2016)
 *
 */
public class ImageBundle extends SimpleBundle<Image> {

	public ImageBundle(String id, Image[] images) {
		super(id, images);
	}

	@Override
	public Image[] getAll() {
		return content.toArray(new Image[0]);
	}

}
