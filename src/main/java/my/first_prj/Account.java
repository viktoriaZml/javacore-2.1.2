package my.first_prj;

public abstract class Account {
  protected int balance;

  public Account(int balance) {
    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public boolean writeOff(int amount) {
    balance -= amount;
    return true;
  }

  public boolean checkWriteOff(int amount) {
    if ((balance - amount) < 0) {
      System.out.printf("Сумма списания %d перевышает доступный остаток %d на счете!\n"
              , amount, balance);
      return false;
    }
    return true;
  }

  public boolean pay(int amount) {
    if (checkWriteOff(amount)) {
      return writeOff(amount);
    }
    return false;
  }

  public boolean transfer(Account account, int amount) {
    if (checkWriteOff(amount)){
      if (account.addMoney(amount)) {
        return writeOff(amount);
      }
    }
    return false;
  }

  public boolean addMoney(int amount) {
    balance += amount;
    return true;
  }

}
