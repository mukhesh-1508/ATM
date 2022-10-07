import java.sql.*;
import java.util.Scanner;

public class home {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "p1r2e3m4a");
//			if(con!=null) System.out.println("Connected");
//			else System.out.println("Not Connected");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select* from atm");
			while(rs.next()) {
				int value = rs.getInt("denomination")*rs.getInt("number");
			}
			int tot=0;
			while(rs.next()) {
			
			 tot = tot+rs.getInt(3);
			}
			int  TotalAmount=tot;
			 int withdraw, deposit;
		        Scanner s = new Scanner(System.in);
		        
		            System.out.println("******Automated Teller Machine******");
		            System.out.println("Enter your Account number :");
		            int acnum=s.nextInt();
		            System.out.println("Enter your pin");
		            int pinnum=s.nextInt();
		            
		            
    	            int n=0,balance=0;
    	            ResultSet rs1=stmt.executeQuery("select* from Details");
		            while(rs1.next()) {
		            	
		            	if(rs1.getInt("Accno")==acnum) {
		            		if(rs1.getInt("Pinnumber")==pinnum) {
		            			balance=rs1.getInt("AccountBalance");
		            		}
		            	}
		            }
		            while(true)
			        {

		            System.out.println("Choose 1 for Withdraw");
		            System.out.println("Choose 2 for Deposit");
		            System.out.println("Choose 3 for Check Balance");
		            System.out.println("Choose 4 for EXIT");
		            System.out.print("Choose the operation you want to perform:");
		            n=s.nextInt();
		            switch(n)
		            {
		                case 1:
		                System.out.print("Enter money to be withdrawn:");
		                withdraw = s.nextInt();
		                if(balance >= withdraw)
		                {
		                    balance = balance - withdraw;
		                    System.out.println("Please collect your money...");
	                }
		                else
		                {
		                    System.out.println("Insufficient Balance....");
		                }
		                System.out.println("");
		                break;
		 
		                case 2:
		                System.out.print("Enter money to be deposited:");
		                deposit = s.nextInt();
		                balance = balance + deposit;
		                System.out.println("Your Money has been successfully deposited");
		                System.out.println("");
		                break;
		 
		                case 3:
		                System.out.println("Balance : "+balance);
		                System.out.println("");
		                break;
		 
		                case 4:
		                System.exit(0);
		            }
		           
//		            stmt.executeUpdate("Update Details set AccountBalance="+balance+ "where Accno ="+accno);
		        }
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
