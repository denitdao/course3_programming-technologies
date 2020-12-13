package ua.kpi.tef.pt.practice;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Pract {

    static public class RPNParserException extends RuntimeException{

    }

    static public class Application {

        public static double parse(String rpnString) throws RPNParserException, ArithmeticException {
            Deque<Double> deque = new LinkedList<>();
            String[] elements = rpnString.split(" ");
            double number1, number2;
            for (String element: elements) {
                switch (element) {
                    case "+":
                        number2 = deque.pop();
                        number1 = deque.pop();
                        deque.push(number1 + number2);
                        break;
                    case "-":
                        number2 = deque.pop();
                        number1 = deque.pop();
                        deque.push(number1 - number2);
                        break;
                    case "/":
                        number2 = deque.pop();
                        number1 = deque.pop();
                        if(number2 == 0)
                            throw new ArithmeticException();
                        deque.push(number1 / number2);
                        break;
                    case "*":
                        number2 = deque.pop();
                        number1 = deque.pop();
                        deque.push(number1 * number2);
                        break;
                    default: {
                        try {
                            deque.push(Double.valueOf(element));
                        } catch (NumberFormatException e) {
                            throw new RPNParserException();
                        }
                    }
                }
            }
            return deque.pop();
        }

        public static void main(String[] args) {
            System.out.println(parse("10 20 + 30 40 + *"));
            System.out.println(parse("10 20 30.0 * +"));
            System.out.println(parse("10 20 30 () +"));
            System.out.println(parse("10 20 Е * +"));
            System.out.println(parse("0 0 /"));
        }
    }
}
