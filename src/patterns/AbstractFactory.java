package patterns;
/*Шаблон реализуется созданием абстрактного класса Factory, который представляет собой интерфейс для создания компонентов системы. Затем пишутся классы, реализующие этот интерфейс.*/
public class AbstractFactory {
    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("RU");
        Mouse mouse = factory.getMouse();
        Keyboard keyboard = factory.getKeyboard();
        Touchpad touchpad = factory.getTouchpad();
        mouse.click();
        keyboard.print();
        touchpad.track(10, 32);
    }
    public static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported Country Code: " + lang);
        }
    }
}
interface Mouse {
    void click();
    void dblclick();
    void scroll(int direction);
}
interface Keyboard {
    void print();
    void println();
}
interface Touchpad {
    void track(int deltaX, int deltaY);
}
interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}
class EnDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }
    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }
    @Override
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}
class RuDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }
    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }
    @Override
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}
class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Клик");
    }
    @Override
    public void dblclick() {
        System.out.println("Двойной клик");
    }
    @Override
    public void scroll(int direction) {
        System.out.println("Скролл");
    }
}
class RuKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Печать");
    }
    @Override
    public void println() {
        System.out.println("Печать с новой строки");
    }
}
class RuTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        System.out.println("Тачпад");
    }
}
class EnMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Click");
    }
    @Override
    public void dblclick() {
        System.out.println("Двойной клик");
    }
    @Override
    public void scroll(int direction) {
        System.out.println("Скролл");
    }
}
class EnKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Print");
    }
    @Override
    public void println() {
        System.out.println("Печать с новой строки");
    }
}
class EnTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        System.out.println("patterns.Touchpad");
    }
}