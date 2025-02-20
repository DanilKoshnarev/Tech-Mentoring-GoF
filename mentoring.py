#1. Одиночка (Singleton) - Гарантирует, что класс имеет только один экземпляр.

class Singleton: _instance = None

def __new__(cls):
    if cls._instance is None:
        cls._instance = super(Singleton, cls).__new__(cls)
    return cls._instance

inst1 = Singleton() inst2 = Singleton() print(inst1 is inst2)  # True, так как оба указывают на один объект

#2. Фабричный метод (Factory Method) - Делегирует создание объектов подклассам.

from abc import ABC, abstractmethod

class Transport(ABC): @abstractmethod def deliver(self): pass

class Truck(Transport): def deliver(self): return "Delivering by land in a truck"

class Ship(Transport): def deliver(self): return "Delivering by sea in a ship"

class TransportFactory(ABC): @abstractmethod def create_transport(self): pass

class TruckFactory(TransportFactory): def create_transport(self): return Truck()

class ShipFactory(TransportFactory): def create_transport(self): return Ship()

factories = [TruckFactory(), ShipFactory()] for factory in factories: transport = factory.create_transport() print(transport.deliver())

#3. Строитель (Builder) - Упрощает создание сложных объектов

class Car: def init(self, engine=None, wheels=None, sunroof=None): self.engine = engine self.wheels = wheels self.sunroof = sunroof

def __repr__(self):
    return f"Car(engine={self.engine}, wheels={self.wheels}, sunroof={self.sunroof})"

class CarBuilder: def init(self): self.car = Car()

def set_engine(self, engine):
    self.car.engine = engine
    return self

def set_wheels(self, wheels):
    self.car.wheels = wheels
    return self

def set_sunroof(self, sunroof):
    self.car.sunroof = sunroof
    return self

def build(self):
    return self.car

car = CarBuilder().set_engine("V8").set_wheels(4).set_sunroof(True).build() print(f"Built car: {car}")

