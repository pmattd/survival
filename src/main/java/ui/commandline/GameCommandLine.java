package ui.commandline;

import com.google.inject.Inject;
import core.area.LocationDescription;
import core.area.supplies.Supplies;
import core.boundary.GameCoreFacade;
import core.boundary.options.*;
import core.hero.InventoryTransferInterface;
import ui.framework.OptionBindings;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.System.exit;

public class GameCommandLine {

    private GameCoreFacade gameCoreFacade;

    private CommandLineOptionsDisplay commandLineOptionsDisplay;

    private CommandLineInteraction commandLineInteraction;

    @Inject
    public GameCommandLine(GameCoreFacade gameCoreFacade, CommandLineOptionsDisplay commandLineOptionsDisplay, CommandLineInteraction commandLineInteraction) {
        this.gameCoreFacade = gameCoreFacade;
        this.commandLineOptionsDisplay = commandLineOptionsDisplay;
        this.commandLineInteraction = commandLineInteraction;
    }


    public void run() {
        while (true) {
            displayLocationDescription();
            CategorisedOptions options = gameCoreFacade.getAllOptions();

            OptionCategory selectedOptionCategory = getSelectedOptionCategory(options);

            if (selectedOptionCategory.getOptionType() == OptionCatagoryEnum.SPECIALIZED_HERO_CREATION) {
                createHero();
            } else if (selectedOptionCategory.getOptionType() == OptionCatagoryEnum.SPECIALIZED_INVENTORY_TRANSFER) {
                inventoryTransfer();
                System.out.println("doin some inventory");
            } else {
                getAndExecuteSelectedOption(options.getOptionsByCategory(selectedOptionCategory));
            }
        }
    }

    private void inventoryTransfer() {
        //get the current inventory
        //get the found invenventory
        InventoryTransferInterface inventoryTransferInterface = gameCoreFacade.getInventoryTransferInterface();

        Supplies supplies = inventoryTransferInterface.getFoundSupplies();
        System.out.println("you have found :" + supplies.getScavengeText());
        getUserInput();
        //user input for which supplies and quantity or all


    }

    private OptionCategory getSelectedOptionCategory(CategorisedOptions options) {
        List<OptionCategory> optionCategories = options.getSortedCategories();

        if (optionCategories.size() == 1) {
            return optionCategories.iterator().next();
        } else {
            return getUserSelectedOptionCategory(optionCategories);
        }
    }

    private OptionCategory getUserSelectedOptionCategory(List<OptionCategory> options) {
        OptionBindings<OptionCategory> interfaceOptions = new OptionBindings<>(options);
        //todo bad
        commandLineOptionsDisplay.displayOptions(interfaceOptions, Optional.empty());
        Optional<OptionCategory> selectedOption = commandLineInteraction.getOptionCorrespondingToUserInput(interfaceOptions, getUserInput());

        return selectedOption.orElse(new OptionCategory(OptionCatagoryEnum.NOTHING, ""));
    }

    private void displayLocationDescription() {
        LocationDescription locationDescription = gameCoreFacade.getLocationDescription();
        if (org.apache.commons.lang.StringUtils.isNotEmpty(locationDescription.getAreaDescription())) {
            String header = locationDescription.getAreaDescription() + ":" + locationDescription.getLocationDescription();
            System.out.println(header);
        }
    }

    private void createHero() {
        HeroCreation heroCreation = new HeroCreation(gameCoreFacade.getHeroCreationTemplate());
        heroCreation.display();
        gameCoreFacade.createHeroAndStart(heroCreation.build(getUserInput()));
    }


    private void getAndExecuteSelectedOption(OptionList<ExecutableOption> options) {
        OptionBindings<ExecutableOption> boundOptions = commandLineInteraction.proposeOptions(options);
        commandLineInteraction.processExecutableOption(boundOptions, getUserInput());
    }

    private String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if ("quit".equals(input)) {
            exit(0);
        }
        return input;
    }

}
