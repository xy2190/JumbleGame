import java.util.Scanner;


public class MainGame {
	//Game loop
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			Scanner sc = new Scanner(System.in);
			JumbleSolver solver = new JumbleSolver();
			System.out.print("Please input your letters (enter # to exit):");
			String input = sc.next();
			if (input.equals("#")) {
				System.out.println("Goodbye!");
				System.exit(0);
			}	
			solver.solve(input);
		}
	}

}
