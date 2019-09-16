package com.stackroute.squad.services;

import com.stackroute.squad.domain.Roles;

import java.util.List;

public interface RolesService {
  /**
   * AbstractMethod to save a roles
   */
  public Roles save(Roles roles);

  /**
   * AbstractMethod to get all roles
   */
  public List<Roles> getAllRoles();

  /**
   * AbstractMethod to update roles
   */
  public Roles updateRoles(Roles roles);
}
