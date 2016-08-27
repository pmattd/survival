package core.area.supplies;


public class SupplyCache {
    private Supplies supplies;
    private NoSupplies noSupplies;

    protected SupplyCache(Supplies supplies, NoSupplies noSupplies) {
        this.noSupplies = noSupplies;
        this.supplies = supplies;
    }

    protected static SupplyCache emptyCache(NoSupplies noSupplies){
        return new SupplyCache(noSupplies, noSupplies);
    }

    public Supplies getAndRemoveSupplies() {
        Supplies suppliesToReturn = supplies;
        supplies = noSupplies;
        return suppliesToReturn;
    }

    public String getScavengeText(){
        return supplies.getScavengeText();
    }

}
