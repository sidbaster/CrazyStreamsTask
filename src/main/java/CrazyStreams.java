import lombok.AllArgsConstructor;
import model.Account;
import util.ExerciseNotCompletedException;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor
public class CrazyStreams {
    private Collection<Account> accounts;

    /**
     * Returns {@link Optional} that contains an {@link Account} with the max value of balance
     *
     * @return account with max balance wrapped with optional
     */
    public Optional<Account> findRichestPerson() {throw new ExerciseNotCompletedException();}

    /**
     * Returns a {@link List} of {@link Account} that have a birthday month equal to provided.
     *
     * @param birthdayMonth a month of birth
     * @return a list of accounts
     */
    public List<Account> findAccountsByBirthdayMonth(Month birthdayMonth) {
        throw new ExerciseNotCompletedException();
    }

    /**
     * Returns a total balance of all accounts.
     *
     * @return total balance of all accounts
     */
    public BigDecimal calculateTotalBalance() {throw new ExerciseNotCompletedException();}

    /**
     * Collects all existing accounts into a {@link Map} where a key is account id, and the value is {@link Account} instance
     *
     * @return map of accounts by its ids
     */
    public Map<Long, Account> collectAccountsById() {
        throw new ExerciseNotCompletedException();
    }


    /**
     * Returns a {@link List} of all first names and last names of all accounts,
     * sorted in alphabetical order.
     *
     * @return a sorted list of first and last names
     */
    public List<String> collectAllNamesSorted() {
        throw new ExerciseNotCompletedException();
    }
}
