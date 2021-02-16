package my.first_prj;

public class SavingsAccount extends Account {

  public SavingsAccount(int balance) {
    super(balance);
  }

  @Override
  public boolean pay(int amount) {
    System.out.println("Оплата со сберегательного счета запрещена!");
    return false;
  }
}
