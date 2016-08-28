package core.boundary.options;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.translations.TranslationConstants;
import core.translations.Translations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import static com.google.common.collect.Maps.newHashMap;
import static core.boundary.options.OptionCatagoryEnum.*;
import static core.translations.TranslationConstants.*;

@Singleton
public class InterfaceOptionsStore {

	private HashMap<OptionCatagoryEnum,OptionCategory> interfaceOptions;

	private Logger logger = LoggerFactory.getLogger(InterfaceOptionsStore.class);

	@Inject
	public InterfaceOptionsStore(Translations translations){

		interfaceOptions = newHashMap();
		interfaceOptions.put(DIALOG,new OptionCategory(DIALOG, translations.getTranslation(OPTIONS_DIALOG)));
		interfaceOptions.put(TRAVEL,new OptionCategory(TRAVEL,translations.getTranslation(OPTIONS_TRAVEL)));
		interfaceOptions.put(RELOCATE,new OptionCategory(RELOCATE,translations.getTranslation(OPTIONS_RELOCATE)));
		interfaceOptions.put(CREATEHERO,new OptionCategory(CREATEHERO,translations.getTranslation(OPTIONS_CREATE_HERO)));
		interfaceOptions.put(SCAVENGE,new OptionCategory(SCAVENGE,translations.getTranslation(OPTIONS_SCAVENGE)));
		interfaceOptions.put(SCAVENGE_COLLECT,new OptionCategory(SCAVENGE_COLLECT,translations.getTranslation(TranslationConstants.OPTIONS_SCAVENGE_COLLECT)));
		interfaceOptions.put(QUIT,new OptionCategory(QUIT,translations.getTranslation(TranslationConstants.OPTIONS_QUIT)));

		interfaceOptions.put(SPECIALIZED_HERO_CREATION,new OptionCategory(SPECIALIZED_HERO_CREATION,"shouldn't be shown"));
        interfaceOptions.put(SPECIALIZED_INVENTORY, new OptionCategory(SPECIALIZED_INVENTORY, "shouldn't be shown"));
    }

	public OptionCategory getOption(OptionCatagoryEnum option){
		OptionCategory optionCategory = interfaceOptions.get(option);
		if(optionCategory == null){
			 OptionDoesNotExistException ex = new OptionDoesNotExistException(String.format("option %s is not in the interface option store",option.name()));
			logger.error(ex.toString());
			throw(ex);
		}
		return optionCategory;
	}


}
