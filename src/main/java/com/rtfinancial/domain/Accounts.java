package com.rtfinancial.domain;

import com.rtfinancial.dto.AccountsDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * The type Accounts.
 */
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "ACCOUNTS")
@Entity
@Builder
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users user;

    private Long balance;

    private String accountType;

    private LocalDateTime currency;

    private String createAt;

    @OneToMany(mappedBy = "senderAccount")
    private Set<Transactions> senderTransactions;

    @OneToMany(mappedBy = "receiverAccount")
    private Set<Transactions> receiverTransactions;


    /**
     * The enum Account type.
     */
    enum AccountType {
        /**
         * Savings account type.
         */
        SAVINGS,
        /**
         * Checking account type.
         */
        CHECKING,
        /**
         * Current account type.
         */
        CURRENT,
        /**
         * Fixed deposit account type.
         */
        FIXED_DEPOSIT
    }

@Override
    public String toString() {
        return "Accounts{" +
                "accountId=" + accountId +
                ", user=" + user +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", currency=" + currency +
                ", createAt='" + createAt + '\'' +
                ", senderTransactions=" + senderTransactions +
                ", receiverTransactions=" + receiverTransactions +
                '}';
    }

    public static Accounts from(AccountsDto dto) {
        AccountsBuilder builder = Accounts.builder().
                accountId(dto.getAccountIdDto()).
                user(dto.getUserDto()).
                balance(dto.getBalance()).
                accountType(dto.getAccountType()).
                currency(dto.getCurrency()).
                createAt(dto.getCreateAt()).
                senderTransactions(dto.getSenderTransactions()).
                receiverTransactions(dto.getReceiverTransactions());
        return builder.build();

    }

}
