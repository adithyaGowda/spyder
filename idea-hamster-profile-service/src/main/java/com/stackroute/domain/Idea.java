package com.stackroute.domain;

import lombok.*;

import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Idea {
    private String title;
    private String description;
    private String duration;
    private String domain;
    private String subDomain;
    private double cost;
    private List<Role> role;
    private String status;
    private Date postedOn;
    private String location;
}
