import java.util.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        StdOut.println("hello");
        while(StdIn.isEmpty()) { // Rea`d token, push if operator.`
            String s = StdIn.readString();
            StdOut.print(s);
            if (s.equals("("))
                ;
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            else if (s.equals(")")) {// Pop, evaluate, and push result if token // is ")".

                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+"))
                    v = vals.pop() + v;
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = vals.pop() * v;
                else if (op.equals("/"))
                    v = vals.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                vals.push(v);
            } // Token not operator or paren: push double value.
            else
                vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }

}
