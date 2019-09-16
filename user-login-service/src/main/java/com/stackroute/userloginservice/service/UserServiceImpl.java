package com.stackroute.userloginservice.service;

import com.stackroute.userloginservice.domain.User;
import com.stackroute.userloginservice.dto.UserDto;
import com.stackroute.userloginservice.repository.UserRepository;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findByEmailIdAndPassword(String emailId, String password) {
        return userRepository.findByEmailIdAndPassword(emailId, password);
    }

    @RabbitListener(queues = "${ih.rabbitmq.queue}")
    public void recievedMessage(UserDto user) {
        User x = new User();
        x.setRole(user.getRole());
        x.setEmailId(user.getEmail());
        x.setPassword(user.getPassword());
        userRepository.save(x);
        System.out.println("Recieved Message From ideaHamster:" + x.toString());
    }
    //For service provider producer
    @RabbitListener(queues = "${spRegister.rabbitmq.queue}")
    public void recieveMessage(UserDto user) {
        User y = new User();
        y.setRole(user.getRole());
        y.setEmailId(user.getEmail());
        y.setPassword(user.getPassword());
        userRepository.save(y);
        System.out.println("Recieved Message From service-provider:" + y.toString());
    }
}