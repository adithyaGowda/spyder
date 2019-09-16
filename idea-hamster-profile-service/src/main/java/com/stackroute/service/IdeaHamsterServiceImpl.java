package com.stackroute.service;

import com.stackroute.domain.Idea;
import com.stackroute.domain.IdeaHamster;
import com.stackroute.dto.IdeaDto;
import com.stackroute.dto.IdeaHamsterDto;
import com.stackroute.exception.GlobalException;
import com.stackroute.repository.IdeaHamsterRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class IdeaHamsterServiceImpl implements IdeaHamsterService {

    private IdeaHamsterRepository ideaHamsterRepository;
    private RabbitTemplate amqpTemplate;

    public IdeaHamsterServiceImpl() {
    }

    /**
     * Constructor based Dependency injection to inject TrackRepository here
     */
    @Autowired
    public IdeaHamsterServiceImpl(IdeaHamsterRepository ideaHamsterRepository, RabbitTemplate amqpTemplate) {
        this.ideaHamsterRepository = ideaHamsterRepository;
        this.amqpTemplate = amqpTemplate;
    }


    @Value("${ih.rabbitmq.exchange}")
    public String exchange;

    @Value("${ih.rabbitmq.routingkey}")
    public String routingkey;

    @Value("${ihProfile.rabbitmq.exchange}")
    String profileExchange;
    @Value("${ihProfile.rabbitmq.routingkey}")
    String profilRoutingkey;
    /**
     * Implementation of saveIdeaHamster method
     */
    @Override
    public IdeaHamster saveIdeaHamster(IdeaHamsterDto provider) {

        amqpTemplate.convertAndSend(exchange, routingkey, provider);

        IdeaHamster ih = new IdeaHamster();
        ih.setName(provider.getUserName());
        ih.setEmail(provider.getEmail());

        return ideaHamsterRepository.save(ih);
    }


    /**
     * Implementation of getIdeaHamster method
     */
    @Override
    public IdeaHamster getTheProfile(String email) {
        return ideaHamsterRepository.findByEmail(email);
    }
    /**
     * Implementation of updateIdeaHamster method
     */
    @Override
    public IdeaHamster updateTheProfile(IdeaHamster provider) {

        IdeaHamster ideaHamster = ideaHamsterRepository.findByEmail(provider.getEmail());
        System.out.println(provider.toString());
        ideaHamster.setName(provider.getName());
        ideaHamster.setMobileNo(provider.getMobileNo());


        System.out.println(ideaHamster.toString());
        IdeaHamster updateServiceProvider = ideaHamsterRepository.save(ideaHamster);
        amqpTemplate.convertAndSend(profileExchange,profilRoutingkey, ideaHamster);
        return updateServiceProvider;
    }



//    annotations is performed by registering a RabbitListenerAnnotationBeanPostProcessor.
    @RabbitListener(queues = "${ideah.rabbitmq.queue}")
    public void getPostedIdea(IdeaDto ideaDto) {
        System.out.println("recieved="+ideaDto.toString());
        Optional optional = ideaHamsterRepository.findById(ideaDto.getPostedBy());
        List<Idea> ideaList;
        IdeaHamster retrievedIdeaHamster;
        if (optional.isPresent()) {
            retrievedIdeaHamster = ideaHamsterRepository.findById(ideaDto.getPostedBy()).get();
            ideaList = retrievedIdeaHamster.getPostedIdea();
            Idea idea1 = new Idea();
            idea1.setDomain(ideaDto.getDomain());
            idea1.setCost(ideaDto.getCost());
            idea1.setDescription(ideaDto.getDescription());
            idea1.setDuration(ideaDto.getDuration());
            idea1.setLocation(ideaDto.getLocation());
            idea1.setPostedOn(ideaDto.getPostedOn());
            idea1.setStatus(ideaDto.getStatus());
            idea1.setSubDomain(ideaDto.getSubDomain());
            idea1.setTitle(ideaDto.getTitle());
            idea1.setRole(ideaDto.getRole());
            retrievedIdeaHamster.setPostedIdea(ideaList);
            ideaHamsterRepository.save(retrievedIdeaHamster);

        }

    }}