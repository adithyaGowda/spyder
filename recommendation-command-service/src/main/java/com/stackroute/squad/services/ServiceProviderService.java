package com.stackroute.squad.services;


import com.stackroute.squad.domain.ServiceProvider;
import com.stackroute.squad.exceptions.ServiceProviderNotFound;

import java.util.List;

public interface ServiceProviderService {
  /**
   * AbstractMethod to save a serviceProvider
   */
  public ServiceProvider save(ServiceProvider serviceProvider) throws Exception;

  /**
   * AbstractMethod to get all serviceProvider
   */
  public List<ServiceProvider> getAllServiceProvider() throws ServiceProviderNotFound;

  /**
   * AbstractMethod to update serviceProvider
   */
  public ServiceProvider updateServiceProvider(ServiceProvider serviceProvider) throws ServiceProviderNotFound;

  /**
   * AbstractMethod to get serviceProvider by email
   */
  public ServiceProvider getByEmail(String email) throws ServiceProviderNotFound;

}
