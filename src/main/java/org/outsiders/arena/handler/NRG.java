package org.outsiders.arena.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NRG
{
	private static final Logger LOG = LoggerFactory.getLogger(NRG.class);
  public List<String> draw(int i)
  {
    List<String> res = new ArrayList();
    for (int j = i; j > 0; j--)
    {
      Random random = new Random();
      random.nextInt(4);
      int det = random.nextInt() % 4;
      if (det < 0) {
    	  det = 0 - det;
      }
      res.add(det == 2 ? "STRENGTH" : det == 1 ? "DIVINITY" : det == 0 ? "ARCANA" : "DEXTERITY");
    }
    return res;
  }
  
  public int randomInt()
  {
    return new Random().nextInt();
  }
}
