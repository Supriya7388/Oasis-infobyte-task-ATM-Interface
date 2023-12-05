import java.util.Scanner;
public class BankAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    float balance= 100000f;
    int transaction=0;
    String transactionHistory="";

    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your Name -");
        this.name=sc.nextLine();
        System.out.println("\nEnter your username -");
        this.userName=sc.nextLine();
        System.out.println("\nEnter your Password -");
        this.password=sc.nextLine();
        System.out.println("\nEnter your Accout number");
        this.accountNo=sc.nextLine();
        System.out.println("\nRegistration completed..kindly login");
    }

    public boolean login(){
        boolean isLogin=false;
        Scanner sc = new Scanner(System.in);
        while(!isLogin){
            System.out.println("\nEnter your  username -");
            String Username = sc.nextLine();
            if(Username.equals(userName)){
                while(!isLogin){
                    System.out.println("\nEnter your Password -");
                    String Password = sc.nextLine();
                    if(Password.equals(password)){
                        System.out.println("\nLogin Successfull!");
                        isLogin=true;
                    }
                    else{
                        System.out.println("\nIncorrect Password");
                    }
                }
            }
            else{
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;
    }

    public void withdraw(){
        System.out.println("\nEnter amount to withdraw -");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(balance>=amount){
                transaction++;
                balance-=amount;
                System.out.println("\nWithdraw succesfully");
                String str=amount+"Rs Withdrawed\n";
                transactionHistory=transactionHistory.concat(str);
            }
            else{
                System.out.println("\nInsufficient Balance");
            }
        }
        catch(Exception e){
        }
    }

    public void deposite(){
        System.out.println("\nEnter amount to depoisite -");
        Scanner sc= new Scanner(System.in);
        float amount=sc.nextFloat();
        try{
            if(amount<=100000f){
                transaction++;
                balance +=amount;
                System.out.println("\nSuccesfully Deposited");
                String str=amount+"Rs deposited\n";
                transactionHistory=transactionHistory.concat(str);
            }
          else{
                System.out.println("\nSorry...Limit is 100000.00");
            }
        }
        catch(Exception e){
        }
    }

    public void transfer(){
        Scanner sc= new Scanner(System.in);
        System.out.println("\nEnter Receipent's Nsme -");
        Scanner receipent= new Scanner(System.in);
        System.out.println("\nEnter amount to transfer -");
        float amount=sc.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transaction++;
                    balance -= amount;
                    System.out.println("\nSuccesfully transcation to " + receipent);
                    String str = amount + "Rs transfer to " + receipent + "\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else {
                    System.out.println("\nSorry...Limit is 50000.00");
                }
            }
            else {
                System.out.println("\nInsufficient Balance");
            }
        }
        catch(Exception e){
        }
    }

    public void checkBalance(){
        System.out.println("\n"+balance+" Rs ");
    }

    public void transHistory(){
        if(transaction==0){
            System.out.println("\nEmpty");
        }
        else{
            System.out.println("\n"+transactionHistory);
        }
    }
}


