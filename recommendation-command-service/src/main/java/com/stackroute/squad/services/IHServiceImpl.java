package com.stackroute.squad.services;

import com.stackroute.squad.domain.IdeaHamster;
import com.stackroute.squad.dto.IdeaHamsterDto;
import com.stackroute.squad.repository.IHRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class IHServiceImpl implements IHService {
  private IHRepository ihRepository;

  /**
   * Constructor based Dependency injection to inject ihRepository here
   */
  @Autowired
  public IHServiceImpl(IHRepository ihRepository) {
    this.ihRepository = ihRepository;
  }

  /**
   * Implementation of saveIdeaHamster method
   */
  @Override
  public IdeaHamster saveIH(IdeaHamster ideaHamster) {
    return ihRepository.save(ideaHamster);

  }

  /*Listen the data from ihprofile */
  @RabbitListener(queues = "${ihProfile.rabbitmq.queue}")
  public void receiveData(IdeaHamsterDto ideaHamsterDto) {
    IdeaHamster ideaHamster = new IdeaHamster();
    ideaHamster.setEmail(ideaHamsterDto.getEmail());
    ideaHamster.setMobile(ideaHamsterDto.getMobile());
    ideaHamster.setName(ideaHamsterDto.getName());
    ihRepository.save(ideaHamster);
  }

  /**
   * Implementation of getAllIdeaHamsters method
   */
  @Override
  public List<IdeaHamster> getAllIdeaHamsters() {
    List<IdeaHamster> allIdeasHamsters = (List<IdeaHamster>) ihRepository.findAll();
    return allIdeasHamsters;

  }


  /**
   * Implementation of updateIdeaHamster method
   */
  @Override
  public IdeaHamster updateIdeaHamster(IdeaHamster ideaHamster) {
    IdeaHamster updateIHById = ihRepository.save(ideaHamster);
    return updateIHById;
  }
}
