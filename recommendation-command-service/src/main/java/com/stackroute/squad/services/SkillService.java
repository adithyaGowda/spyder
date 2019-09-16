package com.stackroute.squad.services;

import com.stackroute.squad.domain.IdeaHamster;
import com.stackroute.squad.domain.Skills;

import java.util.List;

public interface SkillService {
  /**
   * AbstractMethod to save skills
   */
  public Skills save(Skills skills);

  /**
   * AbstractMethod to get all skills
   */
  public List<Skills> getAllSkills();

  /**
   * AbstractMethod to update skills
   */
  public Skills updateSkills(Skills skills);

}
