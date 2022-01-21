import java.util.Scanner;
public class Atm_final{
    static Scanner scanner = new Scanner(System.in);
    static int a,index;
    static double ab;
    static int arr[] = {0,0,0,0};
    static UserDetails u[] = new UserDetails[5];
    static String state = "Process\t\tAmount\t\tBalance\n";
    static String ATMBank = "RBI";
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        createUser();
        home();
    }
    public static void home(){
        System.out.println("\tATM MACHINE");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.println("3. Exit");
        System.out.print("\nEnter Choice : ");
        a = scanner.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        switch(a){
            case 1:{
                admin();
                break;
            }
            case 2:{
                user();
                break;
            }
            case 3:{
                System.out.println("Thank You For Choosing Our BANK !!!");
                break;
            }
            default:{
                home();
                break;
            }
        }
    }
    public static void admin(){
        System.out.print("Enter UserName : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter PassWord : ");
        int pass = scanner.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if((name.equals("admin") && pass==12345) || (name.equals("manager") && pass==54321)) trueAdmin();
        else{
            System.out.println("Please Check Your Login Credentials");
            home();
        }
    }
    public static void trueAdmin(){
        System.out.println("Welcome Admin !!!\n");
        System.out.println("1. Add Money");
        System.out.println("2. Show Added Amount");
        System.out.println("3. Show ATM Balance");
        System.out.println("4. Exit");
        System.out.print("\nEnter Choice : ");
        a = scanner.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if(a>4 || a<1){
            System.out.println("Enter the choice correctly :( ");
            trueAdmin();
        }
        else if(a==1) add();
        else if(a==2)showA();
        else if(a==3)showM();
        else home();
    }
    public static void add(){
        System.out.println("Enter the Number of Notes \n");
        System.out.println("100 : ");
        arr[0]+=scanner.nextInt();
        System.out.println("200 : ");
        arr[1]+=scanner.nextInt();
        System.out.println("500 : ");
        arr[2]+=scanner.nextInt();
        System.out.println("2000 : ");
        arr[3]+=scanner.nextInt();
        atmbalance();
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueAdmin();
    }
    public static void showA(){
        System.out.println("100 --> "+arr[0]);
        System.out.println("200 --> "+arr[1]);
        System.out.println("500 --> "+arr[2]);
        System.out.println("2000 --> "+arr[3]);
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueAdmin();
    }
    public static void showM(){
        System.out.println(ab);
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueAdmin();
    }
    public static double atmbalance(){
        ab=(100*arr[0])+(200*arr[1])+(500*arr[2])+(2000*arr[3]);
        return ab;
    }
    public static void user(){
        System.out.print("Enter UserName : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter PassWord : ");
        int pass = scanner.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if(check(u,name,pass) && u[index].count<=3) {
            trueUser();
        }
        else{
            u[index].count++;
            System.out.println("Please Check Your Login Credentials");
            if(u[index].count>3){
                System.out.println("too many pin attempt....account locked....please visit near bank");
                System.out.println("Press ENTER to Continue");
                scanner.nextLine();
                String s = scanner.nextLine();
                home();
            }else {
                home();
            }
        }
    }
    public static boolean check(UserDetails[] u,String name,int pass){
        int i=0;
        for(i=0;i<u.length;i++){
            if(u[i].name.equals(name) &&  u[i].pass==pass){
                index=i;
                return true;
            }
        }
        return false;
    }
    public static void trueUser(){
        System.out.println("Welcome "+u[index].name+"\n");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Change pin");
        System.out.println("5. Transaction");
        System.out.println("6. Mini Statement");
        System.out.println("7. Exit");
        System.out.print("\nEnter Choice : ");

        a = scanner.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if(a>7 || a<1){
            System.out.println("Enter the choice correctly :( ");
            trueUser();
        }
        else if(a==1) withdraw();
        else if(a==2)deposit();
        else if(a==3)balance();
        else if(a==4)changePin();
        else if(a==5) transaction();
        else if(a==6) miniStatement();
        else home();
    }
    public static void withdraw() {
        System.out.println("Enter the amount to withdraw : ");
        int a = scanner.nextInt();
        if(a>u[index].balance) System.out.println("Amount exceeds Account balance");
        else if(a>atmbalance()){
            System.out.println("Amount exeeds ATM cash Availability");
        }
        else{
            ab-=a;
            if(!ATMBank.equals(u[index].bank)) {
                u[index].penalty++;
                if(u[index].penalty>5)
                u[index].balance-=20;
            }
            u[index].balance-=a;
            int t=a,temp=0;
            temp=t/2000;
            if(temp>arr[3]){
                temp-=arr[3];
                t=temp*2000;
                if(temp==1) temp=0;
            }else t=t%2000;
            System.out.print(temp+" ");
            temp=t/500;
            if(temp>arr[2]){
                temp-=arr[2];
                t=temp*500;
                if(temp==1) temp=0;
            }else t=t%500;
            System.out.print(temp+" ");
            temp=t/200;
            if(temp>arr[1]){
                temp-=arr[1];
                t=temp*200;
                if(temp==1) temp=0;
            }else t=t%200;
            System.out.print(temp+" ");
            temp=t/100;
            if(temp>arr[0]){
                temp-=arr[0];
                t=temp*100;
                if(temp==1) temp=0;
            }else t=t%100;
            System.out.print(temp+" ");
        }
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        u[index].state+="WithDraw\t"+a+"\t\t"+u[index].balance+"\n";
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void deposit() {
        System.out.println("Enter the amount to deposit : ");
        int a = scanner.nextInt();
        ab+=a;
        u[index].balance+=a;
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        u[index].state+="Deposit\t\t"+a+"\t\t"+u[index].balance+"\n";
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void balance() {
        System.out.println("The balance in your account : "+u[index].balance+"\n");
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void changePin() {
        System.out.println("Enter your old Pin : ");
        int a = scanner.nextInt();
        if(u[index].pass==a){
            System.out.println("Enter your new Pin : ");
            int b = scanner.nextInt();
            u[index].pass=b;
        }
        else {
            System.out.println("Pin is wrong");
        }
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void transaction() {
        System.out.println("IFSC : ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.println("Account no : ");
        String s1 = scanner.nextLine();
        System.out.println("Enter the amount to transfer : ");
        Double d = scanner.nextDouble();
        tranTo(s,s1,d);
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void tranTo(String s,String s1,double d){
        int j=findAccount(u,s1);
        if(j>=0){
            u[index].balance-=d;
            u[j].balance+=d;
            System.out.println("Transaction Successfull");
            u[index].state+="Debited\t\t"+d+"\t\t"+u[index].balance+"\t\tTo Account : "+u[j].acc+"\n";
            u[j].state+="Credited\t"+d+"\t\t"+u[j].balance+"\t\tFrom Account : "+u[index].acc+"\n";
        }
        else System.out.println("Enter valid account number");
    }
    public static int findAccount(UserDetails[] u,String s){
        int i=0;
        for(i=0;i<u.length;i++){
            if(u[i].acc.equals(s)) return i;
        }
        return -1;
    }
    public static void miniStatement(){
        System.out.println(state);
        String ar[] = u[index].state.split("\n");
        if(ar.length>6){
            int i=ar.length-6;
            for(;i<ar.length;i++){
                System.out.println(ar[i]);
            }
        }
        else{
        System.out.println(u[index].state);
        }
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }    public static void createUser() {
        u[0]=new UserDetails("rithik", 1234, 12000.00,"ra123","1234567","","RBI",0,0);
        u[1]=new UserDetails("raghul", 4321, 15000.00,"ra123","1234565","","RBI",0,0);
        u[2]=new UserDetails("ram", 1423, 14500.00,"rb123","1234563","","SBI",0,0);
        u[3]=new UserDetails("rishi", 3241, 11500.00,"rb123","1234561","","SBI",0,0);
        u[4]=new UserDetails("rakesh", 2314, 15700.00,"ra123","1234569","","RBI",0,0);
    }
}
class UserDetails{
    String name,ifsc,acc,state,bank;
    int pass,count,penalty;
    double balance;
    UserDetails(String name,int pass,double balance,String ifsc,String acc,String state,String bank,int count,int penalty){
        this.balance=balance;
        this.name=name;
        this.pass=pass;
        this.ifsc=ifsc;
        this.acc=acc;
        this.state=state;
        this.bank=bank;
        this.count=count;
        this.penalty=penalty;
    }
}
