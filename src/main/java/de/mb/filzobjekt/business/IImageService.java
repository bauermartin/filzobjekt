package de.mb.filzobjekt.business;

import java.io.IOException;
import de.mb.filzobjekt.bean.ImageContainer;

/**
 * @author Martin Bauer (20.06.2016)
 *
 */
public interface IImageService {

	public ImageContainer getImages(String id) throws IOException;

}
