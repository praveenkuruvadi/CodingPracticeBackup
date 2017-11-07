package practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class gridLand {

	public static void main(String[] args){
		String[] in = {"4 4 2"};
		String[] out = gridLand(in);
		System.out.println(out[0]);
	}
    static String[] gridLand(String[] inp) {
        String[] output = new String[inp.length];
        for(int i=0;i<inp.length;i++){
            String[] data = inp[i].split(" ");
            int k =Integer.parseInt(data[2]);
            PriorityQueue<String> queue = new PriorityQueue<String>(1, new Comparator<String>(){

				@Override
				public int compare(String arg0, String arg1) {
					return arg0.compareTo(arg1);
				}
            	
            });
            String path="";
            getPath(0,0,Integer.parseInt(data[0]),Integer.parseInt(data[1]),queue,path);
            for(int j=1;j<=k;j++)
                queue.poll();
            output[i]=queue.poll();
        }
        return output;
    }

    static void getPath(int i, int j,int x,int y, PriorityQueue<String> queue,String path){
        if(i==x && j==y){
            queue.add(path);
        }
        else if(i>x || j>y || i<0 || j<0)
            return;
        else{
            getPath(i+1,j,x,y,queue,path+"H");
            getPath(i,j+1,x,y,queue,path+"V");
            //getPath(i-1,j,x,y,queue,path+"H");
            //getPath(i,j-1,x,y,queue,path+"V");
        }
    }
}
