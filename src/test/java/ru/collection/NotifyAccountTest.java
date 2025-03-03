package ru.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NotifyAccountTest {
    @Test
    public void whenAddTwoDifferentAccounts() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Ivan Ivanov", "eDer3432f"),
                new Account("142", "Ivan Ivanov", "eDer3432f")
        );
        HashSet<Account> expect = new HashSet<>();
        expect.add(new Account("123", "Ivan Ivanov", "eDer3432f"));
        expect.add(new Account("142", "Ivan Ivanov", "eDer3432f"));
        assertThat(NotifyAccount.sent(accounts)).containsAll(expect);
    }

    @Test
    public void whenAddTwoDuplicateAccounts() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Petrov", "eDer3432f"),
                new Account("123", "Ivan Ivanov", "000000001")
        );
        HashSet<Account> expect = new HashSet<>();
        expect.add(new Account("123", "Petr Petrov", "eDer3432f"));
        assertThat(NotifyAccount.sent(accounts)).containsAll(expect);
    }

    @Test
    public void whenAddSomeDuplicateAccounts() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Vladislav Valeriev", "eDer3432f"),
                new Account("142", "Vladislav Valeriev", "eDer3432f"),
                new Account("123", "Ivan Ivanov", "000000001"),
                new Account("142", "Petr Petrov", "000000002"),
                new Account("123", "Mark Markov", "000000003")
        );
        HashSet<Account> expect = new HashSet<>();
        expect.add(new Account("123", "Vladislav Valeriev", "eDer3432f"));
        expect.add(new Account("142", "Vladislav Valeriev", "eDer3432f"));
        assertThat(NotifyAccount.sent(accounts)).containsAll(expect);
    }
}