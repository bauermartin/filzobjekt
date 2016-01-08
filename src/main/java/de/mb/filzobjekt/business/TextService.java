package de.mb.filzobjekt.business;

import org.springframework.stereotype.Service;
import de.mb.filzobjekt.bean.TextElement;

/**
 * @author MBauer
 *
 */
@Service
public class TextService implements ITextService {

	@Override
	public boolean saveText(TextElement elem) {
		System.out.println("test");
		return false;
	}

}
