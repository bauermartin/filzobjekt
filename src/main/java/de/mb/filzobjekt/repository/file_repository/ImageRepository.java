package de.mb.filzobjekt.repository.file_repository;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import de.mb.filzobjekt.bean.Image;
import de.mb.filzobjekt.bean.ImageBundle;
import de.mb.filzobjekt.bean.ImageContainer;
import de.mb.filzobjekt.util.FileFactory;

/**
 * @author Martin Bauer (21.06.2016)
 *
 */
@Controller
public class ImageRepository implements IImageRepository {

	private final String SHOES = "shoes_images";
	private final String IMAGES_JSON_FILE_PATH = "/tmp/";

	@Override
	public ImageContainer get(String id) throws IOException {
		List<Image> images = new LinkedList<>();
		images.add(new Image(0, "images/schuhe mit punkten.jpg", "Schuhe mit punkten"));
		images.add(new Image(1, "images/Schuhe grau.jpg", "Schuhe grau"));
		ImageBundle bundle = new ImageBundle("shoes_table", images.toArray(new Image[0]));
		ImageContainer img_cont = new ImageContainer();
		img_cont.add(bundle);
		return img_cont;
		// return FileFactory.readFile(IMAGES_JSON_FILE_PATH + SHOES, ImageContainer.class);
	}

	@Override
	public void create(Image img) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String id, Image img) {
		// TODO Auto-generated method stub

	}

}
