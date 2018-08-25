package org.outsiders.arena.service;

import java.util.Optional;
import org.outsiders.arena.domain.Battle;

public abstract interface BattleService
{
  public abstract Battle getByPlayerId(int paramInt);
  
  public abstract Battle getByPlayerDisplayName(String displayName);
  
  public abstract Battle getByArenaId(int paramInt);
  
  public abstract Battle save(Battle paramBattle);
  
  public abstract Iterable<Battle> saveAll(Iterable<Battle> paramIterable);
  
  public abstract Optional<Battle> findById(Integer paramInteger);
  
  public abstract boolean existsById(Integer paramInteger);
  
  public abstract Iterable<Battle> findAll();
  
  public abstract Iterable<Battle> findAllById(Iterable<Integer> paramIterable);
  
  public abstract long count();
  
  public abstract void deleteById(Integer paramInteger);
  
  public abstract void delete(Battle paramBattle);
  
  public abstract void deleteAll(Iterable<Battle> paramIterable);
  
  public abstract void deleteAll();
}
