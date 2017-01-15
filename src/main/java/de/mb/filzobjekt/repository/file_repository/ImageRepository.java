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
import de.mb.filzobjekt.util.JSONMapper;

/**
 * @author Martin Bauer (21.06.2016)
 *
 */
@Controller
public class ImageRepository implements IImageRepository {

	private static final JSONMapper mapper = new JSONMapper();

	// private final String IMAGES_JSON_FILE_PATH = "/opt/filzobjekt/images";
	private final String IMAGES_JSON_FILE_PATH = "C:\\Users\\bauer\\workspace\\de.mb.filzobjekt\\opt\\filzobjekt\\images";
	private final String SHOES_JSON_FILE_PATH = "shoes.json";
	private final String HANDBAG_JSON_FILE_PATH = "handbag.json";
	private final String OBJECT_JSON_FILE_PATH = "object.json";
	private final String WALLHANGING_JSON_FILE_PATH = "wallhanging.json";
	private final String GABI_JSON_FILE_PATH = "gabi.json";
	private final String SEAT_PAT_JSON_FILE_PATH = "seat_pad.json";

	private Map<String, ImageContainer> images = new HashMap<String, ImageContainer>();
	private Map<String, String> imagePathMap = new HashMap<String, String>();

	public ImageRepository() {
		imagePathMap.put(ImageService.GABI, IMAGES_JSON_FILE_PATH + File.separator + GABI_JSON_FILE_PATH);
		imagePathMap.put(ImageService.SHOES, IMAGES_JSON_FILE_PATH + File.separator + SHOES_JSON_FILE_PATH);
		imagePathMap.put(ImageService.OBJECT, IMAGES_JSON_FILE_PATH + File.separator + OBJECT_JSON_FILE_PATH);
		imagePathMap.put(ImageService.WALL_HANGING,
				IMAGES_JSON_FILE_PATH + File.separator + WALLHANGING_JSON_FILE_PATH);
		imagePathMap.put(ImageService.HANDBAG, IMAGES_JSON_FILE_PATH + File.separator + HANDBAG_JSON_FILE_PATH);
		imagePathMap.put(ImageService.SEAT_PAD, IMAGES_JSON_FILE_PATH + File.separator + SEAT_PAT_JSON_FILE_PATH);
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
			} catch (IOException e) {
			}
			if (imgCont == null) {
				System.out.println("File not found for Id[" + id + "] use default configuration!");
				imgCont = getDefault(id);
			}
		}
		return imgCont;
	}

	private static Map<String, String> defaultConfig = new HashMap<>();
	static {
		defaultConfig.put(ImageService.GABI,
				"{\"allBundles\":{\"profile\":{\"id\":\"profile\",\"images\":[{\"id\":0,\"url\":\"images/gabi_bauer.jpg\",\"name\":\"Gabi Bauer\",\"active\":true,\"urlSmall\":\"images/gabi_bauer.jpg\"}]}}}");
		defaultConfig.put(ImageService.HANDBAG,
				"{\"allBundles\":{\"handbags\":{\"id\":\"handbags\",\"images\":[{\"id\":0,\"url\":\"images/t_1.jpg\",\"name\":\"Tasche\",\"active\":true,\"urlSmall\":\"images/t_1.jpg\"},{\"id\":1,\"url\":\"images/t_filet.jpg\",\"name\":\"Tasche\",\"active\":true,\"urlSmall\":\"images/t_filet.jpg\"},{\"id\":2,\"url\":\"images/t_fil.jpg\",\"name\":\"Tasche\",\"active\":true,\"urlSmall\":\"images/t_fil.jpg\"}]}}}");
		defaultConfig.put(ImageService.OBJECT,
				"{\"allBundles\":{\"objects\":{\"id\":\"objects\",\"images\":[{\"id\":0,\"url\":\"images/ku1.jpg\",\"name\":\"Brunnen\",\"active\":true,\"urlSmall\":\"images/ku1.jpg\"},{\"id\":1,\"url\":\"images/ku2.jpg\",\"name\":\"Turm\",\"active\":true,\"urlSmall\":\"images/ku2.jpg\"},{\"id\":1,\"url\":\"images/o1.jpg\",\"name\":\"Becher\",\"active\":true,\"urlSmall\":\"images/o1.jpg\"}]}}}");
		defaultConfig.put(ImageService.SEAT_PAD,
				"{\"allBundles\":{\"row1\":{\"id\":\"row1\",\"images\":[{\"id\":0,\"url\":\"images/kiq1.jpg\",\"name\":\"Kissen1\",\"active\":true,\"urlSmall\":\"images/kiq1.jpg\"},{\"id\":1,\"url\":\"images/kir2.jpg\",\"name\":\"Kissen2\",\"active\":true,\"urlSmall\":\"images/kir2.jpg\"},{\"id\":2,\"url\":\"images/kiq11.jpg\",\"name\":\"Kissen3\",\"active\":true,\"urlSmall\":\"images/kiq11.jpg\"},{\"id\":3,\"url\":\"images/kiq12.jpg\",\"name\":\"Kissen4\",\"active\":true,\"urlSmall\":\"images/kiq12.jpg\"}]},\"row2\":{\"id\":\"row2\",\"images\":[{\"id\":4,\"url\":\"images/kir10.jpg\",\"name\":\"Kissen5\",\"active\":true,\"urlSmall\":\"images/kir10.jpg\"},{\"id\":5,\"url\":\"images/kir7.jpg\",\"name\":\"Kissen6\",\"active\":true,\"urlSmall\":\"images/kir7.jpg\"},{\"id\":6,\"url\":\"images/kir8.jpg\",\"name\":\"Kissen7\",\"active\":true,\"urlSmall\":\"images/kir8.jpg\"},{\"id\":7,\"url\":\"images/kir13.jpg\",\"name\":\"Kissen8\",\"active\":true,\"urlSmall\":\"images/kir13.jpg\"}]},\"row3\":{\"id\":\"row3\",\"images\":[{\"id\":8,\"url\":\"images/kir3.jpg\",\"name\":\"Kissen9\",\"active\":true,\"urlSmall\":\"images/kir3.jpg\"},{\"id\":9,\"url\":\"images/kir4.jpg\",\"name\":\"Kissen10\",\"active\":true,\"urlSmall\":\"images/kir4.jpg\"},{\"id\":10,\"url\":\"images/kir5.jpg\",\"name\":\"Kissen11\",\"active\":true,\"urlSmall\":\"images/kir5.jpg\"},{\"id\":11,\"url\":\"images/kir6.jpg\",\"name\":\"Kissen12\",\"active\":true,\"urlSmall\":\"images/kir6.jpg\"}]}}}");
		defaultConfig.put(ImageService.SHOES,
				"{\"allBundles\":{\"shoes_table\":{\"id\":\"shoes_table\",\"images\":[{\"id\":0,\"url\":\"images/sch1.jpg\",\"name\":\"Schuhe1\",\"active\":true,\"urlSmall\":\"images/sch1a.jpg\"},{\"id\":1,\"url\":\"images/sch2.jpg\",\"name\":\"Schuhe2\",\"active\":true,\"urlSmall\":\"images/sch2a.jpg\"},{\"id\":2,\"url\":\"images/sch3.jpg\",\"name\":\"Schuhe3\",\"active\":true,\"urlSmall\":\"images/sch3a.jpg\"},{\"id\":3,\"url\":\"images/sch4.jpg\",\"name\":\"Schuhe4\",\"active\":true,\"urlSmall\":\"images/sch4a.jpg\"},{\"id\":4,\"url\":\"images/sch5.jpg\",\"name\":\"Schuhe5\",\"active\":false,\"urlSmall\":\"images/sch5a.jpg\"},{\"id\":5,\"url\":\"images/sch6.jpg\",\"name\":\"Schuhe6\",\"active\":false,\"urlSmall\":\"images/sch6a.jpg\"},{\"id\":6,\"url\":\"images/sch7.jpg\",\"name\":\"Schuhe7\",\"active\":false,\"urlSmall\":\"images/sch7a.jpg\"},{\"id\":7,\"url\":\"images/sch8.jpg\",\"name\":\"Schuhe8\",\"active\":false,\"urlSmall\":\"images/sch8a.jpg\"},{\"id\":8,\"url\":\"images/sch9.jpg\",\"name\":\"Schuhe9\",\"active\":false,\"urlSmall\":\"images/sch9a.jpg\"}]}}}");
		defaultConfig.put(ImageService.WALL_HANGING,
				"{\"allBundles\":{\"wall_hangings\":{\"id\":\"wall_hangings\",\"images\":[{\"id\":0,\"url\":\"images/wa3.jpg\",\"name\":\"Wandbehang1\",\"active\":true,\"urlSmall\":\"images/wa3.jpg\"},{\"id\":1,\"url\":\"images/wa1.jpg\",\"name\":\"Wandbehang2\",\"active\":true,\"urlSmall\":\"images/wa1.jpg\"},{\"id\":2,\"url\":\"images/wa4.jpg\",\"name\":\"Wandbehang3\",\"active\":true,\"urlSmall\":\"images/wa4.jpg\"},{\"id\":3,\"url\":\"images/wa7.jpg\",\"name\":\"Wandbehang4\",\"active\":true,\"urlSmall\":\"images/wa7.jpg\"}]}}}");

	}

	private ImageContainer getDefault(String id) {
		String s = defaultConfig.get(id);
		ImageContainer cont = null;
		try {
			cont = mapper.readValue(s, ImageContainer.class);
		} catch (IOException e) {
		}
		if (cont == null) {
			// TODO throw error!!
			cont = new ImageContainer();
		}
		return cont;
	}

	@Override
	public void create(Image img) throws IOException {

	}

	@Override
	public void update(String id, Image img) {
		// TODO Auto-generated method stub

	}

}
