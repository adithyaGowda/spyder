package com.stackroute.userloginservice.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String userName;
    private String email;
    private String password;
    private String role;
}
