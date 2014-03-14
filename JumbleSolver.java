import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JumbleSolver {
	private Set<String> dict = null;
	private ArrayList<String> solutions = null;
	
	public JumbleSolver(){
		// load in dictionary
		try {
			loadDictionary();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void loadDictionary() throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("dict.txt"));
		dict = new HashSet<String>();
		
		while (sc.hasNextLine())
			dict.add(sc.nextLine());
		
	}
	
	//main function
	public void solve(String input) {
		solutions = new ArrayList<String>();
		
		if (input == null || input.length() == 0) {
			System.out.println("Empty input. Try again.");
			return;
		}
		
		char[] inputArr = input.toCharArray();
		Arrays.sort(inputArr);
		String str = new String(inputArr);
		permute("", str, solutions);
		
		printSolution();
	}
	
	//helper function for solve()
	private void permute(String sofar, String rest, ArrayList<String> solutions) {
		if (rest.length() == 0) {
			if (dict.contains(sofar))
				solutions.add(sofar);	
			return;
		}
		
		//valid word before doing permutation on it
		if (dict.contains(sofar))
			solutions.add(sofar);
		
		for (int i = 0; i < rest.length(); i++) {
			String newSofar = sofar + rest.charAt(i);
			String newRest = rest.substring(0, i) + rest.substring(i + 1);
			permute(newSofar, newRest, solutions);
			
			//discard duplicates
			while (i < rest.length() - 1 && rest.charAt(i) == rest.charAt(i + 1))
				i++;
		}
	}

	public void printSolution() {
		if (solutions == null || solutions.size() == 0) {
			System.out.println("No solutions");
			return;
		}
		
		for (String word : solutions)
			System.out.print(word + ", ");
		System.out.println();
	}
}
