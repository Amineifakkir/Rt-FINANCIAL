package com.rtfinancial.dto;

import com.rtfinancial.domain.Status;
import jakarta.persistence.Column;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StatusDto {


    private Long statusIdDto;


    private String statusNameDto;

    public static StatusDto from(Status entity) {
        StatusDtoBuilder builder = StatusDto.builder().
                statusIdDto(entity.getStatusId()).
                statusNameDto(entity.getStatusName());
        return builder.build();
    }
}
