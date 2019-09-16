package com.stackroute.squad.services;

import com.stackroute.squad.domain.SubDomain;

import java.util.List;

public interface SubDomainService {
  /**
   * AbstractMethod to save subdomain
   */
  public SubDomain save(SubDomain subDomain);

  /**
   * AbstractMethod to get all subdomains
   */
  public List<SubDomain> getAllSubDomains();

  /**
   * AbstractMethod to update subdomain
   */

  public SubDomain updateSubDomain(SubDomain subDomain);

}
