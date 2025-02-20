// 1. Одиночка (Singleton) - C++
#include <iostream> using namespace std;

class Singleton { private: static Singleton* instance; Singleton() {}

public: static Singleton* getInstance() { if (!instance) instance = new Singleton(); return instance; } };

Singleton* Singleton::instance = nullptr;

int main() { Singleton* inst1 = Singleton::getInstance(); Singleton* inst2 = Singleton::getInstance(); cout << (inst1 == inst2) << endl; // true return 0; }

// 2. Фабричный метод (Factory Method) - C++ #include <iostream> using namespace std;

class Transport { public: virtual string deliver() = 0; };

class Truck : public Transport { public: string deliver() override { return "Delivering by land in a truck"; } };

class Ship : public Transport { public: string deliver() override { return "Delivering by sea in a ship"; } };

class TransportFactory { public: virtual Transport* createTransport() = 0; };

class TruckFactory : public TransportFactory { public: Transport* createTransport() override { return new Truck(); } };

class ShipFactory : public TransportFactory { public: Transport* createTransport() override { return new Ship(); } };

int main() { TransportFactory* factories[] = {new TruckFactory(), new ShipFactory()}; for (TransportFactory* factory : factories) { Transport* transport = factory->createTransport(); cout << transport->deliver() << endl; delete transport; } return 0; }

// 3. Строитель (Builder) - C++ #include <iostream> using namespace std;

class Car { public: string engine; int wheels; bool sunroof;

void show() {
    cout << "Car(engine=" << engine << ", wheels=" << wheels << ", sunroof=" << sunroof << ")" << endl;
}

};

class CarBuilder { private: Car car; public: CarBuilder& setEngine(string e) { car.engine = e; return *this; } CarBuilder& setWheels(int w) { car.wheels = w; return *this; } CarBuilder& setSunroof(bool s) { car.sunroof = s; return *this; } Car build() { return car; } };

int main() { Car car = CarBuilder().setEngine("V8").setWheels(4).setSunroof(true).build(); car.show(); return 0; }

