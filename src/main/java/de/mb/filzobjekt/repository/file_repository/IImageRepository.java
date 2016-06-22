package de.mb.filzobjekt.repository.file_repository;

import java.io.IOException;
import de.mb.filzobjekt.bean.Image;
import de.mb.filzobjekt.bean.ImageContainer;

/**
 * @author Martin Bauer (21.06.2016)
 *
 */
public interface IImageRepository {

	public ImageContainer get(String id) throws IOException;

	public void create(Image img) throws IOException;

	public void update(String id, Image img) throws IOException;
}
