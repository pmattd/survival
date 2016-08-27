package core.area.travel;

import java.util.Optional;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import core.area.Location;
import core.area.TemporaryLocation;
import core.area.supplies.SupplyCache;
import core.area.supplies.NoSupplies;
import core.area.supplies.SupplyCacheFactory;

@Singleton
public class TravelInterceptor {


	private final SupplyCacheFactory supplyCacheFactory;

	@Inject
	public TravelInterceptor(SupplyCacheFactory supplyCacheFactory) {
		this.supplyCacheFactory = supplyCacheFactory;
	}

	public Optional<Location> intercept(Direction direction){
		if(false){
			return Optional.of(new TemporaryLocation("text", null, direction, supplyCacheFactory.emptyCache()));
		}
		return Optional.empty();

	}


}
