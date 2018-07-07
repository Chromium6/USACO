package web.web_crawler;

import java.io.*;
import java.util.*;

import org.jsoup.*; // all of the awesome HTML tools from jsoup
import org.jsoup.nodes.*;
import org.jsoup.select.*;

/**
 * @author Chromium6
 * 
 * This is a simple web crawler which searches a website and its linked websites for a term
 * 
 * @version 1.0
*/

public class SoloCrawler {
	private static final int MAX_PAGES = 20; // search depth limit
	private static final String USER_AGENT = // make the computer think we're a human user
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	private Set<String> visitedPages;
	private List<String> toVisit;
	private Document htmlDoc; // current HTML content
	private boolean offMainPage; // if the crawler is allowed to jump to other sites (e.g. from youtube to facebook)
	
	public SoloCrawler(boolean a) {
		offMainPage = a;
		
		toVisit = new LinkedList<String>();
		visitedPages = new HashSet<String>();
	}
	
	public boolean crawl(String rootURL) {
		return true;
	}
	
	public void getLinks(String url) {
		getLinks(url, 0);
	}
	
	public void getLinks(String url, int depth) {
		depth ++;
		// make sure this page hasn't been accessed before
		if (!visitedPages.contains(url) && depth < MAX_PAGES) {
			try {
				// add it to visited list if not already present
				if (visitedPages.add(url)) {
					System.out.println("Depth " + depth + ": " + url); // @debug
				}
				
				// extract HTML data
				Document doc = Jsoup.connect(url).get();
				// extract links (a href)
				Elements linkParser = doc.select("a[href]");
				// repeat this method for every link
				for (Element link : linkParser) {
					getLinks(link.attr("abs:href"));
				}
			}
			catch (IOException ioe) {
				System.out.println("Error accessing " + url + ": " + ioe.getMessage());
			}
		}
	}
	
	public void searchPage( ) {
		
	}
	
	public void nextLink() {
		
	}
	
	public void seeLinks() {
		for (String link : visitedPages) {
			System.out.println(link);
		}
	}
	
}
