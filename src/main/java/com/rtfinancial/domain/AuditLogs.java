package com.rtfinancial.domain;

import com.rtfinancial.dto.AuditLogsDto;
import jakarta.persistence.*;
import lombok.*;

/**
 * The type Audit logs.
 */
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "AUDIT_LOGS")
@Entity
@Builder
@AllArgsConstructor
public class AuditLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private Users user;

    @Column(name = "ACTION", nullable = false)
    private String action;

    @Column(name = "ENTITY_ID", nullable = false)
    private String entityId;

    @Column(name = "ENTITY_TYPE", nullable = false)
    private String entityType;

    @Column(name = "TIMESTAMP", nullable = false)
    private String timestamp;
    @Column(name = "DETAILS", nullable = false)
    private String details;

    public AuditLogs from(AuditLogsDto dto) {
        return AuditLogs.builder()
                .auditId(dto.getAuditId())
                .user(dto.getUserDto())
                .action(dto.getActionDto())
                .entityId(dto.getEntityIdDto())
                .entityType(dto.getEnityTypeDto())
                .timestamp(dto.getTimestampDto())
                .details(dto.getDetailsDto())
                .build();
    }


}
