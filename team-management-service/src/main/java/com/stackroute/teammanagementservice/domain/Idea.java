package com.stackroute.teammanagementservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

/**
 * Document annotated class will have the ability to represent objects in the database
 */
@Document(collection="TeamManagement")

/**With @Data, Lombok will generate getter and setter methods, toString methods, Equal & Hashcode methods*/
@Data

/**@NoArgsConstructor will generate constructor with no arguments*/
@NoArgsConstructor

/**@AllArgsConstructor will generate constructor with all properties in the class*/
@AllArgsConstructor
@Builder
@ToString
public class Idea {
    /**
     * Id annotation makes id variable as Primary key
     */
    @Id
    private String id;
    private String title;
    private String description;
    private String duration;
    private String domain;
    private String subDomain;
    private double cost;
    private List<Role> role;
    private List<ServiceProvider> appliedTeam;
    private List<ServiceProvider> invitedTeam;
    private List<ServiceProvider> selectedTeam;
    private String status;
    private Date postedOn;
    private String postedBy;
    private String location;

}
