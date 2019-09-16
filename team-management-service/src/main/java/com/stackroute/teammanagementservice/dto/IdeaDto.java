package com.stackroute.teammanagementservice.dto;

import com.stackroute.teammanagementservice.domain.Role;
import com.stackroute.teammanagementservice.domain.ServiceProvider;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
/**With @Data, Lombok will generate getter and setter methods, toString methods, Equal & Hashcode methods*/
@Data

/**@NoArgsConstructor will generate constructor with no arguments*/
@NoArgsConstructor

/**@AllArgsConstructor will generate constructor with all properties in the class*/
@AllArgsConstructor


@Builder
@ToString
public class IdeaDto {
    private int id;
    private String title;
    private String description;
    private String duration;
    private String domain;
    private String subDomain;
    private double cost;
    private List<Role> role;
    private String status;
    private Date postedOn;
    private String postedBy;
    private String location;
}
