package my.first_prj;

public class CreditAccount extends Account {
  public CreditAccount(int balance) {
    super(balance);
  }

  public boolean checkReplenish(int amount) {
    if ((balance + amount) > 0) {
      System.out.printf("Сумма пополнения %d перевышает задолженность %d по кредитному счету!\n"
              , amount, Math.abs(balance));
      return false;
    }
    return true;
  }

  @Override
  public boolean pay(int amount) {
    return writeOff(amount);
  }

  @Override
  public boolean transfer(Account account, int amount) {
    if (account.addMoney(amount)) {
      return writeOff(amount);
    }
    return false;
  }

  @Override
  public boolean addMoney(int amount) {
    if (checkReplenish(amount)) {
      return super.addMoney(amount);
    }
    return false;
  }
}
