package my.first_prj;

public class Main {

  public static void main(String[] args) {
    Account account1 = new SavingsAccount(50000);
    Account account2 = new CreditAccount(0);
    Account account3 = new CheckingAccount(1000);

    account1.pay(500);
    account2.pay(500);
    account3.pay(150);
    account1.transfer(account2, 5000);
    account3.transfer(account2, 1000);
    account3.pay(5000);
    account2.transfer(account3, 4000);
    account1.transfer(account2, 3000);

    System.out.println(account1.getBalance());
    System.out.println(account2.getBalance());
    System.out.println(account3.getBalance());
  }
}
