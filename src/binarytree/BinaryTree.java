
package binarytree;

import java.util.Scanner;

public class BinaryTree {

    public static void main(String[] args) {
      Tree tree=new Tree();
      Scanner k = new Scanner(System.in);
      try{
        while(true){
            
        System.out.println("eklemek istiyorsaniz 1'e basin" +"\n"+ "aramak istiyorsaniz 2'e basin" +"\n"+ "silmak istiyorsaniz 3'e basin");
        int x=k.nextInt();
        if (x==1) {
            System.out.println("eklemek istedigniz degeri giriniz:");
            int y=k.nextInt();
            
            tree.ekle(y);
       
            
            
        }
        else if (x==2) {
            System.out.println("aramak istedigniz degeri giriniz:");
             int y=k.nextInt();
            System.out.println(tree.arama(y));
            
        }
        else if(x==3){
            System.out.println("silmek istedigniz degeri giriniz:");
            int y=k.nextInt();
             tree.delete(y);
        }
        else{
            
             tree.inOrder(tree.kok,null);
                      
        }
            System.out.println("islemi sonlandirmak istiyorsaniz 5'e bsiniz");
            int z=k.nextInt();
            if (z==5) {
                
                System.exit(0);
            }
        }
      }catch(Exception e){ System.out.println(e);  }
     
        
    }

   
      
    
}
