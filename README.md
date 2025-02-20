# Ласкаво просимо до курсу навчання новачків GoF

Цей репозиторій створений для того, щоб допомогти новачкам освоїти патерни проектування з книги "Design Patterns: Elements of Reusable Object-Oriented Software" (GoF) на мовах Python, C++ і Go.

## Зміст
1. Вступ
2. Патерни порождаючих (Creational Patterns)
3. Структурні патерни (Structural Patterns)
4. Поведінкові патерни (Behavioral Patterns)
5. Приклади коду
6. Література

## Вступ
Вітаємо вас у світі патернів проектування! У цьому курсі ви дізнаєтесь про різні типи патернів проектування та як їх використовувати на різних мовах програмування: Python, C++ та Go.

## Патерни порождаючих (Creational Patterns)
Ці патерни використовуються для створення об'єктів, приховуючи логіку створення.

- **Singleton**: Патерн, який гарантує, що у класу є тільки один екземпляр, і надає глобальну точку доступу до нього.
- **Factory Method**: Патерн, який визначає інтерфейс для створення об'єкта, але дозволяє підкласам змінювати тип створюваних об'єктів.

## Структурні патерни (Structural Patterns)
Ці патерни полегшують проектування, забезпечуючи простий спосіб реалізації взаємовідносин між об'єктами.

- **Adapter**: Патерн, який дозволяє об'єктам з несумісними інтерфейсами працювати разом.
- **Decorator**: Патерн, який дозволяє динамічно додавати нову поведінку до об'єктів.

## Поведінкові патерни (Behavioral Patterns)
Ці патерни визначають спосіб взаємодії між об'єктами.

- **Observer**: Патерн, який визначає залежність один до багатьох між об'єктами так, що коли один об'єкт змінюється, всі залежні об'єкти сповіщаються і оновлюються автоматично.
- **Strategy**: Патерн, який дозволяє вибрати алгоритм поведінки під час виконання програми.

## Приклади коду
### Python
```python
class Singleton:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(Singleton, cls).__new__(cls)
        return cls._instance
```

### C++
```cpp
class Singleton {
private:
    static Singleton* instance;
    Singleton() {}

public:
    static Singleton* getInstance() {
        if (instance == nullptr) {
            instance = new Singleton();
        }
        return instance;
    }
};
Singleton* Singleton::instance = nullptr;
```

### Go
```go
package main

import (
    "sync"
)

type Singleton struct{}

var instance *Singleton
var once sync.Once

func GetInstance() *Singleton {
    once.Do(func() {
        instance = &Singleton{}
    })
    return instance
}
```

## Література
1. *Design Patterns: Elements of Reusable Object-Oriented Software* by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
2. Офіційна документація по Python, C++ та Go

## Про мене
Привіт! Мене звати **Кошнарьов Данил**, я софтвер девелопер та розробник ПО. Моя мета - допомогти вам освоїти патерни проектування та стати кращими програмістами.

## Зворотний зв'язок
Якщо у вас є питання чи пропозиції, не соромтеся зв'язатися зі мною.

