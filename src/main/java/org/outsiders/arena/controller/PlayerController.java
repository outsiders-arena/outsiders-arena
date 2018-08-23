package org.outsiders.arena.controller;

import java.util.concurrent.ThreadLocalRandom;
import org.outsiders.arena.domain.Player;
import org.outsiders.arena.domain.PlayerMessage;
import org.outsiders.arena.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
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
      player = this.playerService.findById(Integer.valueOf(message.getPlayerId())).get();
    }
    catch (Exception e)
    {
      player = new Player();
      player.setDisplayName(message.getDisplayName());
      player.setAvatarUrl(message.getAvatarUrl());
      int randomNum = ThreadLocalRandom.current().nextInt(0, 100000000);
      if (message.getPlayerId() != 0) {
        player.setId(message.getPlayerId());
      } else {
        player.setId(randomNum);
      }
      player.setCurrentArena(message.getCurrentArena());
      player = this.playerService.save(player);
    }
    return player;
  }
}
