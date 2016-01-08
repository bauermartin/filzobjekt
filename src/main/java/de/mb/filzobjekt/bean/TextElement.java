package de.mb.filzobjekt.bean;

/**
 * @author MBauer
 *
 */
public class TextElement {

	private int id;
	private String template;
	private String value;

	public TextElement(int id, String template, String value) {
		super();
		this.id = id;
		this.template = template;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public String getTemplate() {
		return template;
	}

	public String getValue() {
		return value;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
