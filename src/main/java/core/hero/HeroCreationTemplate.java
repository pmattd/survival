package core.hero;

import com.google.inject.Inject;
import core.translations.Translations;

import static core.translations.TranslationConstants.HERO_CREATION_NAME_INPUT;
import static core.translations.TranslationConstants.HERO_CREATION_TITLE;

/**
 * Created by Pete on 31/05/2016.
 */
public class HeroCreationTemplate {

    private String nameInputTitle;
    private String templateTitle;

    @Inject
    public HeroCreationTemplate(Translations translations) {
        templateTitle = translations.getTranslation(HERO_CREATION_TITLE);
        nameInputTitle = translations.getTranslation(HERO_CREATION_NAME_INPUT);
    }

    public Hero build(String name){
        Hero hero = new Hero(name);
        return hero;
    }

    public String getTemplateTitle() {
        return templateTitle;
    }

    public String getNameInputTitle() {
        return nameInputTitle;
    }
}
