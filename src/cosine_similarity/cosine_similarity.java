package cosine_similarity;

import info.debatty.java.stringsimilarity.Cosine;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

public class cosine_similarity {

	public static void main(String[] args) {
		cosine_similarity("sa", "sa");
	}

	public static double cosine_similarity(String s1, String s2) {
//		System.out.println("\nCosine");
		Cosine cos = new Cosine(2);
		DecimalFormat formatter = new DecimalFormat("#0.00");
		return Double.parseDouble(formatter.format(cos.similarity(s1, s2)));
	}
}
