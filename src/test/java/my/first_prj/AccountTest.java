package my.first_prj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AccountTest {
  private Account account1;
  private Account account2;
  private Account account3;

  @BeforeEach
  public void init(){
    account1 = new SavingsAccount(5000);
    account2 = new CreditAccount(-10);
    account3 = new CheckingAccount(1000);
  }
  @Test
  public void checkClasses() {
    assertThat(SavingsAccount.class, typeCompatibleWith(Account.class));
    assertThat(CreditAccount.class, typeCompatibleWith(Account.class));
    assertThat(CheckingAccount.class, typeCompatibleWith(Account.class));
  }

  @Test
  public void checkAccountsBalances() {
    assertThat(account1, hasProperty("balance", greaterThanOrEqualTo(0)));
    assertThat(account2, hasProperty("balance", lessThanOrEqualTo(0)));
    assertThat(account3, hasProperty("balance", greaterThanOrEqualTo(0)));
  }

  @Test
  void pay() {
    //when
    boolean result = account1.pay(1000);
    //then
    assertThat(false, equalTo(result));
    //when
    result = account2.pay(1000);
    //then
    assertThat(true, equalTo(result));
    //when
    result = account3.pay(1000);
    //then
    assertThat(true, equalTo(result));
    //when
    result = account3.pay(1000);
    //then
    assertThat(false, equalTo(result));
  }

  @Test
  void transfer() {
    //when
    boolean result = account1.transfer(account2, 3000);
    //then
    assertThat(false, equalTo(result));
    //when
    result = account1.transfer(account3, 3000);
    //then
    assertThat(true, equalTo(result));
    //when
    result = account1.transfer(account3, 3000);
    //then
    assertThat(false, equalTo(result));
    //when
    result = account2.transfer(account1, 3000);
    //then
    assertThat(true, equalTo(result));
    //when
    result = account3.transfer(account2, 3000);
    //then
    assertThat(true, equalTo(result));
    //when
    result = account3.transfer(account1, 3000);
    //then
    assertThat(false, equalTo(result));
  }

  @Test
  void addMoney() {
    //when
    boolean result = account1.addMoney(1000);
    //then
    assertThat(true, equalTo(result));
    //when
    result = account2.addMoney(1000);
    //then
    assertThat(false, equalTo(result));
    //when
    result = account3.addMoney(1000);
    //then
    assertThat(true, equalTo(result));
  }
}