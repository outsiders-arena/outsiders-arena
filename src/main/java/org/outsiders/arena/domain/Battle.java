package org.outsiders.arena.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.List;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Battle
{
  @PrimaryKey
  private int id;
  private boolean playerOneStart = Math.random() % 2.0D == 0.0D;
  private String status;
  private int arenaId;
  private int playerIdOne;
  private int playerIdTwo;
  private List<CharacterInstance> playerOneTeam;
  private List<CharacterInstance> playerTwoTeam;
  private List<String> playerOneEnergy;
  private List<String> playerTwoEnergy;
  
  @JsonGetter
  public boolean getPlayerOneVictory()
  {
    for (CharacterInstance c : this.playerTwoTeam) {
      if (c.getHp() > 0) {
        return false;
      }
    }
    return true;
  }
  
  @JsonGetter
  public boolean getPlayerTwoVictory()
  {
    for (CharacterInstance c : this.playerOneTeam) {
      if (c.getHp() > 0) {
        return false;
      }
    }
    return true;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public int getArenaId()
  {
    return this.arenaId;
  }
  
  public void setArenaId(int arenaId)
  {
    this.arenaId = arenaId;
  }
  
  public boolean isPlayerOneStart()
  {
    return this.playerOneStart;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public int getPlayerIdOne()
  {
    return this.playerIdOne;
  }
  
  public void setPlayerIdOne(int playerIdOne)
  {
    this.playerIdOne = playerIdOne;
  }
  
  public int getPlayerIdTwo()
  {
    return this.playerIdTwo;
  }
  
  public void setPlayerIdTwo(int playerIdTwo)
  {
    this.playerIdTwo = playerIdTwo;
  }
  
  public List<CharacterInstance> getPlayerOneTeam()
  {
    return this.playerOneTeam;
  }
  
  public void setPlayerOneTeam(List<CharacterInstance> playerOneTeam)
  {
    this.playerOneTeam = playerOneTeam;
  }
  
  public List<CharacterInstance> getPlayerTwoTeam()
  {
    return this.playerTwoTeam;
  }
  
  public void setPlayerTwoTeam(List<CharacterInstance> playerTwoTeam)
  {
    this.playerTwoTeam = playerTwoTeam;
  }
  
  public List<String> getPlayerOneEnergy()
  {
    return this.playerOneEnergy;
  }
  
  public void setPlayerOneEnergy(List<String> playerOneEnergy)
  {
    this.playerOneEnergy = playerOneEnergy;
  }
  
  public List<String> getPlayerTwoEnergy()
  {
    return this.playerTwoEnergy;
  }
  
  public void setPlayerTwoEnergy(List<String> playerTwoEnergy)
  {
    this.playerTwoEnergy = playerTwoEnergy;
  }
  
  public void setPlayerOneStart(boolean playerOneStart)
  {
    this.playerOneStart = playerOneStart;
  }
  
  public String toString()
  {
    return "Battle [id=" + this.id + ", playerOneStart=" + this.playerOneStart + ", status=" + this.status + ", playerIdOne=" + this.playerIdOne + ", playerIdTwo=" + this.playerIdTwo + ", playerOneTeam=" + this.playerOneTeam + ", playerTwoTeam=" + this.playerTwoTeam + ", playerOneEnergy=" + this.playerOneEnergy + ", playerTwoEnergy=" + this.playerTwoEnergy + "]";
  }
}
