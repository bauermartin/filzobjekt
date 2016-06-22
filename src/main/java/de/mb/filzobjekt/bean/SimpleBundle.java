package de.mb.filzobjekt.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin Bauer (22.06.2016)
 *
 */
public abstract class SimpleBundle<T> {

	private String id;
	protected List<T> content = new LinkedList<>();

	public SimpleBundle(String id, T[] arr) {
		this.id = id;
		for (T t : arr) {
			content.add(t);
		}
	}

	@Override
	public String toString() {
		return "SimpleBundle [id=" + id + ", content=" + content + "]";
	}

	public String getId() {
		return id;
	}

	public abstract T[] getAll();
}
