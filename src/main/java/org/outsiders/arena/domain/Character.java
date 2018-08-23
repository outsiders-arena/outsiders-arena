package org.outsiders.arena.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Character
{
  @PrimaryKey
  private int id;
  private String avatarUrl;
  private String name;
  private Ability slot1;
  private Ability slot2;
  private Ability slot3;
  private Ability slot4;
  private Ability slota;
  private Ability slotb;
  private Ability slotc;
  private Ability slotd;
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public void setAvatarUrl(String avatarUrl)
  {
    this.avatarUrl = avatarUrl;
  }
  
  public Ability getSlot1()
  {
    return this.slot1;
  }
  
  public void setSlot1(Ability slot1)
  {
    this.slot1 = slot1;
  }
  
  public Ability getSlot2()
  {
    return this.slot2;
  }
  
  public void setSlot2(Ability slot2)
  {
    this.slot2 = slot2;
  }
  
  public Ability getSlot3()
  {
    return this.slot3;
  }
  
  public void setSlot3(Ability slot3)
  {
    this.slot3 = slot3;
  }
  
  public Ability getSlot4()
  {
    return this.slot4;
  }
  
  public void setSlot4(Ability slot4)
  {
    this.slot4 = slot4;
  }
  
  public Ability getSlota()
  {
    return this.slota;
  }
  
  public void setSlota(Ability slota)
  {
    this.slota = slota;
  }
  
  public Ability getSlotb()
  {
    return this.slotb;
  }
  
  public void setSlotb(Ability slotb)
  {
    this.slotb = slotb;
  }
  
  public Ability getSlotc()
  {
    return this.slotc;
  }
  
  public void setSlotc(Ability slotc)
  {
    this.slotc = slotc;
  }
  
  public Ability getSlotd()
  {
    return this.slotd;
  }
  
  public void setSlotd(Ability slotd)
  {
    this.slotd = slotd;
  }
  
  public String toString()
  {
    return "Character [id=" + this.id + ", " + (this.avatarUrl != null ? "avatarUrl=" + this.avatarUrl + ", " : "") + (this.name != null ? "name=" + this.name + ", " : "") + (this.slot1 != null ? "slot1=" + this.slot1 + ", " : "") + (this.slot2 != null ? "slot2=" + this.slot2 + ", " : "") + (this.slot3 != null ? "slot3=" + this.slot3 + ", " : "") + (this.slot4 != null ? "slot4=" + this.slot4 + ", " : "") + (this.slota != null ? "slota=" + this.slota + ", " : "") + (this.slotb != null ? "slotb=" + this.slotb + ", " : "") + (this.slotc != null ? "slotc=" + this.slotc + ", " : "") + (this.slotd != null ? "slotd=" + this.slotd : "") + "]";
  }
}
