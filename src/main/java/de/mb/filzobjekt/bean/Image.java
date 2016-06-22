package de.mb.filzobjekt.bean;

/**
 * @author Martin Bauer (20.01.2016)
 *
 */
public class Image {

	public int id;
	public String url;
	public String name;
	public String description;

	public Image(int id, String url, String name) {
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", url=" + url + "]";
	}
	
	
}
