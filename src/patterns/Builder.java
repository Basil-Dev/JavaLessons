package patterns;

public class Builder {
    public static void main(String[] args) {
//                patterns.Car car = new patterns.CarBuilder().buildMake
// ("Mersedes")
//                        .buildTransmission(patterns.Transmission.AUTO)
//                        .buildMaxSpeed(250)
//                        .build();
//                System.out.println(car);
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }
}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "patterns.Car{" +
               "make='" + make + '\'' +
               ", transmission=" + transmission +
               ", maxSpeed=" + maxSpeed +
               '}';
    }
}

abstract class CarBuilder {
    Car car;

    public void createCar() {car = new Car();}

    abstract void buildMake();

    abstract void buildTransmission();

    abstract void MaxSpeed();

    Car getCar() {return car;}
}

class FordBuilder extends CarBuilder {
    @Override
    void buildMake() {
        car.setMake("Ford");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void MaxSpeed() {
        car.setMaxSpeed(260);
    }
}

class SubaruBuilder extends CarBuilder {
    @Override
    void buildMake() {
        car.setMake("Subaru");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void MaxSpeed() {
        car.setMaxSpeed(320);
    }
}

class Director {
    CarBuilder builder;

    void setBuilder(CarBuilder b) {builder = b;}

    Car buildCar() {
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.MaxSpeed();
        Car car = builder.getCar();
        return car;
    }
}
//class patterns.CarBuilder
//    {
//        String m = "Default";
//        patterns.Transmission t = patterns.Transmission.MANUAL;
//        int s = 120;
//
//        patterns.CarBuilder buildMake(String m)
//            {
//                this.m = m;
//                return this;
//            }
//
//        patterns.CarBuilder buildTransmission(patterns.Transmission t)
//            {
//                this.t = t;
//                return this;
//            }
//
//        patterns.CarBuilder buildMaxSpeed(int s)
//            {
//                this.s = s;
//                return this;
//            }
//
//        patterns.Car build()
//            {
//                patterns.Car car = new patterns.Car();
//                car.setMake(m);
//                car.setTransmission(t);
//                car.setMaxSpeed(s);
//                return car;
//            }
//    }