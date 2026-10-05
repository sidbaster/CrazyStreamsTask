import model.Account;
import model.Sex;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrazyStreamsTest {
    private CrazyStreams streams;
    private static List<Account> accounts = Arrays.asList(
            new Account(1L, "Justin", "Butler", "justin.butler@gmail.com",
                    LocalDate.parse("2003-04-17"), Sex.MALE, LocalDate.parse("2016-06-13"), BigDecimal.valueOf(172966)),
            new Account(2L, "Olivia", "Cardenas", "cardenas@mail.com",
                    LocalDate.parse("1930-01-19"), Sex.FEMALE, LocalDate.parse("2014-06-21"), BigDecimal.valueOf(38029)),
            new Account(3L, "Nolan", "Donovan", "nolandonovan@gmail.com",
                    LocalDate.parse("1925-04-19"), Sex.MALE, LocalDate.parse("2011-03-10"), BigDecimal.valueOf(13889)),
            new Account(4L, "Lucas", "Lynn", "lucas.lynn@yahoo.com",
                    LocalDate.parse("1987-05-25"), Sex.MALE, LocalDate.parse("2009-03-05"), BigDecimal.valueOf(16980))
    );

    @BeforeEach
    void setUp() {
        streams = new CrazyStreams(accounts);
    }

    @Test
    @Order(1)
    void findRichestPerson() {
        Optional<Account> expectedPerson = Optional.of(accounts.getFirst());
        Optional<Account> actualRichestPerson = streams.findRichestPerson();

        assertEquals(expectedPerson, actualRichestPerson);
    }

    @Test
    @Order(2)
    void findAccountsByBirthdayMonth() {
        List<Account> expectedList = getExpectedList();
        List<Account> aprilAccounts = streams.findAccountsByBirthdayMonth(Month.APRIL);

        assertEquals(expectedList, aprilAccounts);
    }

    @Test
    @Order(6)
    void calculateTotalBalance() {
        BigDecimal totalBalance = streams.calculateTotalBalance();

        assertEquals(BigDecimal.valueOf(241864), totalBalance);
    }

    @Test
    @Order(11)
    void collectAccountsById() {
        Map<Long, Account> idToAccountMap = streams.collectAccountsById();

        assertEquals(accounts.get(0), idToAccountMap.get(1L));
        assertEquals(accounts.get(1), idToAccountMap.get(2L));
        assertEquals(accounts.get(2), idToAccountMap.get(3L));
        assertEquals(accounts.get(3), idToAccountMap.get(4L));
    }

    @Test
    @Order(12)
    void collectAllNamesSorted() {
        List<String> expectedNames = List.of(
                "Butler", "Cardenas", "Donovan", "Justin",
                "Lucas", "Lynn", "Nolan", "Olivia");

        List<String> actualNames = streams.collectAllNamesSorted();

        assertEquals(expectedNames, actualNames);
    }

    private List<Account> getExpectedList() {
        return Arrays.asList(accounts.get(0), accounts.get(2));
    }
}
