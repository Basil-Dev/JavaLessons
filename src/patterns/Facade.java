package patterns;
/*Изучим паттерн Фасад (Facade). Этот паттерн - структурный шаблон проектирования, позволяющий скрыть сложность системы путем сведения всех возможных внешних вызовов к одному объекту, делегирующему их соответствующим объектам системы.*/
public class Facade {
    public static void main(String[] args) {
//                patterns.Power power = new patterns.Power();
//                power.on();
//                patterns.DVDRom dvdRom = new patterns.DVDRom();
//                dvdRom.load();
//                dvdRom.unload();
//                patterns.HDD hdd = new patterns.HDD();
//                hdd.copeFromDVD(dvdRom);
        Computer computer = new Computer();
        computer.copy();
    }
}
class Computer {//patterns.Facade
    private Power power = new Power();
    private DVDRom dvdRom = new DVDRom();
    private HDD hdd = new HDD();
    void copy() {
        power.on();
        dvdRom.load();
        hdd.copeFromDVD(dvdRom);
    }
}
class Power {
    void on() {
        System.out.println("patterns.Power ON");
    }
    void off() {
        System.out.println("patterns.Power OFF");
    }
}
class DVDRom {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }
    void load() {
        data = true;
    }
    void unload() {
        data = false;
    }
}
class HDD {
    void copeFromDVD(DVDRom dvd) {
        if (dvd.hasData())
            System.out.println("Copying data from disk...");
        else
            System.out.println("Please, insert data disk");
    }
}
