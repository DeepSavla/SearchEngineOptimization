package KeyphraseExtraction;

import java.util.ArrayList;

import crawlerArticles.Articles;

public class KeyphraseExtractor {
	
	public static ArrayList<Articles> KeyphraseExtractor(ArrayList<Articles> Articles) {
		StopwordsLoaderAndRemoval.StopWordLoader();
		for (Articles art : Articles) {
			String content = StopwordsLoaderAndRemoval.StopwordsRemoval(art.getContent());
			art.setContent(content);
			System.out.println("content: "+content);
		}
		return Articles;
	}

}
