import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args){
        ATMop obj = new ATMop();
    }
}
class Data{
    float balance;
}

class ATMop{

    HashMap< Integer , Data > map = new HashMap<>();  //hashmap for pincode
    Scanner sc = new Scanner(System.in);
    ATMop(){
        System.out.println("***********************************");
        System.out.println("welcome to our ATM");
        System.out.println("***********************************");
        op();                                       //calling op function to perform functions
    }
    public void op(){
        System.out.println("enter your pincode");
        int pincode =sc.nextInt();

        if(map.containsKey(pincode) == true){
            Data obj = map.get(pincode);   // obj contains pincode
            menu(obj);
        }
        else {
            System.out.println("***********************************");
            System.out.println("PLEASE CREATE YOUR ACCOUNT FIRST");
            System.out.println("set you pin code");
            int pin = sc.nextInt();
            Data obj = new Data();
            map.put(pin,obj);
            menu(obj);

        }
    }

    public void menu(Data obj){

        System.out.println("***********************************");

        System.out.println("please enter valid number");

        System.out.println("1. check Balance");
        System.out.println("2. deposit money");
        System.out.println("3. withdraw money");
        System.out.println("4. check another account");
        System.out.println("5. exit");
        System.out.println("__________________________________");

        int x = sc.nextInt();

        if(x==1){
            check_balance(obj);
        }
        else if (x==2){
            deposite(obj);
        }
        else if(x==3){
            withdraw(obj);
        }
        else if (x==4){
            op();
        }
        else if(x==5){
            System.out.println("THANK YOU !!!!");
        }
        else {
            System.out.println("INVALID NUMBER");
            menu(obj);
        }
    }

    public void check_balance( Data obj){           //method 1(x==1)

        System.out.println("***********************************");
        System.out.println("your account balance is " + obj.balance );
        System.out.println("***********************************");
        menu(obj);
    }

    public void deposite(Data obj){              //method 2 (x==2)
        System.out.println("*********************************");

        System.out.println("please enter your amount");
        float a = sc.nextFloat();
        obj.balance = obj.balance + a;
        System.out.println("amount deposited successfully");
        System.out.println("*********************************");
        menu(obj);
    }

    public void withdraw(Data obj){
        System.out.println("*********************************");
        System.out.println("please enter your amount");
        float a = sc.nextFloat();
        if(obj.balance >= a) {
            obj.balance = obj.balance - a;
            System.out.println("amount withdraw successfully");
        }
        else{
            System.out.println("Insufficient balance ");
        }
        System.out.println("*********************************");
        menu(obj);

    }


}
