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
		Image img = new Image(0, "images/schuhe mit punkten.jpg", "Schuhe mit punkten");
		img.setUrlSmall("images/schuhe mit punkten.jpg");
		img.setActive(true);
		images.add(img);
		Image img2 = new Image(1, "images/Schuhe grau.jpg", "Schuhe grau");
		img2.setUrlSmall("images/Schuhe grau.jpg");
		img2.setActive(true);
		images.add(img2);
		Image img3 = new Image(2, "images/Schuhe grau.jpg", "Schuhe grau");
		img3.setUrlSmall("images/Schuhe grau.jpg");
		img3.setActive(true);
		images.add(img3);
		Image img4 = new Image(3, "images/Schuhe grau.jpg", "Schuhe grau");
		img4.setUrlSmall("images/Schuhe grau.jpg");
		img4.setActive(true);
		images.add(img4);
		Image img5 = new Image(4, "images/Schuhe grau.jpg", "Schuhe grau");
		img5.setUrlSmall("images/Schuhe grau.jpg");
		img5.setActive(true);
		images.add(img5);
		Image img6 = new Image(5, "images/Schuhe grau.jpg", "Schuhe grau");
		img6.setUrlSmall("images/Schuhe grau.jpg");
		img6.setActive(false);
		images.add(img6);
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
