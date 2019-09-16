package com.stackroute.squad.services;

import com.stackroute.squad.domain.IdeaHamster;

import java.util.List;

public interface IHService {
  /**
   * AbstractMethod to save a ideahamster
   */
  public IdeaHamster saveIH(IdeaHamster ideaHamster);
  /**
   * AbstractMethod to get all idea hamsters
   */
  public List<IdeaHamster> getAllIdeaHamsters();

  /**
   * AbstractMethod to update idea hamster
   */
  public IdeaHamster updateIdeaHamster(IdeaHamster ideaHamster);


}
