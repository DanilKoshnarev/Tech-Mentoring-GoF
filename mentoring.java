// 1. Одиночка (Singleton) - Гарантирует, что класс имеет только один экземпляр. // Java class Singleton { private static Singleton instance;

private Singleton() {}

public static Singleton getInstance() {
    if (instance == null) {
        instance = new Singleton();
    }
    return instance;
}

}

public class Main { public static void main(String[] args) { Singleton inst1 = Singleton.getInstance(); Singleton inst2 = Singleton.getInstance(); System.out.println(inst1 == inst2); // true } }

// 2. Фабричный метод (Factory Method) - Делегирует создание объектов подклассам. // Java interface Transport { String deliver(); }

class Truck implements Transport { public String deliver() { return "Delivering by land in a truck"; } }

class Ship implements Transport { public String deliver() { return "Delivering by sea in a ship"; } }

interface TransportFactory { Transport createTransport(); }

class TruckFactory implements TransportFactory { public Transport createTransport() { return new Truck(); } }

class ShipFactory implements TransportFactory { public Transport createTransport() { return new Ship(); } }

public class FactoryPattern { public static void main(String[] args) { TransportFactory[] factories = {new TruckFactory(), new ShipFactory()}; for (TransportFactory factory : factories) { System.out.println(factory.createTransport().deliver()); } } }

// 3. Строитель (Builder) - Упрощает создание сложных объектов // Java class Car { private String engine; private int wheels; private boolean sunroof;

private Car(CarBuilder builder) {
    this.engine = builder.engine;
    this.wheels = builder.wheels;
    this.sunroof = builder.sunroof;
}

@Override
public String toString() {
    return "Car(engine=" + engine + ", wheels=" + wheels + ", sunroof=" + sunroof + ")";
}

static class CarBuilder {
    private String engine;
    private int wheels;
    private boolean sunroof;

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setWheels(int wheels) {
        this.wheels = wheels;
        return this;
    }

    public CarBuilder setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
        return this;
    }

    public Car build() {
        return new Car(this);
    }
}

}

public class BuilderPattern { public static void main(String[] args) { Car car = new Car.CarBuilder() .setEngine("V8") .setWheels(4) .setSunroof(true) .build(); System.out.println("Built car: " + car); } }

