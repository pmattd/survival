package core.area.supplies;

import com.google.inject.Inject;

/**
 * Created by Pete on 30/07/2016.
 */
public class SupplyCacheFactory {

    private final NoSupplies noSupplies;
    private final SupplyCache emptyCache;

    @Inject
    private SupplyCacheFactory(NoSupplies noSupplies) {
        this.noSupplies = noSupplies;
        emptyCache = SupplyCache.emptyCache(noSupplies);
    }

    public SupplyCache build(Supplies supplies){
        return new SupplyCache(supplies,noSupplies);
    }

    public SupplyCache emptyCache(){
        return emptyCache;
    }
}
