package org.outsiders.arena.controller;

import java.util.concurrent.ThreadLocalRandom;
import org.outsiders.arena.domain.Player;
import org.outsiders.arena.domain.PlayerMessage;
import org.outsiders.arena.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController
{
  @Autowired
  private PlayerService playerService;
  
  @RequestMapping(value={"/api/player/"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public Player getOrCreatePlayer(PlayerMessage message)
  {
    Player player;
    try
    {
      player = this.playerService.findByDisplayName(message.getDisplayName());
    }
    catch (Exception e)
    {
      player = new Player();
      player.setDisplayName(message.getDisplayName());
      player.setAvatarUrl(message.getAvatarUrl());
      int randomNum = ThreadLocalRandom.current().nextInt(0, 100000000);
      player.setId(randomNum);
    }
    player.setCurrentArena(message.getCurrentArena());
    player = this.playerService.save(player);
    return player;
  }
  
  @RequestMapping(value={"/api/player/arena/{playerId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public int getArenaForPlayer(@PathVariable int playerId) {
  		return this.playerService.findById(playerId).get().getCurrentArena();
  }
}
