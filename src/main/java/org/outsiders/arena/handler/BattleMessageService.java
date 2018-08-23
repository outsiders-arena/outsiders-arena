package org.outsiders.arena.handler;

import com.google.gson.Gson;
import java.lang.invoke.LambdaMetafactory;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.outsiders.arena.domain.Battle;
import org.outsiders.arena.domain.Character;
import org.outsiders.arena.domain.CharacterInstance;
import org.outsiders.arena.domain.Player;
import org.outsiders.arena.service.BattleService;
import org.outsiders.arena.service.CharacterService;
import org.outsiders.arena.handler.NRG;
import org.outsiders.arena.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
public class BattleMessageService {
    private static Logger LOG = LoggerFactory.getLogger(BattleMessageService.class);
    @Autowired
    protected BattleService battleService;
    @Autowired
    protected PlayerService playerService;
    @Autowired
    protected CharacterService characterService;
    @Autowired
    protected NRG nrg;

    public String handleMatchmakingMessage(Map valueMap, WebSocketSession session, List<WebSocketSession> sessions) {
        Integer opponentId;
        Battle savedBattle = null;
        Integer characterId1 = Integer.parseInt(valueMap.get("char1").toString());
        Integer characterId2 = Integer.parseInt(valueMap.get("char2").toString());
        Integer characterId3 = Integer.parseInt(valueMap.get("char3").toString());
        Integer playerId = valueMap.get("playerId").toString().length() > 0 ? Integer.valueOf(Integer.parseInt(valueMap.get("playerId").toString())) : null;
        Integer n = opponentId = valueMap.get("opponentId").toString().length() > 0 ? Integer.valueOf(Integer.parseInt(valueMap.get("opponentId").toString())) : null;
        if (opponentId != null) {
            Character c;
            ArrayList<CharacterInstance> list1 = new ArrayList<CharacterInstance>();
            Battle battle = this.battleService.getByPlayerId(opponentId.intValue());
            CharacterInstance i1 = new CharacterInstance();
            CharacterInstance i2 = new CharacterInstance();
            CharacterInstance i3 = new CharacterInstance();
            i1.setCharacterId(characterId1.intValue());
            i2.setCharacterId(characterId2.intValue());
            i3.setCharacterId(characterId3.intValue());
            list1.add(i1);
            list1.add(i2);
            list1.add(i3);
            battle.setPlayerTwoTeam(list1);
            battle.setPlayerIdTwo(playerId.intValue());
            if (battle.isPlayerOneStart()) {
                battle.setPlayerTwoEnergy(this.nrg.draw(3));
            } else {
                battle.setPlayerTwoEnergy(this.nrg.draw(1));
            }
            savedBattle = this.battleService.save(battle);
            LOG.info("SAVED BATTLE:: " + savedBattle.toString());
            ArrayList<Character> characters = new ArrayList<Character>();
            List<Integer> characterIds = battle.getPlayerOneTeam().stream().map(CharacterInstance::getCharacterId).collect(Collectors.toList());
            List<Integer> characterIds2 = battle.getPlayerTwoTeam().stream().map(CharacterInstance::getCharacterId).collect(Collectors.toList());
            for (Integer id : characterIds) {
                c = (Character)this.characterService.findById(id).get();
                characters.add(c);
            }
            for (Integer id : characterIds2) {
                c = (Character)this.characterService.findById(id).get();
                characters.add(c);
            }
            Player playerOne = (Player)this.playerService.findById(Integer.valueOf(battle.getPlayerIdOne())).get();
            Player playerTwo = (Player)this.playerService.findById(Integer.valueOf(battle.getPlayerIdTwo())).get();
            LOG.info("Match Made between {} and {}", (Object)playerOne.getDisplayName(), (Object)playerTwo.getDisplayName());
            String characterJson = new Gson().toJson(characters);
            String battleJson = new Gson().toJson((Object)savedBattle);
            String playerOneJson = new Gson().toJson((Object)playerOne);
            String playerTwoJson = new Gson().toJson((Object)playerTwo);
            if (battleJson != null && playerOne != null && playerTwo != null && characterJson != null) {
                String responseJson = "{\"type\": \"INIT\", \"battle\": " + battleJson + ",\"playerOne \": " + playerOneJson + ",\"playerTwo \": " + playerTwoJson + ",\"characters \": " + characterJson + "}";
                return responseJson;
            }
            return "ERROR";
        }
        Battle battle = new Battle();
        battle.setId(this.nrg.randomInt());
        Integer uri = Integer.valueOf(session.getUri().toString().substring(7, 14));
        battle.setArenaId(uri.intValue());
        ArrayList<CharacterInstance> list1 = new ArrayList<CharacterInstance>();
        CharacterInstance i1 = new CharacterInstance();
        CharacterInstance i2 = new CharacterInstance();
        CharacterInstance i3 = new CharacterInstance();
        i1.setCharacterId(characterId1.intValue());
        i2.setCharacterId(characterId2.intValue());
        i3.setCharacterId(characterId3.intValue());
        i1.setPlayerOneCharacter(true);
        i2.setPlayerOneCharacter(true);
        i3.setPlayerOneCharacter(true);
        list1.add(i1);
        list1.add(i2);
        list1.add(i3);
        battle.setPlayerOneTeam(list1);
        battle.setPlayerIdOne(playerId.intValue());
        if (battle.isPlayerOneStart()) {
            battle.setPlayerOneEnergy(this.nrg.draw(1));
        } else {
            battle.setPlayerOneEnergy(this.nrg.draw(3));
        }
        savedBattle = this.battleService.save(battle);
        LOG.info("SAVED BATTLE:: " + savedBattle.toString());
        return "WAITING FOR OPPONENTS";
    }

    public String handleEnergyTradeMessage(Map valueMap) {
        LOG.info("Energy Trade");
        return null;
    }

    public String handleTurnEndMessage(Map valueMap) {
        LOG.info("Turn End");
        return null;
    }

    public String handleTargetCheckMessage(Map valueMap) {
        LOG.info("Target Check");
        return null;
    }

    public String handleCostCheckMessage(Map valueMap) {
        LOG.info("Cost Check");
        return null;
    }
}
