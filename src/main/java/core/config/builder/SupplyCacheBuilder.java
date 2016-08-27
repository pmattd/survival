package core.config.builder;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import core.area.supplies.SupplyCache;
import core.area.supplies.SupplyCacheFactory;
import core.config.xml.areas.SuppliesConfig;
import core.area.supplies.BasicSupplies;

@Singleton
public class SupplyCacheBuilder {

	private final TextFactory textFactory;
	private final SupplyCacheFactory supplyCacheFactory;

	@Inject
	public SupplyCacheBuilder(TextFactory textFactory, SupplyCacheFactory supplyCacheFactory) {
		this.textFactory = textFactory;
		this.supplyCacheFactory = supplyCacheFactory;
	}

	public SupplyCache build(SuppliesConfig suppliesConfig) {
		if(suppliesConfig == null){
			return supplyCacheFactory.emptyCache();
		}else{
			return supplyCacheFactory.build(
					new BasicSupplies(suppliesConfig.getFood(),
					textFactory.build(suppliesConfig.getScavengeText())));
		}
	}
}
