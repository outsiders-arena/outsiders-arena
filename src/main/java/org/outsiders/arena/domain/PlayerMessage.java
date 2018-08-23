package org.outsiders.arena.domain;

public class PlayerMessage
{
  private String displayName;
  private int playerId;
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
  
  public int getPlayerId()
  {
    return this.playerId;
  }
  
  public void setPlayerId(int playerId)
  {
    this.playerId = playerId;
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
