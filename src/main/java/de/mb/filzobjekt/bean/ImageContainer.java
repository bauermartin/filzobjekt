package de.mb.filzobjekt.bean;

/**
 * @author Martin Bauer (22.06.2016)
 *
 */
public class ImageContainer extends AbstractContainer<ImageBundle> {

	@Override
	public ImageBundle[] getAllBundles() {
		return content.entrySet().toArray(new ImageBundle[0]);
	}
}
