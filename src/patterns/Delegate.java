package patterns;
public class Delegate
    {
        public static void main(String[] args)
            {
                Painter painter = new Painter();
                painter.setGraphics(new Circle());
                painter.draw();
                painter.setGraphics(new Square());
                painter.draw();
                painter.setGraphics(new Triangle());
                painter.draw();
            }
    }
interface Graphics
    {
        void draw();
    }
class Painter{
    Graphics graphics;
    void setGraphics(Graphics g){
        graphics = g;
    }
    void draw(){
        graphics.draw();
    }
}
class Triangle implements Graphics
    {
        @Override
        public void draw()
            {
                System.out.println("patterns.Triangle");
            }
    }
class Square implements Graphics
    {
        @Override
        public void draw()
            {
                System.out.println("patterns.Square");
            }
    }
class Circle implements Graphics
    {
        @Override
        public void draw()
            {
                System.out.println("patterns.Circle");
            }
    }
