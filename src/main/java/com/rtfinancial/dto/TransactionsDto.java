package com.rtfinancial.dto;

import com.rtfinancial.domain.Accounts;
import com.rtfinancial.domain.Transactions;

import com.rtfinancial.enums.TransactionStatus;
import com.rtfinancial.enums.TransactionType;
import lombok.*;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class TransactionsDto {

    private Long transactionIdDto;
    private AccountsDto receiverAccountDto;
    private AccountsDto senderAccountDto;
    private Long amountDto;
    private String cuurencyDto;
    private TransactionType transactionTypeDto;
    private TransactionStatus transactionStatusDto;
    private LocalDateTime timestamoDto;
    private String referenceIdDto;

public TransactionsDto from(Transactions entity) {
        TransactionsDtoBuilder builder = TransactionsDto.builder().
                transactionIdDto(entity.getTransactionId()).
                receiverAccountDto(AccountsDto.from(entity.getReceiverAccount())).
                senderAccountDto(AccountsDto.from(entity.getSenderAccount())).
                amountDto(entity.getAmount()).
                cuurencyDto(entity.getCurrency()).
                transactionTypeDto(entity.getTransactionType()).
                transactionStatusDto(entity.getTransactionStatus()).
                timestamoDto(entity.getActionTime()).
                referenceIdDto(entity.getReferenceId());
        return builder.build();
    }


}
