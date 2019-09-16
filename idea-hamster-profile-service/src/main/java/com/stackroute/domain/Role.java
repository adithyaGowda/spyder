package com.stackroute.domain;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Role {

    private String experience;
    private String noOfPeople;
    private List<String> skills;
    private String roleName;
}
