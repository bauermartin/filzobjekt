package de.mb.filzobjekt.business;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import de.mb.filzobjekt.bean.ImageContainer;
import de.mb.filzobjekt.repository.file_repository.IImageRepository;

/**
 * @author Martin Bauer (20.06.2016)
 *
 */
@Controller
public class ImageService implements IImageService {

	@Autowired private IImageRepository img_repository;
	public static final String SHOES = "shoes_images";
	public static final String HANDBAG = "handbag_images";
	public static final String GABI = "gabi_imges";
	public static final String SEAT_PAD = "seat_pad_images";
	public static final String WALL_HANGING = "wall_hanging_images";
	public static final String OBJECT = "object_images";

	@Override
	public ImageContainer getImages(String field_id) throws IOException {
		return img_repository.get(field_id);
	}

}
