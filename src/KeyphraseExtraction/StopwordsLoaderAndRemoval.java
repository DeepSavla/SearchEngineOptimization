package KeyphraseExtraction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class StopwordsLoaderAndRemoval {
	public static  List<String> lines = new  ArrayList<String>();

	

	public static void StopWordLoader() {
		File dir = new File("stopword");
		try {
			String UplodedFilecontent = FileUtils.readFileToString(dir);
			 lines= Arrays.asList(UplodedFilecontent.split("\\r?\\n"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String StopwordsRemoval(String content) {
		Steamming s = new Steamming();
		String words[] = content.split("\\s+");
		String filtrateContent = "";
		for (String w : words) {
			if(!lines.contains(w)){
				filtrateContent = filtrateContent+ " "+s.Steamming(w);
			}
		}
		return filtrateContent;
	}
}
