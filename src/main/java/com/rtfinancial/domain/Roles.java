package com.rtfinancial.domain;

import com.rtfinancial.dto.RolesDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.Set;

/**
 * The type Roles.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "ROLES")
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Set<Users> user;

    public static Roles from(RolesDto dto) {
        RolesBuilder builder = Roles.builder().
                roleId(dto.getRoleIdDto()).
                roleName(dto.getRoleNameDto());
        return builder.build();

    }


}
