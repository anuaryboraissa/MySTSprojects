
package kaziii;

import java.util.Scanner;

public class Q4lab3 {
  public static void main(String[] anuu){ 
      Scanner input=new Scanner(System.in);
      String name;
      int amount,code,tamount=0,salestax=0;
      System.out.print("Enter the Customer Name: ");
      name=input.nextLine();
      System.out.print("Enter your purchase Amount: ");
      amount=input.nextInt();
      System.out.print("Out of the following tax codes \n 0-tax empty(0%) \n 1-state tax only(3%)"
              + "\n 2-federal and state sales tax only(5%)\n 3-special sales tax (7%) \n Enter tax code: ");
      code=input.nextInt();
      if(code==0){
          salestax=0;
          tamount=amount;
         }
      else if(code==1){
          salestax=(3*amount)/100;
          tamount=amount+salestax;
         }
       else if(code==2){
          salestax=(5*amount)/100;
          tamount=amount+salestax;
         }
      else if(code==3){
          salestax=(7*amount)/100;
          tamount=amount+salestax;
         }
      else{
      System.out.println("Incorrect Tax code");
      }
      System.out.print("Customer Name: "+name+"\n");
      System.out.print("Purchase Amount: "+amount+"\n");
       System.out.print("Sales Tax: "+salestax+"\n");
       System.out.print("Total Amount: "+tamount+"\n");
       }
}
