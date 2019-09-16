package com.stackroute.squad.services;

import com.stackroute.squad.domain.Idea;
import com.stackroute.squad.exceptions.IdeaAlreadyExistsException;
import com.stackroute.squad.exceptions.IdeaNotFoundException;


import java.util.List;

public interface IdeaService {
  /**
   * AbstractMethod to save a idea
   */
  public Idea saveIdea(Idea idea) throws IdeaAlreadyExistsException;

  /**
   * AbstractMethod to get All ideas
   */
  public List<Idea> getAllIdeas() throws IdeaNotFoundException;

  /**
   * AbstractMethod to update idea
   */
  public Idea updateIdea(Idea idea) throws IdeaNotFoundException;


}
