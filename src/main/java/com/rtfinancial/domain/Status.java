package com.rtfinancial.domain;

import com.rtfinancial.dto.StatusDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * The type Status.
 */
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "STATUS")
@Entity
@AllArgsConstructor
@Builder
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    @Column(name = "STATUS_NAME", nullable = false)
    private String statusName;

    @OneToMany(mappedBy = "status")
    private List<Users> users;

    public static Status from(StatusDto dto){
            StatusBuilder builder = Status.builder().
                    statusId(dto.getStatusIdDto()).
                    statusName(dto.getStatusNameDto());
            return builder.build();

    }


}
