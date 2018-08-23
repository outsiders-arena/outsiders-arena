package org.outsiders.arena.domain;

import java.util.Collections;
import java.util.Map;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class Effect
{
  private int duration = 1;
  private String name;
  private boolean interruptable = false;
  private boolean physical = false;
  private boolean magical = false;
  private Map<String, Integer> statMods = Collections.emptyMap();
  private Map<String, Boolean> qualityMods = Collections.emptyMap();
  
  public Effect() {}
  
  public Effect(boolean physical, boolean magical, boolean interruptable)
  {
    this.physical = physical;
    this.magical = magical;
    this.interruptable = interruptable;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
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
  
  public Map<String, Boolean> getQualityMods()
  {
    return this.qualityMods;
  }
  
  public void setQualityMods(Map<String, Boolean> qualityMods)
  {
    this.qualityMods = qualityMods;
  }
}
