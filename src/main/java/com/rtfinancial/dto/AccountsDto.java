package com.rtfinancial.dto;

import com.rtfinancial.domain.Accounts;
import com.rtfinancial.domain.Transactions;
import com.rtfinancial.domain.Users;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AccountsDto {

    private Long accountIdDto;

    private Users userDto;

    private Long balance;

    private String accountType;

    private LocalDateTime currency;

    private String createAt;

    private Set<Transactions> senderTransactions;

    private Set<Transactions> receiverTransactions;


    public static AccountsDto from(Accounts entity) {
        AccountsDtoBuilder builder = AccountsDto.builder().
                accountIdDto(entity.getAccountId()).
                userDto(entity.getUser()).
                balance(entity.getBalance()).
                accountType(entity.getAccountType()).
                currency(entity.getCurrency()).
                createAt(entity.getCreateAt()).
                senderTransactions(entity.getSenderTransactions()).
                receiverTransactions(entity.getReceiverTransactions());
        return builder.build();
    }
}
