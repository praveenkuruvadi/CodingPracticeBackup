package linkedList;

public class mainPractice {

	public static void main(String[] args) throws Exception {
		linkedList list = new linkedList();
		list.add(5);
		list.add(4);
		list.add(7);
		list.add(9);
		list.add(10);
		list.add(2);
		
		list.traverseList();
		System.out.println("-------------");
		list.add(1,3);
		list.traverseList();
		System.out.println(list.getsize());
		list.delete(4);
		System.out.println(list.getsize());

	}

}
