package core.area.supplies;

import static core.translations.TranslationConstants.SCAVENGE_NO_SUPPLIES;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import core.translations.Translations;

@Singleton
public class NoSupplies implements Supplies {

	private final String scavengeText;

	@Inject
	public NoSupplies(Translations translations) {
		scavengeText = translations.getTranslation(SCAVENGE_NO_SUPPLIES);
	}

	@Override
	public int getFood() {
		return 0;
	}

	@Override
	public String getScavengeText() {
		return scavengeText;
	}
}
