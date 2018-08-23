package org.outsiders.arena.domain;

public class PlayerMessage
{
  private String displayName;
  private String avatarUrl;
  private int currentArena;
  
  public int getCurrentArena()
  {
    return this.currentArena;
  }
  
  public void setCurrentArena(int currentArena)
  {
    this.currentArena = currentArena;
  }
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public void setDisplayName(String displayName)
  {
    this.displayName = displayName;
  }
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public void setAvatarUrl(String avatarUrl)
  {
    this.avatarUrl = avatarUrl;
  }
}
