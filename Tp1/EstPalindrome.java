package Tp1;

import java.util.Scanner;

public class EstPalindrome {
   public void estPalindrome(String str){
    int i=0;
    int j=str.length() -1;
    while(i<j){
        if(str.charAt(i) == str.charAt(j)){
            System.out.println("le mot est un palindrome");
i++;
j--;
        } else {
            System.out.println("le mot n'est pas palindrome");
            break;
        }
    }
   }
   public static void main(String[] args) {
    Scanner sn =new Scanner(System.in);
    System.out.println("Entrer un mot : ");
    String str= sn.nextLine();
    EstPalindrome estPalindrome = new EstPalindrome();
    estPalindrome.estPalindrome(str);
   }
    
}