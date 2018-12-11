import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc=new Scanner(System.in);
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while(sc.hasNext()) { // Rea`d token, push if operator.`
            String s = sc.nextLine();
            System.out.print(s);
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
        System.out.println(vals.pop());
    }

}
