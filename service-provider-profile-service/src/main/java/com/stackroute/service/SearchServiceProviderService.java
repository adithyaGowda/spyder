package com.stackroute.service;

import com.stackroute.domain.ServiceProvider;

import java.util.List;

public interface SearchServiceProviderService {

    List<ServiceProvider> searchListOfServiceProvider(String roleName);
}
