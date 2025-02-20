// 1. Одиночка (Singleton) - Гарантирует, что класс имеет только один экземпляр. package main

import ( "fmt" "sync" )

type Singleton struct{}

var instance *Singleton var once sync.Once

func GetInstance() *Singleton { once.Do(func() { instance = &Singleton{} }) return instance }

func main() { inst1 := GetInstance() inst2 := GetInstance() fmt.Println(inst1 == inst2) // true, так как оба указывают на один объект }

// 2. Фабричный метод (Factory Method) - Делегирует создание объектов подклассам. package main

import "fmt"

type Transport interface { Deliver() string }

type Truck struct{} func (t Truck) Deliver() string { return "Delivering by land in a truck" }

type Ship struct{} func (s Ship) Deliver() string { return "Delivering by sea in a ship" } }

type TransportFactory interface { CreateTransport() Transport }

type TruckFactory struct{} func (TruckFactory) CreateTransport() Transport { return Truck{} }

type ShipFactory struct{} func (ShipFactory) CreateTransport() Transport { return Ship{} } }

func main() { factories := []TransportFactory{TruckFactory{}, ShipFactory{}} for _, factory := range factories { transport := factory.CreateTransport() fmt.Println(transport.Deliver()) } }

// 3. Строитель (Builder) - Упрощает создание сложных объектов package main

import "fmt"

type Car struct { Engine   string Wheels   int Sunroof  bool }

type CarBuilder struct { car Car }

func (b *CarBuilder) SetEngine(engine string) *CarBuilder { b.car.Engine = engine return b }

func (b *CarBuilder) SetWheels(wheels int) *CarBuilder { b.car.Wheels = wheels return b }

func (b *CarBuilder) SetSunroof(sunroof bool) *CarBuilder { b.car.Sunroof = sunroof return b }

func (b *CarBuilder) Build() Car { return b.car }

func main() { car := CarBuilder{}. SetEngine("V8"). SetWheels(4). SetSunroof(true). Build() fmt.Printf("Built car: %+v\n", car) }

