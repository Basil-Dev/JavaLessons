package patterns;
import java.util.ArrayList;
import java.util.List;
//Сумки в сумке((1,2)(1,2),1,2,3)
public class Composite
    {
        public static void main(String[] args)
            {
Shape square1 = new Square1();
Shape square2 = new Square1();
Shape triangle = new Triangle1();
Shape circle1 = new Circle1();
Shape circle2 = new Circle1();
Shape circle3 = new Circle1();
Composite1 composite = new Composite1();//сумка в чемодане
composite.addComponent(square1);
composite.addComponent(square2);
composite.addComponent(triangle);
Composite1 composite1 = new Composite1();
composite1.addComponent(circle1);
composite1.addComponent(circle2);
composite1.addComponent(circle3);
composite.addComponent(composite1);
composite.draw();
            }
    }
interface Shape
    {
        public void draw();
    }
class Square1 implements Shape
    {
        @Override
        public void draw()
            {
                System.out.println("patterns.Square");
            }
    }
class Triangle1 implements Shape
    {
        @Override
        public void draw()
            {
                System.out.println("patterns.Triangle");
            }
    }
class Circle1 implements Shape
    {
        @Override
        public void draw()
            {
                System.out.println("patterns.Circle");
            }
    }
class Composite1 implements Shape
    {
        private List<Shape> components = new ArrayList<>();
        public void addComponent(Shape component)
            {
                components.add(component);
            }
        public void removeComponent(Shape component)
            {
                components.remove(component);
            }
        @Override
        public void draw()
            {
                for (Shape component : components)
                    {
                        component.draw();
                    }
            }
    }