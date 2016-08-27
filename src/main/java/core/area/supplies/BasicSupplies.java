package core.area.supplies;

public class BasicSupplies implements Supplies {
	private final int food;
	private final String scavengeText;

	public BasicSupplies(int food, String scavengeText) {
		this.food = food;
		this.scavengeText = scavengeText;
	}

	@Override
	public int getFood() {
		return food;
	}

	@Override
	public String getScavengeText() {
		return scavengeText;
	}
}
