package core.config.builder.travel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import core.area.travel.Direction;
import core.area.travel.TravelInterceptor;
import core.config.builder.AreaFactory;
import core.config.builder.TextFactory;
import core.config.xml.areas.DirectionConfig;

/**
 * Created by Pete on 06/06/2016.
 */
@Singleton
public class DirectionBuilder {

    private final TextFactory textFactory;
    private final TravelInterceptor travelInterceptor;

    @Inject
    public DirectionBuilder(TextFactory textFactory, TravelInterceptor travelInterceptor) {
        this.textFactory = textFactory;

        this.travelInterceptor = travelInterceptor;
    }



    public Direction build(DirectionConfig directionConfig, AreaFactory areaFactory){

        return new Direction(
                textFactory.build(directionConfig.getText()),
                areaFactory.build(directionConfig.getArea()).getArrivalLocation(),
                travelInterceptor);
    }
}
