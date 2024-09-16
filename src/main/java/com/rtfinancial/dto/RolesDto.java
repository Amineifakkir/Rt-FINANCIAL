package com.rtfinancial.dto;

import com.rtfinancial.domain.Roles;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RolesDto {

    private Long roleIdDto;
    private String roleNameDto;

    public static RolesDto from(Roles entity) {
        RolesDtoBuilder builder = RolesDto.builder().
                roleIdDto(entity.getRoleId()).
                roleNameDto(entity.getRoleName());
        return builder.build();
    }
}
