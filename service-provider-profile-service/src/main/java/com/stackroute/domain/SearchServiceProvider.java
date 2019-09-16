package com.stackroute.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Document( collection = "SearchServiceProvider")
public class SearchServiceProvider {

    @Id
    private String roleName;
    private List<ServiceProvider> serviceProviderList;
}
