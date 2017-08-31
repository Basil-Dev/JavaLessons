package patterns;
//Cloneable
/* рекомендуется применять в тех случаях, когда необходимо создать объект, являющийся копией самого себя.
*/
public class Prototype
    {
        public static void main(String[] args)
            {
                Human original = new Human(12,
                                           "Argo");
                System.out.println(original);
                Human copy = (Human) original.copy();
                System.out.println(copy);
            }
    }
interface Copyable
    {
        Object copy();
    }
class Human implements Copyable
    {
        int age;
        String name;
        public Human(int age,
                     String name)
            {
                this.age = age;
                this.name = name;
            }
        @Override
        public Object copy()
            {
                Human copy = new Human(age,
                                       name);
                return copy;
            }
        @Override
        public String toString()
            {
                return "patterns.Human{" +
                        "age=" + age +
                        ", name='" + name + '\'' +
                        '}';
            }
    }
