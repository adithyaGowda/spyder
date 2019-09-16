package com.stackroute.squad.services;

import com.stackroute.squad.domain.Domain;


import java.util.List;

public interface DomainService {
  /**
   * AbstractMethod to save a domain
   */
  public Domain saveDomain(Domain domain);

  /**
   * AbstractMethod to get all domains
   */
  public List<Domain> getAllDomains();

  /**
   * AbstractMethod to update domain
   */
  public Domain updateDomain(Domain domain);
}
