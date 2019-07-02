
package binarytree;

public class Tree {
    Node kok;
    static Node onceki=null;
    public Tree(){
        kok=null;
    }
    
 
   public void ekle(int deger){
		Node newNode = new Node(deger);
		if(kok==null){
			kok = newNode;
			return;
		}
		Node temp1 = kok;
		Node temp2;
		while(true){
			temp2 = temp1;
			if(deger<temp1.deger){				
				temp1 = temp1.sol;
				if(temp1==null){
					temp2.sol = newNode;
					return;
				}
			}else{
				temp1 = temp1.sag;
				if(temp1==null){
					temp2.sag = newNode;
					return;
				}
			}
		}
   }
     	public int arama(int deger){
		Node temp = kok;
                Node temp1 = null;
		while(temp!=null){
                        
			if(temp.deger==deger){
				return temp1.deger;  
                                
			}else if(temp.deger>deger){
                                temp1=temp;
				temp = temp.sol;                             
			}else{
                                temp1=temp;
				temp = temp.sag;
			}
		}
		return 0;
	}
        
        
        
        public void delete(int key){
        Node temp1 = kok;
        Node temp2 = kok;
        boolean solMu = true;
        if(kok == null){
            System.out.println("silinecek agac yok");
        }
        while(temp1.deger != key){//sileceğimiz elemanı buluyoruz
            temp2 = temp1;
            if(key < temp1.deger){
                solMu = true;
                temp1 = temp1.sol;
            }
            else{
                solMu = false;
                temp1 = temp1.sag;
            }
            if(temp1 == null){
                System.out.println("eleman bulunamadi");
            }
        }
            if(temp1.sag == null && temp1.sol == null){ //sileceğimiz elemanın sağ ve solunda eleman yoksa
                if(temp1 == kok){
                    kok = null;
                }
                else if(solMu){
                   temp2.sol = null;
                }
                else
                    temp2.sag = null;
            }
            else if(temp1.sag == null){//sileceğimiz elemanın sağında eleman yoksa
                if(temp1 == kok){
                    kok = temp2.sol;
                }
                else if(solMu){
                    temp2.sol = temp1.sol;
                }
                else
                   temp2.sag = temp1.sol;
            }
            else if(temp1.sol == null){//sileceğimiz elemanın solunda eleman yoksa
                if(temp1 == kok){
                    kok = temp2.sag;
                }
                else if(solMu){
                    temp2.sol = temp1.sag;
                }
                else
                    temp2.sag = temp1.sag;
            }
            else{                       //sileceğimiz elemanın iki tane çocuğu varsa
                Node sagkucuk = bul(temp1);
                if(temp1 == kok){
                    kok = sagkucuk;
                }
                else if(solMu){
                    temp2.sol = sagkucuk;
                }
                else{
                    temp2.sag =sagkucuk;
                }
                sagkucuk.sol = temp1.sol;
            }
    }


    private Node bul(Node delNode) {
              Node temp1 = delNode;
              Node sagkucuk = delNode;
              Node temp2 = delNode.sag;                       
              while(temp2 != null){                                       
                    temp1 = sagkucuk;
                    sagkucuk = temp2;
                    temp2 = temp2.sol;                    
                    }
                         if(sagkucuk != delNode.sag){                
                    temp1.sol = sagkucuk.sag;
                    sagkucuk.sag = delNode.sag;
                    }
            return sagkucuk;
}
        
      public void inOrder(Node node , Node onceki) {
           
		if (node != null) {
                
                if(onceki==null){System.out.println(" kok = "+node.deger);}
                else if(node==onceki.sag){System.out.println(onceki.deger+"  sagi =  "+node.deger);}
                else if(node==onceki.sol){System.out.println(onceki.deger+"  solu =  "+node.deger);}
                
                inOrder(node.sag,node); 
                
	        inOrder(node.sol,node);
                
                
                
                //System.out.println(node.deger);
                 
		
                
                }
                
 
	}
   
      
     

     
 

   
 
}