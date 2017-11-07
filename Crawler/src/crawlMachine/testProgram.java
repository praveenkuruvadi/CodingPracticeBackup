package crawlMachine;

public class testProgram {

	public static void main(String[] args) {
		Spider spider = new Spider(20);
		spider.search("http://www.manutd.com/", "rooney");
	}

}
