package ui.commandline;

import core.hero.HeroCreationTemplate;
import core.hero.Hero;

/**
 * Created by Pete on 31/05/2016.
 */
public class HeroCreation {
    private final HeroCreationTemplate template;

    public HeroCreation(HeroCreationTemplate template) {
        this.template = template;
    }

    public void display(){
        System.out.println(template.getTemplateTitle());
        System.out.println(template.getNameInputTitle());
    }

    public Hero build(String name) {
        return template.build(name);
    }
}
