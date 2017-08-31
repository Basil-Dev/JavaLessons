package patterns;
/*Этот паттерн - порождающий шаблон проектирования,  определяет стандартный метод создания объекта, не связанный с вызовом конструктора, оставляя решение о том, какой именно объект создавать, за подклассами.*/
public class FactoryMethod
    {
        public static void main(String[] args)
            {
//                patterns.Watch watch1 = new patterns.DigitalWatch();
//                watch1.showTime();
//                patterns.Watch watch2 = new patterns.RomeWatch();
//                watch2.showTime();
                WatchMaker watchMaker = new DigitalWatchMaker();
                watchMaker.createWatch();
            }
    }
interface Watch
    {
        void showTime();
    }
class DigitalWatch implements Watch
    {
        @Override
        public void showTime()
            {
                System.out.println("Digital patterns.Watch");
            }
    }
class RomeWatch implements Watch
    {
        @Override
        public void showTime()
            {
                System.out.println("Rome    patterns.Watch");
            }
    }
interface WatchMaker
    {
        Watch createWatch();
    }
class DigitalWatchMaker implements WatchMaker
    {
        @Override
        public Watch createWatch()
            {
                return new DigitalWatch();
            }
    }
class RomeWatchMaker implements WatchMaker
    {
        @Override
        public Watch createWatch()
            {
                return new RomeWatch();
            }
    }
