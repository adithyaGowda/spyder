package com.stackroute.dto;

import com.stackroute.domain.Role;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Component
public class IdeaDto {

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
