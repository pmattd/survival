package core.config.builder.travel;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import core.area.Area;
import core.area.travel.Direction;
import core.area.travel.TravelActionFactory;
import core.boundary.options.ExecutableOption;
import core.boundary.options.OptionList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Pete on 08/08/2016.
 */
@Singleton
public class TravelOptionsFactory {

    private final TravelActionFactory travelActionFactory;

    @Inject
    public TravelOptionsFactory(TravelActionFactory travelActionFactory) {
        this.travelActionFactory = travelActionFactory;
    }

    public OptionList<ExecutableOption> buildTravelOptions(Area area){
        List<ExecutableOption> executableOptions = newArrayList();
        List<Direction> directions = area.getDirections();

        executableOptions.addAll(
                directions.stream()
                        .map(direction -> new ExecutableOption(
                                direction.getText(), travelActionFactory.build(direction)))
                        .collect(Collectors.toList()));

        return new OptionList<>(executableOptions);
    }
}
