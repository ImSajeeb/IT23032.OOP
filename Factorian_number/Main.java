package Factorian;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Fact obj = new Fact();
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the range a and b: "); 
        int a = input.nextInt();
        int b = input.nextInt();
        for(int i = a ; i<=b;i++){
          if(obj.tt(i)){
           System.out.println(i);
          }
        }
      }

}
