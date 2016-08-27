package core.config.builder;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import core.area.Area;
import core.area.BasicLocation;
import core.area.Location;
import core.area.relocation.RelocationOptionsFactory;
import core.area.travel.ArrivalAction;
import core.area.travel.ArrivalActionFactory;
import core.config.builder.travel.TravelOptionsFactory;
import core.config.xml.areas.LocationConfig;
import core.dialog.DialogStore;
import core.dialog.Interaction;
import org.apache.commons.lang.StringUtils;

import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Pete on 15/06/2016.
 */
@Singleton
public class LocationFactory {
    private final TextFactory textFactory;
    private final SupplyCacheBuilder supplyCacheBuilder;
    private final DialogStore dialogStore;
    private final ArrivalActionFactory arrivalActionFactory;
    private final TravelOptionsFactory travelOptionsFactory;
    private final RelocationOptionsFactory relocationOptionsFactory;

    @Inject
    public LocationFactory(TextFactory textFactory,
                           SupplyCacheBuilder supplyCacheBuilder,
                           DialogStore dialogStore,
                           ArrivalActionFactory arrivalActionFactory,
                           TravelOptionsFactory travelOptionsFactory, RelocationOptionsFactory relocationOptionsFactory) {

        this.textFactory = textFactory;
        this.supplyCacheBuilder = supplyCacheBuilder;
        this.dialogStore = dialogStore;
        this.arrivalActionFactory = arrivalActionFactory;
        this.travelOptionsFactory = travelOptionsFactory;
        this.relocationOptionsFactory = relocationOptionsFactory;
    }

    public Location build(LocationConfig locationConfig, Area area){

        Optional<Interaction> arrivalEvent = StringUtils.isBlank(locationConfig.getArrivalEvent())?
                Optional.empty() :
                Optional.of(dialogStore.getDialogById(locationConfig.getArrivalEvent()).getFirstInteraction());

        ArrivalAction arrivalAction = arrivalActionFactory.build(arrivalEvent);


        return new BasicLocation(
                textFactory.build(locationConfig.getTitle()),
                textFactory.build(locationConfig.getDesc()),
                area,
                supplyCacheBuilder.build(locationConfig.getSupplies()),
                arrivalAction,
                travelOptionsFactory.buildTravelOptions(area),
                relocationOptionsFactory);
    }

}
