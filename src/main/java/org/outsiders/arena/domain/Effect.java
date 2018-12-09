package org.outsiders.arena.domain;

import java.util.Collections;
import java.util.Map;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class Effect
{
  private int duration = 1;
  private String name;
  private String condition;
  private String quality;
  private String description;
  // only for effects on character instances (should be position based)
  private int originCharacter;
  private int targetCharacter;
  private boolean interruptable = false;
  private boolean physical = false;
  private boolean magical = false;
  private boolean conditional = false;
  private boolean visible = true;
  private Map<String, Integer> statMods = Collections.emptyMap();
  
  public Effect() {}
  
  public Effect(boolean physical, boolean magical, boolean interruptable, boolean conditional)
  {
    this.physical = physical;
    this.magical = magical;
    this.interruptable = interruptable;
    this.conditional = conditional;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }

	public boolean isConditional() {
		return conditional;
	}
	
	public void setConditional(boolean conditional) {
		this.conditional = conditional;
	}
	
	public void setInterruptable(boolean interruptable)
  {
    this.interruptable = interruptable;
  }
  
  public void setPhysical(boolean physical)
  {
    this.physical = physical;
  }
  
  public void setMagical(boolean magical)
  {
    this.magical = magical;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public void setDuration(int duration)
  {
    this.duration = duration;
  }
  
  public boolean isInterruptable()
  {
    return this.interruptable;
  }
  
  public boolean isPhysical()
  {
    return this.physical;
  }
  
  public boolean isMagical()
  {
    return this.magical;
  }
  
  public Map<String, Integer> getStatMods()
  {
    return this.statMods;
  }
  
  public void setStatMods(Map<String, Integer> statMods)
  {
    this.statMods = statMods;
  }



public int getOriginCharacter() {
	return originCharacter;
}

public void setOriginCharacter(int originCharacter) {
	this.originCharacter = originCharacter;
}

public int getTargetCharacter() {
	return targetCharacter;
}

public void setTargetCharacter(int targetCharacter) {
	this.targetCharacter = targetCharacter;
}

public String getCondition() {
	return condition;
}

public void setCondition(String condition) {
	this.condition = condition;
}

public String getQuality() {
	return quality;
}

public void setQuality(String quality) {
	this.quality = quality;
}

public boolean isVisible() {
	return visible;
}

public void setVisible(boolean visible) {
	this.visible = visible;
}
}
