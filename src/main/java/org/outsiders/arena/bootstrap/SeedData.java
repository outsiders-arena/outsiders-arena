package org.outsiders.arena.bootstrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.outsiders.arena.domain.Ability;
import org.outsiders.arena.domain.Character;
import org.outsiders.arena.domain.Conditional;
import org.outsiders.arena.domain.Cost;
import org.outsiders.arena.domain.Effect;
import org.outsiders.arena.domain.Energy;
import org.outsiders.arena.domain.Quality;
import org.outsiders.arena.domain.Stat;
import org.outsiders.arena.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData
  implements CommandLineRunner
{
  private static final Logger LOG = LoggerFactory.getLogger(SeedData.class);
  @Autowired
  private CharacterService characterService;
  
  public void run(String... args)
    throws Exception
  {
    makeCharacters();
    
    LOG.info("ALL DATA SEEDED SUCCESSFULLY");
  }
  
  private void makeCharacters()
  {
    Character alex = new Character();
    Character fainne = new Character();
    Character geddy = new Character();
    Character hollyanna = new Character();
    Character shinzo = new Character();
    
    alex.setName("Alex Drake");
    alex.setId(0);
    fainne.setName("Fainne Uron");
    fainne.setId(1);
    geddy.setName("Geddy Splintwaker");
    geddy.setId(2);
    hollyanna.setName("Hollyanna Knox");
    hollyanna.setId(3);
    shinzo.setName("Shinzo Katetsu");
    shinzo.setId(4);
    
    alex.setAvatarUrl("TBD");
    fainne.setAvatarUrl("TBD");
    geddy.setAvatarUrl("TBD");
    hollyanna.setAvatarUrl("TBD");
    shinzo.setAvatarUrl("TBD");
    
    
//    Ability as1 = new Ability(true, false, false, false);
//    as1.setCooldown(1);
//    as1.setName("Impulse");
//    as1.setCost(Cost.oneRan);
//    
//    List<Effect> effs = new ArrayList();
//    Effect e1 = new Effect(true, true, true);
//    e1.setName("Impulse");
//    e1.setDuration(3);
//    Map<String, Integer> impDmg = new HashMap();
//    impDmg.put(Stat.HP, Integer.valueOf(-10));
//    e1.setStatMods(impDmg);
//    effs.add(e1);
//    
//    as1.setEffects(effs);
//    alex.setSlot1(as1);
//    
//    
//    Ability as2 = new Ability(true, false, false, false);
//    as2.setCooldown(1);
//    as2.setName("Flash Freeze");
//    as2.setCost(Cost.oneDexOneRan);
//    
//    List<Effect> effs2 = new ArrayList();
//    Effect e2 = new Effect(true, true, true);
//    e2.setName("Flash Freeze");
//    e2.setDuration(1);
//    Map<String, Integer> flaDmg = new HashMap();
//    flaDmg.put(Stat.HP, Integer.valueOf(-30));
//    e2.setStatMods(flaDmg);
//    Effect e3 = new Effect(true, true, true);
//    e3.setName("Flash Frozen");
//    e3.setDuration(2);
//    Map<String, Integer> flaRed = new HashMap();
//    flaRed.put(Stat.DAMAGE, Integer.valueOf(-10));
//    e2.setStatMods(flaRed);
//    effs2.add(e2);
//    effs2.add(e3);
//    
//    as2.setEffects(effs2);
//    alex.setSlot2(as2);
//    
//    
//    Ability as3 = new Ability(true, false, true, false);
//    as3.setCooldown(2);
//    as3.setName("Study Target");
//    as3.setCost(Cost.twoRan);
//    
//    List<Effect> effs3 = new ArrayList();
//    
//    Effect e4 = new Effect(true, false, true);
//    e4.setName("Study Target - Weakness");
//    e4.setDuration(2);
//    Map<String, Integer> stuBuf = new HashMap();
//    stuBuf.put(Stat.DAMAGE, Integer.valueOf(10));
//    e4.setConditional(true);
//    // whoever this ability is on needs to meet this conditional
//    e4.setCondition(Collections.singletonMap(Conditional.ATTACK, "Study Target"));
//    e4.setStatMods(stuBuf);
//    
//    List<Effect> selfs2 = new ArrayList();
//    
//    Effect e4m = new Effect(true, false, true);
//    e4m.setName("Study Target - Weakness");
//    e4m.setDuration(2); 
//    
//    Effect e5 = new Effect(true, true, true);
//    e5.setName("Study Target - Traps");
//    e5.setDuration(2);
//    Map<String, Boolean> stuRev = new HashMap();
//    stuRev.put(Quality.REVEALED, true);
//    e5.setQualityMods(stuRev);
//    effs3.add(e4m);
//    effs3.add(e5);
//    
//    selfs2.add(e4);
//    
//    as3.setEffects(effs3);
//    as3.setSelfEffects(selfs2);
//    alex.setSlot3(as3);
//    
//    
//    Ability as4 = new Ability(false, false, true, false);
//    as4.setCooldown(3);
//    as4.setName("Stealth");
//    as4.setCost(Cost.oneRan);
//    
//    List<Effect> selfs3 = new ArrayList();
//    
//    Effect e6 = new Effect(true, false, false);
//    e6.setName("Invulnerable");
//    e6.setQualityMods(Collections.singletonMap(Quality.INVULNERABLE, true));
//    e6.setDuration(1); 
//    
//    selfs3.add(e6);
//    
//    as4.setSelfEffects(selfs3);
//    
//    alex.setSlot4(as4);
    
    Ability hs1 = new Ability(true, false, false, false);
    hs1.setCooldown(1);
    hs1.setName("Impulse");
    hs1.setCost(Cost.oneRan);
    
    List<Effect> heffs1 = new ArrayList();
    Effect he1 = new Effect(true, true, true);
    he1.setName("Impulse");
    he1.setDuration(3);
    Map<String, Integer> impDmg = new HashMap();
    
    he1.setStatMods(impDmg);
    heffs1.add(he1);
    
    hs1.setEffects(heffs1);
    alex.setSlot1(hs1);
    
    
    Ability as2 = new Ability(true, false, false, false);
    as2.setCooldown(1);
    as2.setName("Flash Freeze");
    as2.setCost(Cost.oneDexOneRan);
    
    List<Effect> effs2 = new ArrayList();
    Effect e2 = new Effect(true, true, true);
    e2.setName("Flash Freeze");
    e2.setDuration(1);
    Map<String, Integer> flaDmg = new HashMap();
    flaDmg.put(Stat.HP, Integer.valueOf(-30));
    e2.setStatMods(flaDmg);
    Effect e3 = new Effect(true, true, true);
    e3.setName("Flash Frozen");
    e3.setDuration(2);
    Map<String, Integer> flaRed = new HashMap();
    flaRed.put(Stat.DAMAGE, Integer.valueOf(-10));
    e2.setStatMods(flaRed);
    effs2.add(e2);
    effs2.add(e3);
    
    as2.setEffects(effs2);
    alex.setSlot2(as2);
    
    
    Ability as3 = new Ability(true, false, true, false);
    as3.setCooldown(2);
    as3.setName("Study Target");
    as3.setCost(Cost.twoRan);
    
    List<Effect> effs3 = new ArrayList();
    
    Effect e4 = new Effect(true, false, true);
    e4.setName("Study Target - Weakness");
    e4.setDuration(2);
    Map<String, Integer> stuBuf = new HashMap();
    stuBuf.put(Stat.DAMAGE, Integer.valueOf(10));
    e4.setConditional(true);
    // whoever this ability is on needs to meet this conditional
    e4.setCondition(Collections.singletonMap(Conditional.ATTACK, "Study Target"));
    e4.setStatMods(stuBuf);
    
    List<Effect> selfs2 = new ArrayList();
    
    Effect e4m = new Effect(true, false, true);
    e4m.setName("Study Target - Weakness");
    e4m.setDuration(2); 
    
    Effect e5 = new Effect(true, true, true);
    e5.setName("Study Target - Traps");
    e5.setDuration(2);
    Map<String, Boolean> stuRev = new HashMap();
    stuRev.put(Quality.REVEALED, true);
    e5.setQualityMods(stuRev);
    effs3.add(e4m);
    effs3.add(e5);
    
    selfs2.add(e4);
    
    as3.setEffects(effs3);
    as3.setSelfEffects(selfs2);
    alex.setSlot3(as3);
    
    
    Ability as4 = new Ability(false, false, true, false);
    as4.setCooldown(3);
    as4.setName("Stealth");
    as4.setCost(Cost.oneRan);
    
    List<Effect> selfs3 = new ArrayList();
    
    Effect e6 = new Effect(true, false, false);
    e6.setName("Invulnerable");
    e6.setQualityMods(Collections.singletonMap(Quality.INVULNERABLE, true));
    e6.setDuration(1);
    
    selfs3.add(e6);
    
    as4.setSelfEffects(selfs3);
    
    alex.setSlot4(as4);
    
    
    
    
    
    Character c1 = this.characterService.save(alex);
//    c1.getSlot1().getSelfEffects().forEach(e -> {
//    	if (e.isConditional()) {
//    		e.getCondition().forEach((condition, effectname) -> {
//    			if (e.getOriginCharacter().equals(parentCharacterId)) {
//    				
//    			}
//    		});
//    	}
//    });
    LOG.info(c1.toString());
    Character c2 = this.characterService.save(fainne);
    LOG.info(c2.toString());
    Character c3 = this.characterService.save(geddy);
    LOG.info(c3.toString());
    Character c4 = this.characterService.save(hollyanna);
    LOG.info(c4.toString());
    Character c5 = this.characterService.save(shinzo);
    LOG.info(c5.toString());
  }
  
  private <T> List<T> addToListInBulk(T... obj)
  {
    List<T> list = new ArrayList();
    for (T o : obj) {
      list.add(o);
    }
    return list;
  }
  
  private <T> Set<T> addToSetInBulk(T... obj)
  {
    Set<T> set = new HashSet();
    for (T o : obj) {
      set.add(o);
    }
    return set;
  }
}
