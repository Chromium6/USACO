	package web.web_crawler;

import java.util.*;

/**
 * 
 * @author Chromium6
 * 
 * This is the main body for this web crawler program.
 * 
 * @param rootURL
 * 		-Starting point for the search
 * @param term
 * 		-Term to be searching for as the Spider travels
 *
 */

public class Spider {
  private static final int MAX_PAGES_TO_SEARCH = 20;
  private Set<String> visited = new HashSet<String>();
  private List<String> toVisit = new LinkedList<String>();


  /**
   * Our main launching point for the Spider's functionality. Internally it creates spider legs
   * that make an HTTP request and parse the response (the web page).
   * 
   * @param url
   *            - The starting point of the spider
   * @param searchWord
   *            - The word or string that you are searching for
   */
  public void search(String url, String[] words) {
	  for (String k : words) {
		  search(url, k);
	  }
  }
  
  public void search(String url, String searchWord) {
      while(visited.size() < MAX_PAGES_TO_SEARCH) {
          String currentUrl;
          Spiderling leg = new Spiderling();
          if(toVisit.isEmpty()) {
              currentUrl = url;
              visited.add(url);
          }
          else {
              currentUrl = nextUrl();
          }
          leg.crawl(currentUrl); // Lots of stuff happening here. Look at the crawl method in
                                 // SpiderLeg
          boolean success = leg.searchForWord(searchWord);
          if(success) {
              System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
              break;
          }
          toVisit.addAll(leg.getLinks());
      }
      System.out.println("\n**Done** Visited " + visited.size() + " web page(s)");
  }


  /**
   * Returns the next URL to visit (in the order that they were found). We also do a check to make
   * sure this method doesn't return a URL that has already been visited.
   * 
   */
  private String nextUrl() {
      String nextUrl;
      do {
          nextUrl = toVisit.remove(0);
      } while(visited.contains(nextUrl));
      visited.add(nextUrl);
      return nextUrl;
  }
}

/*
public class Spider {
	private static final int maxPagesVisit = 20; // can't keep running forever
	private Set<String> visited = new HashSet<String>();
	private List<String> toVisit = new LinkedList<String>();
	
	public void seekOut(String rootURL, String term) {
		String currentURL;
		Spiderling child = new Spiderling();
		
		while (visited.size() < maxPagesVisit) { // search as many pages as possible
			if (toVisit.isEmpty()) {
				currentURL = rootURL;
				toVisit.add(rootURL);
			}
			else {
				currentURL = nextURL();
			}
			child.crawl(currentURL); // update the page for the spirderling to search
			boolean present = child.seek(term); // check if a term exists on the current page
			if (child.hasLinks()) toVisit.addAll(child.getLinks());
		}
		
	}
	
	public String nextURL() {
		String nextDestination = "";
		do { // eliminate duplicate links and double-travelling/loops
			nextDestination = toVisit.remove(0); // get head node
		} while (visited.contains(nextDestination) && !toVisit.isEmpty());
		visited.add(nextDestination);
		return nextDestination;
	}
	
} */
