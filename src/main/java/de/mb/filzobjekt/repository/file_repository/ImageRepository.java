package de.mb.filzobjekt.repository.file_repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import de.mb.filzobjekt.bean.Image;
import de.mb.filzobjekt.bean.ImageBundle;
import de.mb.filzobjekt.bean.ImageContainer;
import de.mb.filzobjekt.business.ImageService;
import de.mb.filzobjekt.util.FileFactory;

/**
 * @author Martin Bauer (21.06.2016)
 *
 */
@Controller
public class ImageRepository implements IImageRepository {

	private final String IMAGES_JSON_FILE_PATH = "/tmp/";
	private Map<String, ImageContainer> images = new HashMap<String, ImageContainer>();

	public ImageRepository() {
		images.put(ImageService.SHOES, getShoesContainer());
		images.put(ImageService.HANDBAG, getHandBagContainer());
	}

	private static ImageContainer getHandBagContainer() {
		List<Image> imgList = new LinkedList<>();
		Image img = new Image(0, "images/Tasche 1.jpg", "Tasche");
		img.setUrlSmall("images/Tasche 1.jpg");
		img.setActive(true);
		imgList.add(img);
		Image img2 = new Image(1, "images/tasche filet.jpg", "Tasche");
		img2.setUrlSmall("images/tasche filet.jpg");
		img2.setActive(true);
		imgList.add(img2);
		ImageBundle bundle = new ImageBundle("handbags", imgList.toArray(new Image[0]));
		ImageContainer img_cont = new ImageContainer();
		img_cont.add(bundle);
		return img_cont;
	}

	private static ImageContainer getShoesContainer() {
		List<Image> imgList = new LinkedList<>();
		Image img = new Image(0, "images/gruen_Bl.jpg", "Grün mit Blume");
		img.setUrlSmall("images/gruen_Bl.jpg");
		img.setActive(true);
		imgList.add(img);
		Image img2 = new Image(1, "images/maeuse.jpg", "Mäuseschuhe");
		img2.setUrlSmall("images/maeuse.jpg");
		img2.setActive(true);
		imgList.add(img2);
		Image img3 = new Image(2, "images/Schuhe grau.jpg", "Schuhe grau");
		img3.setUrlSmall("images/Schuhe grau.jpg");
		img3.setActive(true);
		imgList.add(img3);
		Image img4 = new Image(3, "images/S hellbraun.jpg", "Schuhe hellbraun");
		img4.setUrlSmall("images/S hellbraun.jpg");
		img4.setActive(true);
		imgList.add(img4);
		Image img5 = new Image(4, "images/S. zebra.jpg", "Schuhe Zebra");
		img5.setUrlSmall("images/S. zebra.jpg");
		img5.setActive(true);
		imgList.add(img5);
		Image img6 = new Image(5, "images/schuhe mit punkten.jpg", "Schuhe mit punkten");
		img6.setUrlSmall("images/schuhe mit punkten.jpg");
		img6.setActive(false);
		imgList.add(img6);
		ImageBundle bundle = new ImageBundle("shoes_table", imgList.toArray(new Image[0]));
		ImageContainer img_cont = new ImageContainer();
		img_cont.add(bundle);
		return img_cont;
	}

	@Override
	public ImageContainer get(String id) throws IOException {
		return images.get(id);
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
