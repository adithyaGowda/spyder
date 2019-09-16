package com.stackroute.service;


import com.stackroute.domain.Role;
import com.stackroute.domain.SearchServiceProvider;
import com.stackroute.domain.ServiceProvider;
import com.stackroute.dto.ServiceProviderDto;
import com.stackroute.repository.SearchServiceProviderRepository;
import com.stackroute.repository.ServiceProviderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    private ServiceProviderRepository serviceProviderRepository;
    private SearchServiceProviderRepository searchServiceProviderRepository;
    private RabbitTemplate rabbitTemplate;

    /**
     * Constructor based Dependency injection to inject TrackRepository here
     */
    @Autowired
    public ServiceProviderServiceImpl(ServiceProviderRepository serviceProviderRepository, RabbitTemplate rabbitTemplate, SearchServiceProviderRepository searchServiceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
        this.searchServiceProviderRepository = searchServiceProviderRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public ServiceProviderServiceImpl() {
    }

    @Value("${spRegister.rabbitmq.exchange}")
    public String exchange;

    @Value("${spRegister.rabbitmq.routingkey}")
    public String routingkey;

    @Value("${spProfile.rabbitmq.exchange}")
    String profileExchange;

    @Value("${spProfile.rabbitmq.routingkey}")
    String profilRoutingkey;


    @Override
    public ServiceProvider saveServiceProvider(ServiceProviderDto provider) {

        rabbitTemplate.convertAndSend(exchange, routingkey, provider);

        ServiceProvider sp = new ServiceProvider();
        sp.setName(provider.getUserName());
        sp.setEmail(provider.getEmail());

        rabbitTemplate.convertAndSend(profileExchange, profilRoutingkey, sp);
        return serviceProviderRepository.save(sp);

    }

    @Override
    public ServiceProvider getTheProfile(String email) {

        return serviceProviderRepository.findByEmail(email);
    }


    @Override
    public ServiceProvider updateTheProfile(ServiceProvider provider) {


        ServiceProvider serviceProvider = serviceProviderRepository.findByEmail(provider.getEmail());

        System.out.println(serviceProvider.toString());
        serviceProvider.setName(provider.getName());
        serviceProvider.setMobileNo(provider.getMobileNo());
        serviceProvider.setDomain(provider.getDomain());
        serviceProvider.setSubDomain(provider.getSubDomain());
        serviceProvider.setChargePerHour(provider.getChargePerHour());
        serviceProvider.setCurrentLocation(provider.getCurrentLocation());
        serviceProvider.setPreferredLocation(provider.getPreferredLocation());
        Role role = new Role();
        role.setRoleName(provider.getRole().getRoleName());
        role.setExperience(provider.getRole().getExperience());
        role.setSkills(provider.getRole().getSkills());
        serviceProvider.setRole(role);
        System.out.println(serviceProvider.toString());
        ServiceProvider updateServiceProvider = serviceProviderRepository.save(serviceProvider);

        saveForSearch(serviceProvider);

        System.out.println(updateServiceProvider.toString());
        rabbitTemplate.convertAndSend(profileExchange,profilRoutingkey, serviceProvider);
        return updateServiceProvider;
    }


    public void saveForSearch(ServiceProvider serviceProvider){

            System.out.println(serviceProvider.toString());
            List<ServiceProvider> serviceProviderList;
            SearchServiceProvider fetchedSearchServiceProvider = searchServiceProviderRepository.findByRoleName(serviceProvider.getRole().getRoleName());
            if (fetchedSearchServiceProvider != null) {

                serviceProviderList = fetchedSearchServiceProvider.getServiceProviderList();
                serviceProviderList.add(serviceProvider);
                fetchedSearchServiceProvider.setServiceProviderList(serviceProviderList);
                searchServiceProviderRepository.save(fetchedSearchServiceProvider);

            }
            else if (fetchedSearchServiceProvider == null){

                SearchServiceProvider searchServiceProvider = new SearchServiceProvider();
                searchServiceProvider.setRoleName(serviceProvider.getRole().getRoleName());
                List<ServiceProvider> list = new ArrayList<>();
                list.add(serviceProvider);
                searchServiceProvider.setServiceProviderList(list);
                searchServiceProviderRepository.save(searchServiceProvider);

            }

    }
}
