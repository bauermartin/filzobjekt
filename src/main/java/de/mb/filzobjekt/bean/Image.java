package de.mb.filzobjekt.bean;

/**
 * @author Martin Bauer (20.01.2016)
 *
 */
public class Image {

	private int id;
	private String url;
	private String name;
	private String description;
	private String url_small;
	private boolean active = true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Image(int id, String url, String name) {
		this.id = id;
		this.setName(name);
		this.url = url;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", url=" + url + "]";
	}

	public String getUrlSmall() {
		return url_small;
	}

	public void setUrlSmall(String url_small) {
		this.url_small = url_small;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
