package lesson10;

public class BankAccountDemo
{
    public static void main(String[] args)
    {
        System.out.println("Creating a new account.");
        BankAccount account = new BankAccount( );
        System.out.println("Account balance now = $" 
                                          + account.getBalance( ));

        System.out.println("Depositing $100.00");
        account.makeDeposit("100.00");
        System.out.println("Account balance now = $" 
                                          + account.getBalance( ));

        System.out.println("Depositing $99.99");
        account.makeDeposit("99.99");
        System.out.println("Account balance now = $" 
                                          + account.getBalance( ));

        System.out.println("Depositing $0.01");
        account.makeDeposit("0.01");
        System.out.println("Account balance now = $" 
                                          + account.getBalance( ));

        System.out.println("Closing account.");
        account.closeAccount( );
        System.out.println("Account balance now = $" 
                                          + account.getBalance( ));
        
//        BankAccount.Money m = account.new Money("11") ; 
//        m.addIn(account.new Money("22"));
        

        
//        innerObject.nonstaticMethod();
//        innerObject.staticMethod();
//        OuterClass.InnerClass.staticMethod();

        BankAccount.Money myAccount = new BankAccount.Money("45.2")  ; 
        myAccount.getAmount() ; 
        myAccount.doSomething();
        BankAccount.Money.doSomething();  // doSomething is a static method 
        
    }
}
 