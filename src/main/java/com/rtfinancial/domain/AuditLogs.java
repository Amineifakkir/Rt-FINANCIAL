package com.rtfinancial.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * The type Audit logs.
 */
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "AUDIT_LOGS")
@Entity
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
    private String enityType;

    @Column(name = "TIMESTAMP", nullable = false)
    private String timestamp;
    @Column(name = "DETAILS", nullable = false)
    private String details;
}
