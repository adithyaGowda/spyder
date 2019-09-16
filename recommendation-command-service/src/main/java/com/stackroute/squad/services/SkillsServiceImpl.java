package com.stackroute.squad.services;

import com.stackroute.squad.domain.Skills;
import com.stackroute.squad.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class SkillsServiceImpl implements SkillService {
  SkillsRepository skillsRepository;

  /**
   * Constructor based Dependency injection to inject skills Repository here
   */
  @Autowired
  public SkillsServiceImpl(SkillsRepository skillsRepository) {

    this.skillsRepository = skillsRepository;
  }

  /**
   * Implementation of save skills method
   */
  @Override
  public Skills save(Skills skills) {
    return skillsRepository.save(skills);
  }

  /**
   * Implementation of getAll Skills method
   */
  @Override
  public List<Skills> getAllSkills() {
    List<Skills> allSkills = (List<Skills>) skillsRepository.findAll();
    return allSkills;

  }


  /**
   * Implementation of update skills method
   */
  @Override
  public Skills updateSkills(Skills skills) {
    Skills updateSkills = skillsRepository.save(skills);
    return updateSkills;

  }
}
