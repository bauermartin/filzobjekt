package de.mb.filzobjekt.bean;

import java.util.Map;

/**
 * @author Martin Bauer (22.06.2016)
 *
 */
public class ImageContainer extends AbstractContainer<ImageBundle> {

	@Override
	public Map<String, ImageBundle> getAllBundles() {
		return content;
	}

	public void setAllBundles(Map<String, ImageBundle> bundles) {
		content = bundles;
	}
}
