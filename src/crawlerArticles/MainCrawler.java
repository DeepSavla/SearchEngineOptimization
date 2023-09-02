package crawlerArticles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cosine_similarity.cosine_similarity;
import AntColonyOptimization.AntColonyOptimization;
import KeyphraseExtraction.KeyphraseExtractor;

public class MainCrawler {
	public static void main(String args[]) {
		ArrayList<Articles> Articles = new ArrayList<Articles>();
		String SearchTerm = "java%20tutorial";

		Articles = ArticleNameCrawler(SearchTerm, Articles);
		Articles = ArticleContentCrawler(Articles);
		Articles = KeyphraseExtractor.KeyphraseExtractor(Articles);

		// /////////////////-Articles Itrator-///////////////////////////////
		// /////////////////////////////////////////////////////////////////
		double[][] similarityMatrix = new double[Articles.size()][Articles.size()];

		for (int i = 0; i < Articles.size(); i++) {
			Articles art1 = Articles.get(i);
			for (int x = 0; x < Articles.size(); x++) {
				Articles art2 = Articles.get(x);
				similarityMatrix[i][x] = cosine_similarity.cosine_similarity(art1.getContent(), art2.getContent());
			}
		}
		// /////////////////////////////////////////////////////////////////
                
                
                
                
                
                
		System.out.println("Similarity Matrix");
		for (int i = 0; i < Articles.size(); i++) {
			for (int x = 0; x < Articles.size(); x++) {
				System.out.print("\t"+similarityMatrix[i][x]);
			}
			System.out.println("");
		}
		AntColonyOptimization.main(similarityMatrix);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static ArrayList<Articles> ArticleNameCrawler(String SearchTerm,
			ArrayList<Articles> Articles) {
		String theUrl = "https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch="+ SearchTerm;
		theUrl = theUrl.replaceAll("\\s+", "%20");
		String ArticlesName = getUrlContents(theUrl);
		try {
			JSONObject json = new JSONObject(ArticlesName.toString());
			json = json.getJSONObject("query");
			JSONArray search = json.getJSONArray("search");
			for (int i = 0; i < search.length(); i++) {
				json = (JSONObject) search.get(i);
				Articles.add(new Articles(json.get("title").toString().trim(),"",""));
				 System.out.println(json.get("title"));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Articles;
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static ArrayList<Articles> ArticleContentCrawler(
			ArrayList<Articles> Articles) {
		String url = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=";
		for (Articles art : Articles) {
			String content = ArticleContentParser(url + art.getTitle());
                         content = content.replaceAll("[&\\/\\\\#,+()$~%.'\":*?<>{}^@!।'’”“]", "");
			art.setContent(content);
                        art.setOG_content(content);
			// break;
		}
		return Articles;
	}

	public static String ArticleContentParser(String theUrl) {
		theUrl = theUrl.replaceAll("\\s+", "%20");
		String ArticlesContent = getUrlContents(theUrl);
		JSONObject json;
		try {
			json = new JSONObject(ArticlesContent.toString());
			json = json.getJSONObject("query");
			// json = json.getJSONObject("pages");
			json = json.getJSONObject("pages");
			Iterator keys = json.keys();
			while (keys.hasNext()) {
				// loop to get the dynamic key
				String currentDynamicKey = (String) keys.next();
				// get the value of the dynamic key
				JSONObject currentDynamicValue = json
						.getJSONObject(currentDynamicKey);
				// do something here with the value...
				return currentDynamicValue.get("extract").toString().trim();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static String getUrlContents(String theUrl) {
		StringBuilder content = new StringBuilder();
		// many of these calls can throw exceptions, so i've just
		// wrapped them all in one try/catch statement.
		try {
			// create a url object
			URL url = new URL(theUrl);
			// create a urlconnection object
			URLConnection urlConnection = url.openConnection();
			// wrap the urlconnection in a bufferedreader
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(urlConnection.getInputStream()));
			String line;
			// read from the urlconnection via the bufferedreader
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}

}
