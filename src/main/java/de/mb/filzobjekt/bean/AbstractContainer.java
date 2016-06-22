package de.mb.filzobjekt.bean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Martin Bauer (22.06.2016)
 *
 * @param <T>
 */
public abstract class AbstractContainer<T extends SimpleBundle<?>> {

	protected Map<String, T> content = new LinkedHashMap<>();

	public abstract T[] getAllBundles();

	public T getBundleByID(String id) {
		if (id == null) {
			return null;
		}
		return content.get(id);
	}

	@Override
	public String toString() {
		return "AbstractContainer [content=" + content + "]";
	}

	public void add(T bundle) {
		if (bundle != null) {
			content.put(bundle.getId(), bundle);
		}
	}
	
	public void add(){}
}
