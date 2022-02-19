import java.util.*;
import java.io.*;
public class starter {
	static void p(Object o) {System.out.print(o);}
	public static void main(String args[]) {
		HashSet<String> dictionary = new HashSet<>();
		try {
			Scanner file = new Scanner(new File("dict.txt"));
			while(file.hasNextLine()) {
				dictionary.add(file.nextLine());
			}
		} catch (FileNotFoundException e) {
			p("Dictionary file not found\n");
		}
		Solver sv = new Solver(dictionary);
		try(Scanner sc = new Scanner(System.in)) {
			p("MathExpressionIn: ");
			sv.analyze(sc.nextLine());
		}
	}
}