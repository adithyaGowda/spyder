package com.stackroute.controller;

import com.stackroute.domain.ServiceProvider;
import com.stackroute.service.SearchServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class SearchServiceProviderController {

    private SearchServiceProviderService searchServiceProviderService;

    @Autowired
    public SearchServiceProviderController(SearchServiceProviderService searchServiceProviderService) {
        this.searchServiceProviderService = searchServiceProviderService;
    }

    @GetMapping("serviceproviders/{roleName}")
    public ResponseEntity<?> searchResult(@PathVariable String roleName){

        return new ResponseEntity<List<ServiceProvider>>(searchServiceProviderService.searchListOfServiceProvider(roleName), HttpStatus.OK);
    }
}
