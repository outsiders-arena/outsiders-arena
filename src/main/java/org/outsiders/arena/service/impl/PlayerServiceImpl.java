package org.outsiders.arena.service.impl;

import java.util.Optional;
import org.outsiders.arena.domain.Player;
import org.outsiders.arena.repository.PlayerRepository;
import org.outsiders.arena.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl
  implements PlayerService
{
  @Autowired
  private PlayerRepository repo;
  
  public Player save(Player entity)
  {
    return (Player)this.repo.save(entity);
  }
  
  public Iterable<Player> saveAll(Iterable<Player> entities)
  {
    return this.repo.saveAll(entities);
  }
  
  public Optional<Player> findById(Integer id)
  {
    return this.repo.findById(id);
  }
  
  public boolean existsById(Integer id)
  {
    return this.repo.existsById(id);
  }
  
  public Iterable<Player> findAll()
  {
    return this.repo.findAll();
  }
  
  public Iterable<Player> findAllById(Iterable<Integer> ids)
  {
    return this.repo.findAllById(ids);
  }
  
  public long count()
  {
    return this.repo.count();
  }
  
  public void deleteById(Integer id)
  {
    this.repo.deleteById(id);
  }
  
  public void delete(Player entity)
  {
    this.repo.delete(entity);
  }
  
  public void deleteAll(Iterable<Player> entities)
  {
    this.repo.deleteAll(entities);
  }
  
  public void deleteAll()
  {
    this.repo.deleteAll();
  }
}
