package core.config.parser;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.util.List;

import core.config.xml.hostiles.GroupMemberConfig;
import core.config.xml.hostiles.HostileConfig;
import core.config.xml.hostiles.HostileGroupConfig;
import org.junit.Before;
import org.junit.Test;

import core.config.xml.Configuration;
import core.config.xml.areas.AreaConfig;
import core.config.xml.narrative.DialogConfig;
import core.config.xml.narrative.interaction.InteractionConfig;
import core.config.xml.translations.TranslationConfig;

/**
 * Created by Pete on 21/05/2016.
 */
public class ConfigParserTest {

    ConfigParser parser;

    ClassLoader classLoader;

    File narrativesFile;
    File translationsFile;
    File coreTranslationsFile;
    File locationMapFile;
    File hostilesFile;

    Configuration configuration;
    @Before
    public void setup() {
        parser = new ConfigParser();
        classLoader = getClass().getClassLoader();
        narrativesFile = new File(classLoader.getResource("narrative/narrative_test.xml").getFile());
        translationsFile = new File(classLoader.getResource("translations/translations_test.xml").getFile());
        coreTranslationsFile = new File(classLoader.getResource("translations/core_translations_test.xml").getFile());
        locationMapFile = new File(classLoader.getResource("area/area-map_test.xml").getFile());
        hostilesFile = new File(classLoader.getResource("hostiles/hostiles_test.xml").getFile());
        configuration = parser.readConfiguration(narrativesFile,coreTranslationsFile, translationsFile, locationMapFile,hostilesFile);
    }

    @Test
    public void readNarratives() {
        List<DialogConfig> dialogConfigList = configuration.getNarrativeConfig().getDialogs();
        assertThat(dialogConfigList).hasSize(2);

    }

    @Test
    public void readDialogText(){
        DialogConfig dialogConfigList = configuration.getNarrativeConfig().getDialogs().get(0);
        assertThat(dialogConfigList.getId()).isEqualTo("dia1");
        assertThat(dialogConfigList.getStart().getId()).isEqualTo("step1");
        assertThat(dialogConfigList.getStart().getChoiceConfig().getText().getDefaultText()).isEqualTo("Will you eat the berries");
        assertThat(dialogConfigList.getStart().getChoiceConfig().getText().getTranslationKey()).isEqualTo("inter.berries");
        assertThat(dialogConfigList.getStart().getChoiceConfig().getOptions()).hasSize(2);
        assertThat(dialogConfigList.getStart().getChoiceConfig().getOptions().get(0).getText().getDefaultText()).isEqualTo("I will");
        assertThat(dialogConfigList.getStart().getChoiceConfig().getOptions().get(0).getNextInteraction().getSimpleTextConfig().getText().getDefaultText()).isEqualTo("you die horribly");
        assertThat(dialogConfigList.getStart().getChoiceConfig().getOptions().get(0).getNextInteraction().getSimpleTextConfig().getNextInteraction().getSimpleTextConfig().getText().getDefaultText()).isEqualTo("the end");

        InteractionConfig interactionPath1 = dialogConfigList.getStart().getChoiceConfig().getOptions().get(0).getNextInteraction().getSimpleTextConfig().getNextInteraction();
        InteractionConfig interactionPath2 = dialogConfigList.getStart().getChoiceConfig().getOptions().get(1).getNextInteraction().getSimpleTextConfig().getNextInteraction();

        assertThat(interactionPath1).isEqualTo(interactionPath2);
    }


    @Test
    public void readDialogCombat(){
        DialogConfig dialogConfigList = configuration.getNarrativeConfig().getDialogs().get(1);
        assertThat(dialogConfigList.getId()).isEqualTo("petrolStation");

        assertThat(dialogConfigList.getStart().getCombatConfig().getText().getDefaultText()).isEqualTo("you see some hostiles");
        assertThat(dialogConfigList.getStart().getCombatConfig().getHostileGroupReference()).isEqualTo("petrolCombat");

    }


    @Test
    public void readTranslations() {
        List<TranslationConfig> translationConfigs = configuration.getAllTranslationsConfig().getTranslationConfigs();
        assertThat(translationConfigs.get(0).getKey()).isEqualTo("button.next");
        assertThat(translationConfigs.get(0).getTranslation()).isEqualTo("continue");
    }


    @Test
    public void readAreas() {
        List<AreaConfig> areas = configuration.getAreaMapConfig().getAreaConfigs();
        assertThat(areas.get(0).getDesc().getDefaultText()).isEqualTo("The city of london");
        assertThat(areas.get(0).getDirections().get(0).getText().getDefaultText()).isEqualTo("you can head to north london to visit nick");
        assertThat(areas.get(0).getDirections().get(0).getArea()).isNotNull();
        assertThat(areas.get(0).getTitle().getDefaultText()).isEqualTo("London");


        AreaConfig location = configuration.getAreaMapConfig().getLocationStart();
        assertThat(location).isNotNull();
    }



    @Test
    public void readLocations() {
        List<AreaConfig> areas = configuration.getAreaMapConfig().getAreaConfigs();

        assertThat(areas.get(0).getLocations()).hasSize(2);
        assertThat(areas.get(0).getLocations().get(0).getDesc().getDefaultText()).isEqualTo("pharmacy");
        assertThat(areas.get(0).getLocations().get(0).getTitle().getDefaultText()).isEqualTo("pharmacyTitle");
    }



    @Test
    public void readSupplies() {
        List<AreaConfig> areas = configuration.getAreaMapConfig().getAreaConfigs();

        assertThat(areas.get(0).getLocations().get(0).getSupplies()).isEqualTo(null);
        assertThat(areas.get(1).getLocations().get(0).getSupplies().getFood()).isEqualTo(5);
        assertThat(areas.get(1).getLocations().get(0).getSupplies().getScavengeText().getDefaultText()).isEqualTo("scavengeText");
    }

    @Test
    public void readHostileGroups(){
        List<HostileGroupConfig> hostileGroups = configuration.getHostilesConfig().getHostileGroups();
        assertThat(hostileGroups.get(0).getGroupMembers()).hasSize(1);
    }


    @Test
    public void readHostileGroupMembers(){
        GroupMemberConfig groupMember = configuration.getHostilesConfig().getHostileGroups().get(0).getGroupMembers().get(0);
        assertThat(groupMember.getQty()).isEqualTo(5);
    }

    @Test
    public void readHostiles(){
        HostileConfig hostileGroups = configuration.getHostilesConfig().getHostileGroups().get(0).getGroupMembers().get(0).getHostileConfig();
        assertThat(hostileGroups.getDefaultName()).isEqualTo("man");
        assertThat(hostileGroups.getHealth()).isEqualTo(5);
    }



}