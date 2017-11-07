package codingInterview;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;
import java.util.Set;

public class navCalculation {

	private static DecimalFormat df = new DecimalFormat("0.00");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NavCalculation("PORT:AXN,0,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20;XYZ,0,10"));

	}
	
	  public static String NavCalculation(String s){
	      String[] PortBench = s.split("\\|");
	      HashMap<String,Double> PortNavs = NavHelper(PortBench[0].replaceAll("PORT:",""));
	      HashMap<String,Double> BenchNavs = NavHelper(PortBench[1].replaceAll("BENCH:",""));
	      Set<String> union = new HashSet<String>(PortNavs.keySet());
	      union.addAll(BenchNavs.keySet());
	      List<String> sortList = new ArrayList(union);
	      Collections.sort(sortList);
	      List<String> outList = new ArrayList<String>();
	      for(String key:sortList){
	    	  if(PortNavs.containsKey(key) && BenchNavs.containsKey(key))
	    		  outList.add(key+":"+df.format(PortNavs.get(key)-BenchNavs.get(key)));
	    	  else if(PortNavs.containsKey(key))
	    		  outList.add(key+":"+df.format(PortNavs.get(key)));
	    	  else
	    		  outList.add(key+":-"+df.format(BenchNavs.get(key)));
	      }
	      return String.join(",", outList);
	  }
	  
	  public static HashMap<String,Double> NavHelper(String s){
	      HashMap<String, Double> map = new HashMap<String,Double>();
	      double navPort= 0;
	      for(String str:s.split(";")){
	          String[] temp = str.split(",");
	          navPort += Double.parseDouble(temp[1])*Double.parseDouble(temp[2]);
	          map.put(temp[0],Double.parseDouble(temp[1])*Double.parseDouble(temp[2]));
	      }
	      
	      for(String key:map.keySet()){
	          map.put(key,map.get(key)*100/navPort);
	      }
	      return map;
	  }

}
