package com.rtfinancial.dto;

import com.rtfinancial.domain.Roles;
import com.rtfinancial.domain.Status;
import com.rtfinancial.domain.Users;
import com.rtfinancial.domain.Users.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private Long userId;
    private String username;
    private String email;
    private String createAt;
    private String updateAt;
    private Status status;
    private Set<Roles> roles;
    private AccountStatus accountStatus;


    public static UsersDto from(Users entity) {
        return UsersDto.builder()
                .userId(entity.getUserId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .createAt(entity.getCreateAt())
                .updateAt(entity.getUpdateAt())
                .status(entity.getStatus())
                .roles(entity.getRoles())
                .accountStatus(entity.getAccountStatus())
                .build();
    }
}
