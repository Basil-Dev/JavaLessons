package patterns;
/*aka WRAPPER*/
/*Паттерн проектирования Декоратор (еще называют Wrapper) расширяет функциональность основного класса путем добавления дополнительного кода в начале, конце или вместо существующей реализации.*/
public class Decorator
    {
        public static void main(String[] args)
            {
//                PrinterInterface printer = new Printer("Hello!");
//                printer.print();
                PrinterInterface decorator = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello!"))));
                decorator.print();
            }
    }
interface PrinterInterface
    {
        void print();
    }
class Printer implements PrinterInterface
    {
        private String value;
        public Printer(String value)
            {
                this.value = value;
            }
        @Override
        public void print()
            {
                System.out.print(value);
            }
    }
class QuotesDecorator implements PrinterInterface
    {
        PrinterInterface component;
        public QuotesDecorator(PrinterInterface component)
            {
                this.component = component;
            }
        @Override
        public void print()
            {
                System.out.print("\"");
                component.print();
                System.out.print("\"");
            }
    }
class LeftBracketDecorator implements PrinterInterface
    {
        PrinterInterface component;
        public LeftBracketDecorator(PrinterInterface component)
            {
                this.component = component;
            }
        @Override
        public void print()
            {
                System.out.print("[");
                component.print();
            }
    }
class RightBracketDecorator implements PrinterInterface
    {
        PrinterInterface component;
        public RightBracketDecorator(PrinterInterface component)
            {
                this.component = component;
            }
        @Override
        public void print()
            {
                component.print();
                System.out.print("]");
            }
    }