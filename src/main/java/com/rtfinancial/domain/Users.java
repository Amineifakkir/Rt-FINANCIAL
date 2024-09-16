package com.rtfinancial.domain;

import com.rtfinancial.dto.UsersDto;
import com.rtfinancial.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * The type Users.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "USERS")
@Entity
@Builder
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "CREAT_AT", nullable = false)
    private String createAt;

    @Column(name = "UPDATE_AT", nullable = true)
    private String updateAt;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "STATUS_ID")
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_STATUS", nullable = false)
    private AccountStatus Accountstatus;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Users users = (Users) o;
        return getUserId() != 0 && Objects.equals(getUserId(), users.getUserId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }


    public Users from(UsersDto dto) {
        UsersBuilder builder = Users.builder().
                userId(dto.getUserIdDto()).
                username(dto.getUsernameDto()).
                password(dto.getPasswordDto()).
                email(dto.getEmailDto()).
                createAt(dto.getCreateAtDto()).
                updateAt(dto.getUpdateAtDto()).
                status(Status.from(dto.getStatusDto())).
                Accountstatus(dto.getAccountstatusDto());
        return builder.build();

    }



}
