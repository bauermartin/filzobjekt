package de.mb.filzobjekt.repository.file_repository;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import de.mb.filzobjekt.bean.Image;
import de.mb.filzobjekt.bean.ImageContainer;
import de.mb.filzobjekt.business.ImageService;
import de.mb.filzobjekt.util.FileFactory;

/**
 * @author Martin Bauer (21.06.2016)
 *
 */
@Controller
public class ImageRepository implements IImageRepository {

	// private final String IMAGES_JSON_FILE_PATH = "/opt/filzobjekt/images/";
	private final String IMAGES_JSON_FILE_PATH = "D:\\opt\\filzobjekt\\images";
	private final String SHOES_JSON_FILE_PATH = "shoes.json";
	private final String HANDBAG_JSON_FILE_PATH = "handbag.json";
	private final String OBJECT_JSON_FILE_PATH = "object.json";
	private final String WALLHANGING_JSON_FILE_PATH = "wallhanging.json";
	private final String GABI_JSON_FILE_PATH = "gabi.json";
	private final String SEAT_PAT_JSON_FILE_PATH = "seat_pad.json";

	private Map<String, ImageContainer> images = new HashMap<String, ImageContainer>();
	private Map<String, String> imagePathMap = new HashMap<String, String>();

	public ImageRepository() {
		imagePathMap.put(ImageService.GABI, IMAGES_JSON_FILE_PATH + File.separator
				+ GABI_JSON_FILE_PATH);
		imagePathMap.put(ImageService.SHOES, IMAGES_JSON_FILE_PATH + File.separator
				+ SHOES_JSON_FILE_PATH);
		imagePathMap.put(ImageService.OBJECT, IMAGES_JSON_FILE_PATH + File.separator
				+ OBJECT_JSON_FILE_PATH);
		imagePathMap.put(ImageService.WALL_HANGING, IMAGES_JSON_FILE_PATH + File.separator
				+ WALLHANGING_JSON_FILE_PATH);
		imagePathMap.put(ImageService.HANDBAG, IMAGES_JSON_FILE_PATH + File.separator
				+ HANDBAG_JSON_FILE_PATH);
		imagePathMap.put(ImageService.SEAT_PAD, IMAGES_JSON_FILE_PATH + File.separator
				+ SEAT_PAT_JSON_FILE_PATH);
	}

	@Override
	public ImageContainer get(String id) throws IOException {

		ImageContainer img = images.get(id);
		if (img == null) {
			img = loadImage(id);
		}
		return img;
	}

	private ImageContainer loadImage(String id) {
		ImageContainer imgCont = null;
		String path = imagePathMap.get(id);
		if (path != null) {
			try {
				imgCont = FileFactory.readFile(path, ImageContainer.class);
			} catch (IOException e) {}
		}
		return imgCont;
	}

	@Override
	public void create(Image img) throws IOException {

	}

	@Override
	public void update(String id, Image img) {
		// TODO Auto-generated method stub

	}

}
