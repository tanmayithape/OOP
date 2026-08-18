package practice;
import java.util.Scanner;


public class ATM { 
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Balance : ");
			double balance = sc.nextDouble();
			System.out.println("Your Balance is : Rs."+balance);
			
			int choice = 0;
			
			do {
				
				System.out.println("=====ATM=====");
				System.out.println("1.Check Balance");
				System.out.println("2.Deposit Money");
				System.out.println("3.Withdraw Money");
				System.out.println("4.Exit");
				
				System.out.println("Enter your choice(1-4): ");
				
				try {
					choice = sc.nextInt();
					
					switch(choice) {
						
					case 1:
						System.out.println("Your Balance is : Rs."+balance);
						break;
					
					case 2:
						System.out.println("Enter Amount to deposit : ");
						double deposit = sc.nextDouble();
						
						if(deposit <= 0) {
							throw new Exception("Enter a valid Amount!!!");
						}
						balance = balance + deposit;
						System.out.println("Amount added successfully !");
						System.out.println("New Balance :Rs. "+balance);
						break;
						
					case 3:
						System.out.println("Enter Amount to Withdraw : ");
						double withdraw = sc.nextDouble();
						
						if(withdraw > balance) {
							throw new Exception("Insufficient Balance !!!");
						}
						balance = balance - withdraw;
						System.out.println("Withdrawl Successfull !!!!!");
						System.out.println("New Balance : Rs."+balance);
						break;
						
					case 4:
						System.out.println("Thank you for using the ATM!!!!!");
						break;
						
					default:
						System.out.println("Invalid Input !!!");
					
						
					}	
				}catch (Exception a) {
					System.out.println("Error "+a.getMessage());
					
					sc.nextLine();
				}finally {
					System.out.println("===========Transaction Complete===========");
					
				}
			}while (choice != 4);							
	} 
	
}
