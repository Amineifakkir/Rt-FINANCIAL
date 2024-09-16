package com.rtfinancial.dto;

import com.rtfinancial.domain.Roles;
import com.rtfinancial.domain.Users;
import com.rtfinancial.enums.AccountStatus;
import lombok.*;

import java.util.Collections;
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
    private StatusDto status;
    private Set<RolesDto> roles;
    private AccountStatus accountStatus;
    private String password;


    public static UsersDto from(Users entity) {
        return UsersDto.builder()
                .userId(entity.getUserId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .createAt(entity.getCreateAt())
                .updateAt(entity.getUpdateAt())
                .status(StatusDto.from(entity.getStatus()))
                .roles(Collections.singleton(RolesDto.from((Roles) entity.getRoles())))
                .build();
    }

    public Long getUserIdDto() {
        return userId;
    }

    public String getUsernameDto() {
        return username;
    }

    public String getEmailDto() {
        return email;
    }

    public String getCreateAtDto() {
        return createAt;
    }

    public String getUpdateAtDto() {
        return updateAt;
    }

    public StatusDto getStatusDto() {
        return status;
    }



    public AccountStatus getAccountstatusDto() {
        return accountStatus;
    }

    public void setUserIdDto(Long userId) {
        this.userId = userId;
    }

    public void setUsernameDto(String username) {
        this.username = username;
    }

    public void setEmailDto(String email) {
        this.email = email;
    }

    public void setCreateAtDto(String createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAtDto(String updateAt) {
        this.updateAt = updateAt;
    }



    public void setAccountstatusDto(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }


    public String getPasswordDto() {
        return password;
    }
}
