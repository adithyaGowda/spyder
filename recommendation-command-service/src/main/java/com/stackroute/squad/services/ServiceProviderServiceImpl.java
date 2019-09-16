package com.stackroute.squad.services;

import com.stackroute.squad.domain.ServiceProvider;
import com.stackroute.squad.dto.IdeaDto;
import com.stackroute.squad.dto.ServiceProviderDto;
import com.stackroute.squad.exceptions.ServiceProviderNotFound;
import com.stackroute.squad.repository.ServiceProviderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {
  ServiceProviderRepository serviceProviderRepository;

  /**
   * Constructor based Dependency injection to inject serviceprovider Repository here
   */
  @Autowired
  public ServiceProviderServiceImpl(ServiceProviderRepository serviceProviderRepository) {
    this.serviceProviderRepository = serviceProviderRepository;
  }

  /**
   * Implementation of save Service provider method
   */
  @Override
  public ServiceProvider save(ServiceProvider serviceProvider) throws Exception {
    return serviceProviderRepository.save(serviceProvider);
  }

  /*It will listen the data from spProfile queue*/
  @RabbitListener(queues = "${spProfile.rabbitmq.queue}")
  public void receiveData(ServiceProviderDto serviceProviderDto) throws Exception {
    ServiceProvider serviceProvider = new ServiceProvider();
    serviceProvider.setChargePerHour(serviceProviderDto.getChargePerHour());
    serviceProvider.setDomain(serviceProviderDto.getDomain());
    serviceProvider.setEmail(serviceProviderDto.getEmail());
    serviceProvider.setMobileNo(serviceProviderDto.getMobileNo());
    serviceProvider.setName(serviceProviderDto.getName());
    serviceProvider.setPreferredLocation(serviceProviderDto.getPreferredLocation());
    serviceProvider.setCurrentLocation(serviceProviderDto.getCurrentLocation());
    serviceProviderRepository.save(serviceProvider);
  }

  /*It will listen the data from spProfile queue*/
  @RabbitListener(queues = "${spUpdate.rabbitmq.queue}")
  public void updatedServiceProvider(ServiceProviderDto serviceProviderDto) throws Exception {
    ServiceProvider retrievedServiceProvider = serviceProviderRepository.findByEmail(serviceProviderDto.getEmail());
    retrievedServiceProvider.setChargePerHour(serviceProviderDto.getChargePerHour());
    retrievedServiceProvider.setDomain(serviceProviderDto.getDomain());
    retrievedServiceProvider.setMobileNo(serviceProviderDto.getMobileNo());
    retrievedServiceProvider.setName(serviceProviderDto.getName());
    retrievedServiceProvider.setPreferredLocation(serviceProviderDto.getPreferredLocation());
    retrievedServiceProvider.setCurrentLocation(serviceProviderDto.getCurrentLocation());
    serviceProviderRepository.save(retrievedServiceProvider);
    serviceProviderRepository.setPlayedByRelation(serviceProviderDto.getEmail(), serviceProviderDto.getRolesDto().getRoleName());
    for (int i = 0; i < serviceProviderDto.getRolesDto().getSkills().size(); i++) {
      serviceProviderRepository.setHasSkillsRelation(serviceProviderDto.getEmail(), serviceProviderDto.getRolesDto().getSkills().get(i));
    }
    IdeaDto ideaDto = new IdeaDto();
    serviceProviderRepository.setWorkedOnRelation(serviceProviderDto.getEmail(), ideaDto.getTitle());
    IdeaDto ideaDto1 = new IdeaDto();
    serviceProviderRepository.setAppliedForRelation(serviceProviderDto.getEmail(), ideaDto1.getTitle());


  }

  /**
   * Implementation of get All Service provider method
   */

  @Override
  public List<ServiceProvider> getAllServiceProvider() throws ServiceProviderNotFound {
    List<ServiceProvider> allServiceProviders = (List<ServiceProvider>) serviceProviderRepository.findAll();
    return allServiceProviders;

  }

  /**
   * Implementation of update Service provider method
   */
  @Override
  public ServiceProvider updateServiceProvider(ServiceProvider serviceProvider) throws ServiceProviderNotFound {
    ServiceProvider updateServiceProvider = serviceProviderRepository.save(serviceProvider);
    return updateServiceProvider;

  }

  /**
   * Implementation of get Service provider by email method
   */
  @Override
  public ServiceProvider getByEmail(String email) throws ServiceProviderNotFound {
    return serviceProviderRepository.findByEmail(email);
  }
}
