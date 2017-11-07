package HackerRankJavaOops;
class Add{
    public void add(int... input){
        StringBuilder sb = new StringBuilder();
        int sum =0;
        for(int i:input){
            sum+=i;
            sb.append(i+"+");
        }
        System.out.println(sb.toString().substring(0, sb.toString().length()-1)+"="+sum);

    }
}
public class varargs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add x = new Add();
		x.add(1,2,3,4);

	}

}
