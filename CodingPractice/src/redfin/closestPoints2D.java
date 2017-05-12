package redfin;

import java.util.Comparator;
import java.util.PriorityQueue;

public class closestPoints2D {
	
	private static point pointsX[];
	private static point pointsY[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setupPoints();
		System.out.println("Px:");
		for(point p:pointsX)
			System.out.print(p.printPoint()+",");
		System.out.println();
		System.out.println("Py:");
		for(point p:pointsY)
			System.out.print(p.printPoint()+",");
		System.out.println();
		System.out.println("Brute Force min Dist:"+bruteForce(pointsX));
		float minDist = recursiveMinDist(pointsX,pointsY,pointsX.length);
		System.out.println("Recursive solution:"+minDist);

	}
	
	private static float recursiveMinDist(point[] pointsX, point[] pointsY,int len) {
		if(len<=3)
			return bruteForce(pointsX);
		int mid=len/2;
		point midPoint = pointsX[mid];
		System.out.println("midpoint:"+midPoint.printPoint());
		point[] pyLeft= new point[mid+1];
		point[] pyRight= new point[len-mid];
		int il=0,ir=0;
		for(int i=0;i<len;i++){
			if(pointsY[i].getx()<=midPoint.getx())
				pyLeft[il++]=pointsY[i];
			else
				pyRight[ir++]=pointsY[i];
		}
		float leftDist =recursiveMinDist(pointsX,pyLeft,mid);
		float rightDist = recursiveMinDist(pointsX,pyRight,len-mid);
		
		float dist = Math.min(leftDist, rightDist);
		
		// TODO Auto-generated method stub
		return dist;
	}

	private static float bruteForce(point[] points){
		float minDist=Float.MAX_VALUE;
		for(int i=0;i<points.length;i++){
			for(int j=i+1;j<points.length;j++){
				if(minDist>getDist(points[i],points[j]))
					minDist=getDist(points[i],points[j]);
			}
		}
		return minDist;
	}
	private static float getDist(point p1, point p2) {
		return (float) Math.sqrt((Math.abs(p1.getx()-p2.getx())*Math.abs(p1.getx()-p2.getx()))+
				(Math.abs(p1.gety()-p2.gety())*Math.abs(p1.gety()-p2.gety())));
	}

	private static void setupPoints(){
		@SuppressWarnings("unchecked")
		PriorityQueue<point> sortY = new PriorityQueue<point>(1, new Comparator(){
			@Override
			public int compare(Object p1, Object p2) {
				point y1 = (point)p1;
				point y2 = (point)p2;
				return y1.gety()-y2.gety();
			}
		});
		@SuppressWarnings("unchecked")
		PriorityQueue<point> sortX = new PriorityQueue<point>(1, new Comparator(){
			@Override
			public int compare(Object p1, Object p2) {
				point x1 = (point)p1;
				point x2 = (point)p2;
				return x1.getx()-x2.getx();
			}
		});
		
		sortX.add(new point(2,3));
		sortX.add(new point(12,30));
		sortX.add(new point(40,50));
		sortX.add(new point(5,1));
		sortX.add(new point(13,10));
		sortX.add(new point(3,4));
		sortX.add(new point(70,80));
		pointsX= new point[7];
		pointsX = sortX.toArray(pointsX);
		sortY.add(new point(2,3));
		sortY.add(new point(12,30));
		sortY.add(new point(40,50));
		sortY.add(new point(5,1));
		sortY.add(new point(13,10));
		sortY.add(new point(3,4));
		sortY.add(new point(70,80));
		pointsY = new point[7];
		pointsY= sortY.toArray(pointsY);
	}

}

class point{
	private int x; 
	private int y;
	
	public point(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public int getx(){
		return this.x;
	}
	
	public int gety(){
		return this.y;
	}
	
	public String printPoint(){
		return "("+this.x+","+this.y+")";
	}
}