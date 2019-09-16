package com.stackroute.squad.services;

import com.stackroute.squad.domain.Roles;
import com.stackroute.squad.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class RolesServiceImpl implements RolesService {
  RolesRepository rolesRepository;

  /**
   * Constructor based Dependency injection to inject rolRepository here
   */
  @Autowired
  public RolesServiceImpl(RolesRepository rolesRepository) {
    this.rolesRepository = rolesRepository;
  }

  /**
   * Implementation of saveRoles method
   */
  @Override
  public Roles save(Roles roles) {
    return rolesRepository.save(roles);
  }

  /**
   * Implementation of getAllRoles method
   */
  @Override
  public List<Roles> getAllRoles() {
    List<Roles> allRoles = (List<Roles>) rolesRepository.findAll();
    return allRoles;

  }

  /**
   * Implementation of updateRoles method
   */
  @Override
  public Roles updateRoles(Roles roles) {
    Roles updateRoles = rolesRepository.save(roles);
    return updateRoles;
  }
}
