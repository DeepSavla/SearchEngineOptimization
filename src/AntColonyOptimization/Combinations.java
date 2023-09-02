package AntColonyOptimization;

public class Combinations {
	public static void main(String args[]) {
		System.out.println(Combinations(10));
              //  System.out.println(Combi2(10));
	}
        
        
        
        public static String Combi2(int lenght) {
		String combinations = "";
                int[] arr  = new int[lenght];
		
		for (int i = 0; i < lenght; i++) {
			arr[i] = i;	
		}
		          for (int i = 0; i < lenght; i++) {
                              arr = moveArray(arr);
			combinations = combinations + "\n";
                              for (int x = 0; x < lenght; x++) {
                                  combinations = combinations +x+",";
                              }
                         combinations = combinations.substring(0, combinations.length() - 1);
            }
		return combinations;
	}
        
        
        
	
	public static String Combi(int lenght) {
		String combinations = "";
		int[] arr  = new int[lenght];
		
		for (int i = 0; i < lenght; i++) {
			arr[i] = i;	
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr = moveArray(arr);
			combinations = combinations + "\n";
			for (int j = 0; j < arr.length; j++) {
				combinations = combinations + arr[j] + ",";
			}
			combinations = combinations.substring(0, combinations.length() - 1);
		}
		return combinations;
	}
	
	public static String Combinations(int lenght) {
		String combinations = "";
		int[] arr  = new int[lenght];
		
		for (int i = 0; i < lenght; i++) {
			arr[i] = i;	
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr = moveArray(arr);
			combinations = combinations + "\n";
			for (int j = 0; j < arr.length; j++) {
				combinations = combinations + arr[j] + ",";
			}
			combinations = combinations.substring(0, combinations.length() - 1);
		}
		return combinations;
	}

	public static int[] moveArray(int[] moveArray) {
		int orderToRotate = 1;
		for (int i = 0; i < orderToRotate; i++) {
			for (int j = moveArray.length - 1; j > 0; j--) {
				int temp = moveArray[j];
				moveArray[j] = moveArray[j - 1];
				moveArray[j - 1] = temp;
			}
		}
		return moveArray;
	}
}