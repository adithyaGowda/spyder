package com.stackroute.teammanagementservice.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
/**With @Data, Lombok will generate getter and setter methods, toString methods, Equal & Hashcode methods*/
@Data
/**@NoArgsConstructor will generate constructor with no arguments*/
@NoArgsConstructor
/**@AllArgsConstructor will generate constructor with all properties in the class*/
@AllArgsConstructor
@Builder
@ToString
public class Role {
    private String experience;
    private String noOfPeople;
    private List<String> skills;
    private String roleName;
}
