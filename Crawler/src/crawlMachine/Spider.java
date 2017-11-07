package crawlMachine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider {
	
	private static int MAX_PAGES;
	private Set<String> PagesVisited;
	private List<String> PagesToVisit;
	private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	
	public Spider(int MaxPages){
		this.MAX_PAGES = MaxPages;
		this.PagesVisited = new HashSet<String>();
		this.PagesToVisit = new ArrayList<String>();
	}
	
	public void search(String url, String keyWord){
		String currentURL;
		while(this.PagesVisited.size()<=this.MAX_PAGES){
			if(this.PagesVisited.size() == 0){
				currentURL = url;
				this.PagesVisited.add(url);
			}else{
				currentURL= this.getNextURL();
				if(currentURL == null)
					break;
			}
			this.crawl(currentURL, keyWord);
		}
		this.printList();
	}

	private void crawl(String crawlURL, String keyWord) {
		try{
			Connection conn = Jsoup.connect(crawlURL).userAgent(USER_AGENT);
			Connection connLink;
			Document htmlDocLink;
			Document htmlDoc = conn.get();
			
			if(conn.response().statusCode() == 200 && 
					conn.response().contentType().contains("text/html")){
				System.out.println("Fetched: "+crawlURL);
				Elements linksFound = htmlDoc.select("a[href]");
				for(Element link : linksFound){
					connLink = Jsoup.connect(link.absUrl("href"));
					htmlDocLink = connLink.get();
					
					if(conn.response().statusCode() == 200 && 
							conn.response().contentType().contains("text/html") && 
							htmlDocLink != null){
						
						String text = htmlDocLink.body().text().toLowerCase();
						if(text.contains(keyWord.toLowerCase())){
							this.PagesVisited.add(link.absUrl("href"));
							this.PagesToVisit.add(link.absUrl("href"));
						}else{
							this.PagesToVisit.add(link.absUrl("href"));
						}
					}
				}
			}
		}catch(Exception e){
			System.out.println("Error:"+e.getMessage());
			return;
		}
	}
	
	private void printList(){
		for(String link: this.PagesVisited)
			System.out.println(link);
	}

	private String getNextURL() {
		if(this.PagesToVisit.size() != 0)
			return this.PagesToVisit.remove(0);
		return null;
	}
}
