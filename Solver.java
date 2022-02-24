import java.util.*;
public class Solver {
    private String input;
    private ArrayList<String> tokens = new ArrayList<>();
    private ArrayList<String> instructions = new ArrayList<>();
    private HashSet<String> dictionary;
	  public Solver(HashSet<String> dictionary) {
        this.dictionary = dictionary;
    }
    // bandaids xd
    public void analyze(String input) {
        this.input = input;
        if(!lex()) {return;}
        if(!parse()) {return;}
        evaluate();
    }
    // break input into tokens, check if tokens are valid
    private boolean lex() {
        // STEPS:                  until here  v
        // 1 - Read until second token(e.g. 45 - 4)
        // 2 - Check if first token is a valid token(45 is a valid token)
        // 3 - Input first token(45 in this case) to tokens
        String buffer = ""; // add characters to this until a valid token is read
        boolean success = true; // check if lexing was successful
        for(int i=0;i<input.length();i++) {
            String check = Character.toString(input.charAt(i));
            if(check.equals(" ")) {
                continue; //not entirely necessary to put this in a separate check, just easier on the eyes
            }
            else if(isToken(check)) {
                if(!buffer.equals("")||!buffer.equals("(")||!buffer.equals("-")) {
                    tokens.add(buffer);
                    tokens.add(check);
                    buffer = "";
                }
                else {p("This token(\""+check+"\") should not be here\n"); success = false;}
            }
            else if(isNumber(check)) {
                buffer += check;
            }
            else {
                p("Token not recognized: "+check+"\n");
                buffer = "";
                success = false;
            }
        }
        tokens.add(buffer);
        p("Tokens recognized: \n");
        int c = 0;
        for(String token : tokens) {
            p("Line "+c+": "+token+"\n");
            c++;
        }
        p("\n");
        return success;
    }
    // check if "grammar" i.e. placement of tokens is correct
    private boolean parse() {
        boolean success = true;
        for(int i=0;i<tokens.size();i++) {
            String token = tokens.get(i);
            if(isNumber(token)) {
                instructions.add();
            }
            if(!isNumber(token)) {
                if(token.equals("-")) {
                    continue;
                }
                else {
                  
                }
            }
        }
        return success;
    }
    // run instructions returned by parser
    private void evaluate() {
      
    }
    private boolean isToken(String s) {
        return dictionary.contains(s);
    }
    private boolean isNumber(String s) {
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException nfe) {return false;}
    }
    private void p(Object o) {System.out.print(o);}
}
