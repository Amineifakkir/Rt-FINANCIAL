package com.rtfinancial.domain;

import com.rtfinancial.dto.TransactionsDto;
import com.rtfinancial.enums.TransactionStatus;
import com.rtfinancial.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The type Transactions.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "TRANSACTIONS")
@Entity
@Builder
@AllArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SENDER_ACCOUNT_ID")
    @ToString.Exclude
    private Accounts senderAccount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RECEIVER_ACCOUNT_ID")
    @ToString.Exclude
    private Accounts receiverAccount;


    @Column(name = "AMOUNT", nullable = false)
    private Long amount;

    @Column(name = "CURRENCY", nullable = false)
    private String currency;


    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "TRANSACTION_TYPE", nullable = false)
    private TransactionType transactionType;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "TRANSACTION_STATUS", nullable = false)
    private TransactionStatus transactionStatus;

    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime actionTime;

    @Column(name = "REFERENCE_ID", nullable = false)
    private String referenceId;


    public Transactions from(TransactionsDto dto) {
        TransactionsBuilder builder = Transactions.builder().
                transactionId(dto.getTransactionIdDto()).
                senderAccount(Accounts.from(dto.getSenderAccountDto())).
                receiverAccount(Accounts.from(dto.getReceiverAccountDto())).
                amount(dto.getAmountDto()).
                currency(dto.getCuurencyDto()).
                transactionType(dto.getTransactionTypeDto()).
                transactionStatus(dto.getTransactionStatusDto()).
                actionTime(dto.getTimestamoDto()).
                referenceId(dto.getReferenceIdDto());
        return builder.build();

    }



    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Transactions that)) return false;
        return getTransactionId() != null && Objects.equals(getTransactionId(), that.getTransactionId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy hibernateProxy ?
                hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode() :
                getClass().hashCode();
    }
}
