package com.stackroute.squad.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*@NodeEntity will be represented as nodes in the graph.*/
@NodeEntity
/*it can generate getters and setters for those object automatically by using Lombok annotations. The easiest way is to use the @Data annotation.*/
@Data
/*It generates constructor with no parameters*/
@NoArgsConstructor
/*It generates a constructor with 1 parameter for each field*/
@AllArgsConstructor
@Getter
@Setter
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = ServiceProviderDto.class)
public class ServiceProviderDto {
  @Id
  private Long id;
  private String email;
  private String name;
  private long mobileNo;
  private String domain;
  private String subDomain;
  private RolesDto rolesDto;
  private List<IdeaDto> workedIdeas;
  private String chargePerHour;
  private String currentLocation;
  private List<String> preferredLocation;
  private Date timestamp;
}
