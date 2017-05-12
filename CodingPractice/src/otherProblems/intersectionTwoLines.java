package otherProblems;

public class intersectionTwoLines {

	public static void main(String[] args) {
		point l1p1 = new point(3,7);
		point l1p2 = new point(5,11);
		point l2p1 = new point(1,3);
		point l2p2 = new point(-2,5);
		
		line l1 = new line(l1p1,l1p2);
		line l2 = new line(l2p1,l2p2);
		
		System.out.println("Line1: "+l1.getA()+"x+"+l1.getB()+"y="+l1.getC()+"|Slope:"+l1.getSlope());
		System.out.println("Line2: "+l2.getA()+"x+"+l2.getB()+"y="+l2.getC()+"|Slope:"+l2.getSlope());
	}
	
//	private static float getSlope(point p1,point p2){
//		return (float) (Math.round(((float)(p2.gety()-p1.gety()))
//				/((float)(p2.getx()-p1.getx()))*100)/100.0);
//	}
	
	
	

}

class line{
	private int a;
	private int b;
	private int c;
	private float slope;
	
	public line(point p1,point p2){
		this.slope = this.getSlope(p1, p2);
		this.a = p1.gety()-p2.gety();
		this.b = p2.getx()-p1.getx();
		this.c = (p1.getx()-p2.getx())*p1.gety()+(p2.gety()-p1.gety())*p1.gety();
		
	}
	public int getA(){
		return this.a;
	}
	public int getB(){
		return this.b;
	}
	public int getC(){
		return this.c;
	}
	public float getSlope(){
		return this.slope;
	}
	
	private float getSlope(point p1,point p2){
		return (float) (Math.round(((float)(p2.gety()-p1.gety()))
				/((float)(p2.getx()-p1.getx()))*100)/100.0);
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
