package de.mb.filzobjekt.bean;

/**
 * @author Martin Bauer (22.06.2016)
 *
 */
public abstract class SimpleBean {

	private String id;
	private String name;

	public SimpleBean(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
