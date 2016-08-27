package core.config.xml.areas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import core.config.xml.narrative.interaction.TextConfig;

@XmlRootElement(name = "supplies")
@XmlAccessorType(XmlAccessType.NONE)
public class SuppliesConfig {

	@XmlElement(name="food")
	private int food;

	@XmlElement(name="scavenge-text")
	private TextConfig scavengeText;

	public int getFood() {
		return food;
	}

	public TextConfig getScavengeText() {
		return scavengeText;
	}
}
