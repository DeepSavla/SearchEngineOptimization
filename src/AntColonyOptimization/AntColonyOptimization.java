package AntColonyOptimization;

import java.util.ArrayList;
import java.util.Arrays;

import DiceCoefficient.DiceCoefficient;

public class AntColonyOptimization {

    public static void main(double[][] similarityMatrix) {

		// double[][] similarityMatrix = {
        // { 0, 8, 0, 6 },
        // { 8, 0, 4, 0 },
        // { 0, 4, 0, 15 },
        // { 6, 0, 15, 0 },
        // };
        int length = similarityMatrix.length;
        ArrayList<Route> Routs = new ArrayList<Route>();
        String comb = Combinations.Combinations(length);
//		String comb = Permute_All_List_Numbers.main(length);
        double[][] combinations = new double[length][length];
        combinations = combParser(comb.trim(), length);
        int Count = 0;
        for (double[] is : combinations) {
            double rout[] = new double[is.length];
//			routToVisite = "";
            double avgScore = 0;
            for (int i = 0; i < is.length; i++) {
                System.out.println(is[i] + "=" + similarityMatrix[Count][(int) is[i]] + " ");

                if (similarityMatrix[Count][(int) is[i]] > avgScore) {
                    avgScore = avgScore + similarityMatrix[Count][(int) is[i]];
                    int div = i + 1;
                    avgScore = avgScore / div;
                    rout[i] = is[i];
                    System.out.println("avgScore:" + avgScore);
                } else {
                    rout[i] = 32165;
                }

            }
            avgScore = avgScore / is.length;
            // System.out.println("");
            Routs.add(new Route(rout, avgScore, Count + 1, null, 0));
            Count++;
            System.out.println("---------");
        }

        for (Route rt : Routs) {

            double[] rt_arr = rt.getElements();
            for (int i = 0; i < rt_arr.length; i++) {
                System.out.print(rt_arr[i] + " ");
            }
            System.out.println("");
            System.out.println(rt.getAntScore());
            System.out.println("");
        }

        DiceCoefficient.DiceCoefficientCal(Routs);
    }

    public static void PrintMatrix(double[][] Matrix) {
        for (double[] arr : Matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static double[][] combParser(String comb, int length) {
        comb = comb.trim();
        double[][] combinations = new double[length][length];
        String Lines[] = comb.split("\n");
        for (int i = 0; i < Lines.length; i++) {
            String Elemenths[] = Lines[i].split(",");
            for (int j = 0; j < Elemenths.length; j++) {
                combinations[i][j] = Integer.parseInt(Elemenths[j]);
            }
        }
        return combinations;
    }

}
