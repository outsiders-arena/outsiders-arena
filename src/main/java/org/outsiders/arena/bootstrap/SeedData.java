package org.outsiders.arena.bootstrap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.outsiders.arena.domain.Ability;
import org.outsiders.arena.domain.Character;
import org.outsiders.arena.domain.Effect;
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
    
    Ability as1 = new Ability(true, false, false, false);
    as1.setCooldown(1);
    as1.setName("Double Strike");
    as1.setCost(Collections.singletonList("RANDOM"));
    
    List<Effect> effs = new ArrayList();
    Effect e1 = new Effect(true, true, true);
    e1.setName("Impulse");
    e1.setDuration(2);
    Map<String, Integer> impDmg = new HashMap();
    impDmg.put("HP", Integer.valueOf(-20));
    e1.setStatMods(impDmg);
    effs.add(e1);
    as1.setEffects(effs);
    
    List<Effect> selfs = new ArrayList();
    Effect e2 = new Effect(false, true, true);
    e2.setName("FlashFreeze");
    e2.setDuration(1);
    Map<String, Integer> impCombo = new HashMap();
    impCombo.put("COMBO_SLOT", Integer.valueOf(1));
    e2.setStatMods(impCombo);
    selfs.add(e2);
    
    as1.setSelfEffects(selfs);
    
    alex.setSlot1(as1);
    
    Character c1 = this.characterService.save(alex);
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
