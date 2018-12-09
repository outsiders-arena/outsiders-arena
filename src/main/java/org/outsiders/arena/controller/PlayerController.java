package org.outsiders.arena.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import org.outsiders.arena.domain.Player;
import org.outsiders.arena.domain.Character;
import org.outsiders.arena.domain.PlayerMessage;
import org.outsiders.arena.service.CharacterService;
import org.outsiders.arena.service.PlayerService;
import org.outsiders.arena.util.SortById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController
{
  @Autowired
  private PlayerService playerService;
  
  @Autowired
  private CharacterService characterService;
  
  // player name - arena id
  private Map<String, Integer> privateMatchMaking = new HashMap<>();
  
  // player name - level
  private Map<String, Integer> publicMatchMaking = new HashMap<>();
  
  @RequestMapping(value={"/api/player/"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public Player getOrCreatePlayer(PlayerMessage message)
  {

    	Player player = this.playerService.findByDisplayName(message.getDisplayName());
    	if (player != null) {
    	      return player;
    	} else {
    		player = new Player();
    	      player.setDisplayName(message.getDisplayName());
    	      player.setAvatarUrl(message.getAvatarUrl());
    	      int randomNum = ThreadLocalRandom.current().nextInt(0, 100000000);
    	      player.setId(randomNum);
    	      player = this.playerService.save(player);
    	}

      return player;

  }
  
  @RequestMapping(value={"/api/player/arena/{playerId}/{opponentName}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public int getArenaForPlayer(@PathVariable int playerId, @PathVariable String opponentName) {
	  if (privateMatchMaking.get(opponentName) != null) {
		  int arenaId = privateMatchMaking.get(opponentName);
		  privateMatchMaking.remove(opponentName);
		  return arenaId;
	  } else {
	      int randomNum = ThreadLocalRandom.current().nextInt(10000000, 99999999);
		  privateMatchMaking.put(playerService.findById(playerId).get().getDisplayName(), randomNum);
		  return randomNum;
	  }
  }
  
  @RequestMapping(value={"/api/character/"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<Character> getAllCharacters() {
	  List<Character> list = new ArrayList<Character>();
	  characterService.findAll().forEach(list::add);
	  list.sort(new SortById());
	  return list;
  }
}
