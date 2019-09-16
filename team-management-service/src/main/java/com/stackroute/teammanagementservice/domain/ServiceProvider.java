package com.stackroute.teammanagementservice.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
/**@NoArgsConstructor will generate constructor with no arguments*/
@Data

/**@NoArgsConstructor will generate constructor with no arguments*/
@NoArgsConstructor

/**@AllArgsConstructor will generate constructor with all properties in the class*/
@AllArgsConstructor
@Builder
@ToString
public class ServiceProvider {
private String name;
private int mobileNumber;
private String emailId;
private List<String> skills;
private double chargePerHour;
}
