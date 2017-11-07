package SortNSearch;

public class sparseSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"at","","","","ball","","","car","","","dad","",""};
		System.out.println(searchInArray(input,"at",0,input.length));

	}

	private static int searchInArray(String[] input, String elem, int left, int right) {
		// TODO Auto-generated method stub
		if(right<left)
			return -1;
		int mid = (left+right)/2;
		if(input[mid].isEmpty()){
			int leftMove = mid-1;
			int rightMove = mid+1;
			while(input[mid].isEmpty()){
				if(leftMove<left && rightMove>right)
					return -1;
				if(leftMove>=left && !input[leftMove].isEmpty())
					mid = leftMove;
				else if(rightMove<=right && !input[rightMove].isEmpty())
					mid = rightMove;
				leftMove--;
				rightMove++;
			}
		}
		
		if(input[mid].equals(elem))
			return mid;
		if(input[mid].compareTo(elem)>0)
			return searchInArray(input,elem,left,mid-1);
		else
			return searchInArray(input,elem,mid+1,right);
	}

}
