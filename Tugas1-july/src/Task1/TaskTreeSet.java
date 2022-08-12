package Task1;

import java.util.Iterator;
import java.util.TreeSet;

public class TaskTreeSet {
	public static void main(String args[]) {
		System.out.println("\n *************** Trik 1 ****************\n"); // Treeset Trik satu
        TreeSet<String> treeset = new TreeSet<String>();
        treeset.add("Silviani");
        treeset.add("Silvi");
        treeset.add("Putri");
        treeset.add("Nur");
        treeset.add("Nurlita");
        treeset.add("Put");
        System.out.println(treeset);

        TreeSet<Integer> treeset2 = new TreeSet<Integer>();
        treeset2.add(8);
        treeset2.add(70);
        treeset2.add(10);
        treeset2.add(20);
        treeset2.add(31);
        treeset2.add(11);
        System.out.println(treeset2); 
        
        
        System.out.println("\n *************** Trik 2 ****************\n"); // Treeset Trik dua
        TreeSet<String> data=new TreeSet<String>();  
        data.add("Silviani");  
        data.add("Nurlita");  
        data.add("Silvi");  
        data.add("Lita"); 
        data.add("Putri"); 
        data.add("Nur");
        Iterator<String> itr=data.iterator();  
        while(itr.hasNext()){  
         System.out.println(itr.next());  
        }  
         
   }
}
