package org.outsiders.arena.handler;

import java.util.HashMap;
import java.util.Map;
import org.outsiders.arena.handler.BattleMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleSocketHandler
  extends PrivateSocketHandler
{
  private Logger LOG = LoggerFactory.getLogger(BattleSocketHandler.class);
  @Autowired
  protected BattleMessageService battleMessageService;
  
  @Override
  public String processMapEntry(Map valueMap)
  {
    StringBuilder response = new StringBuilder();
    switch (valueMap.get("type").toString())
    {
    case "MATCH_MAKING": 
      this.LOG.info("Match Making...");
      return this.battleMessageService.handleMatchmakingMessage(valueMap);
    case "ENERGY_TRADE": 
      this.LOG.info("Energy Trade");
      return null;
    case "ABILITY_CHECK": 
      this.LOG.info("Ability Check");
      return null;
    case "TARGET_CHECK": 
      this.LOG.info("Target Check");
      return null;
    case "TURN_END": 
      this.LOG.info("Turn End");
      return null;
    }
    this.LOG.info("Unrecognized Message");
    return response.toString();
  }
}