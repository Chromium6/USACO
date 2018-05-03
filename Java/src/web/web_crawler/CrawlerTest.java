package web.web_crawler;

public class CrawlerTest {
	
	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		// SoloCrawler
		SoloCrawler k = new SoloCrawler(true);
		k.getLinks("https://www.youtube.com/watch?v=SIXAytRvDQ0");
		//k.seeLinks();
		/* Spider test
		Spider crawler = new Spider();
		crawler.search("http://www.usaco.org/", "bessie");
		*/
		final long endTime = System.currentTimeMillis();
		System.out.println("Execution time: " + (endTime-startTime) + " ms");
	}
	
}
