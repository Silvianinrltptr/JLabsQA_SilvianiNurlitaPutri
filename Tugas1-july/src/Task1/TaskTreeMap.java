package Task1;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TaskTreeMap {
	
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {
	      System.out.println("\n *************** Trik 1 ****************\n"); //Trik 1
	      TreeMap<Integer, String> tremap = new TreeMap<Integer, String>();
	      tremap.put(20, "Siviani");
	      tremap.put(21, "Putri");
	      tremap.put(12, "Nurlita");
	      tremap.put(21, "Indah");
	      tremap.put(57, "Lita");

	      Set set = tremap.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("Usia " + mentry.getValue() + " adalah "+ mentry.getKey() +" tahun \n" );
	      }
	      
	       
	      System.out.println("\n *************** Trik 2 **************** \n"); //Trik 2
	      TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
	      map.put(102,"Nurlita");    
	      map.put(111,"Silvi");    
	      map.put(121,"lita");    
	      map.put(123,"Putri"); 
	      map.put(120,"Silviani"); 
	        
	      for(Map.Entry m:map.entrySet()){    
	       System.out.println(m.getKey()+" "+m.getValue());    
	      }    
	}
}
