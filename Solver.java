import java.util.*;
public class Solver {
    private String input;
    private ArrayList<String> tokens = new ArrayList<>();
    private HashSet<String> dictionary;
	public Solver(HashSet<String> dictionary) {
        this.dictionary = dictionary;
    }
    // bandaids xd
    public void analyze(String input) {
        this.input = input;
        lex();
        parse();
    }
    // break input into tokens, check if tokens are valid
    private boolean lex() {
        // STEPS:                  until here  v
        // 1 - Read until second token(e.g. 45 - 4)
        // 2 - Check if first token is a valid token(45 is a valid token)
        // 3 - Input first token(45 in this case) to tokens
        String buffer = ""; // add characters to this until a valid token is read
        for(int i=0;i<input.length();i++) {
            String check = Character.toString(input.charAt(i));
            if(isToken(check)) {
                if(!buffer.equals("")) {
                    tokens.add(buffer);
                    tokens.add(check);
                    buffer = "";
                }
                else {System.out.println("This token(\""+check+"\") should not be here"); return false;}
            }
        }
        return true;
    }
    private boolean parse() {
        return true;
    }
    private boolean isToken(String s) {
        if(dictionary.contains(s)) {return true;}
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException nfe) {return false;}
        return false;
    }
}