package com.rtfinancial.dto;

import com.rtfinancial.domain.AuditLogs;
import com.rtfinancial.domain.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Builder

public class AuditLogsDto {

    private Long auditId;

    private Users userDto;

    private String actionDto;

    private String entityIdDto;

    private String enityTypeDto;

    private String timestampDto;
    private String detailsDto;

    public static AuditLogsDto from(AuditLogs entity) {
        return AuditLogsDto.builder()
                .auditId(entity.getAuditId())
                .userDto(entity.getUser())
                .actionDto(entity.getAction())
                .entityIdDto(entity.getEntityId())
                .enityTypeDto(entity.getEntityType())
                .timestampDto(entity.getTimestamp())
                .detailsDto(entity.getDetails())
                .build();
    }
}
