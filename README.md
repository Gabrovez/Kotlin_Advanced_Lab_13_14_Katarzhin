# Лабораторная работа №13-14
Коллекции, обобщения и функциональный стиль в Kotlin
## Описание
Данная лабораторная работа посвящена изучению продвинутых возможностей языка Kotlin,
которые активно используются при разработке Android-приложений.
В рамках работы рассматриваются:
- обобщённые типы (Generics);
- коллекции Kotlin;
- функции высшего порядка;
- extension-функции;
  Все примеры ориентированы на практическое применение и подготовку к разработке
  мобильных приложений.
## Как запустить проект
1. Клонируйте репозиторий:
```bash
git clone <https://github.com/Gabrovez/KOTLIN_13-14>
```
## Автор
Катаржин Григорий
## Лицензия
Проект создан в учебных целях.
### Обобщённые типы (Generics)
Generics позволяют создавать универсальные классы и функции, которые работают с разными типами данных без дублирования кода.

**Содержит:**
1. Плейсхолдеры типов (T, E, K, V)
2. Типобезопасную работу с разными типами данных
3. Сокращение дублирования кода при одинаковой логике для разных типов
#### Пример: универсальный класс вопроса викторины
```kotlin
enum class Difficulty { EASY, MEDIUM, HARD }

data class Question<T>(
    val text: String,
    val answer: T,
    val difficulty: Difficulty
)

fun main() {
    val question1 = Question<String>(
        text = "Столица Франции?",
        answer = "Париж",
        difficulty = Difficulty.EASY
    )
    
    val question2 = Question<Boolean>(
        text = "Земля плоская?",
        answer = false,
        difficulty = Difficulty.MEDIUM
    )
    
    val question3 = Question<Int>(
        text = "2 + 2 = ?",
        answer = 4,
        difficulty = Difficulty.HARD
    )
}
```
### Перечисления (enum class)
Enum class используется для определения ограниченного набора допустимых значений с контролем на этапе компиляции.

**Содержит:**
1. Строгую типизацию допустимых значений
2. Защиту от опечаток и недопустимых значений
3. Упрощение рефакторинга и поддержки кода
#### Пример: уровни сложности вопросов
```kotlin
enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}
```
### Классы данных (data class)
Data class автоматически генерирует стандартные методы для классов, предназначенных исключительно для хранения данных.

**Содержит:**
1. Автоматическую генерацию equals(), hashCode(), toString()
2. Метод copy() для создания копий с изменёнными полями
3. Деструктуризацию через componentN() функции
#### Пример
```kotlin
data class Question<T>(
    val text: String,
    val answer: T,
    val difficulty: Difficulty
)

fun main() {
    val question = Question("Столица Франции?", "Париж", Difficulty.EASY)
    println(question)  
    
    val copied = question.copy(answer = "Лондон")
    println(copied)  
}
```
### Singleton и объекты-компаньоны

**Содержит:**
1. `object` - создание единственного экземпляра класса (паттерн Singleton)
2. `companion object` - статические методы и свойства внутри класса
3. Глобальный доступ к общему состоянию
#### Пример
```kotlin
class Quiz {
    companion object StudentProgress {
        var questionsAnswered = 0
        var totalQuestions = 10
    }
    
    fun printProgress() {
        println("Прогресс: $questionsAnswered из $totalQuestions")
    }
}

fun main() {
    Quiz.questionsAnswered = 5
    Quiz.totalQuestions = 10
    Quiz().printProgress()  
}
```
### Расширения классов (Extensions)
Extension-функции и свойства позволяют добавлять новые возможности к существующим классам без изменения их исходного кода.

**Содержит:**
1. Добавление методов и свойств к любому классу
2. Использование точечной нотации как для обычных методов
3. Расширение функциональности сторонних библиотек
#### Пример
```kotlin
val Quiz.StudentProgress.progressText: String
    get() = "Прогресс: $questionsAnswered из $totalQuestions"

fun Quiz.StudentProgress.printProgressBar() {
    val filled = "▓".repeat(questionsAnswered)
    val empty = "▒".repeat(totalQuestions - questionsAnswered)
    println("$filled$empty ${progressText}")
}

fun main() {
    Quiz.questionsAnswered = 7
    Quiz.totalQuestions = 10
    Quiz.StudentProgress.printProgressBar()
}
```
### Коллекции Kotlin
### Массивы (Arrays)
Фиксированный размер, быстрый доступ по индексу.
```kotlin
val planets = arrayOf("Mercury", "Venus", "Earth", "Mars")
println(planets[0])  
planets[3] = "Jupiter"  
```
### Списки (Lists)
Упорядоченная коллекция с изменяемым размером.
```kotlin
val readOnlyList = listOf("Mercury", "Venus", "Earth")

val mutableList = mutableListOf("Mercury", "Venus")
mutableList.add("Earth")  
mutableList.add(1, "Mars")  
mutableList.remove("Venus")  
```
### Множества (Sets)
Коллекция уникальных элементов без гарантированного порядка.
```kotlin
val uniquePlanets = mutableSetOf("Earth", "Mars", "Jupiter")
uniquePlanets.add("Earth")  
println(uniquePlanets.size)  
```
### Карты (Maps)
Коллекция пар "ключ-значение" с уникальными ключами
```kotlin
val planetMoons = mutableMapOf(
    "Earth" to 1,
    "Mars" to 2,
    "Jupiter" to 79
)

planetMoons["Saturn"] = 82  
println(planetMoons["Jupiter"])  
planetMoons.remove("Mars")  
```
### Функции высшего порядка
Функции высшего порядка принимают другие функции в качестве параметров или возвращают их.

**Содержит:**
1. Передачу функций как параметров
2. Возврат функций из функций
3. Лямбда-выражения и ссылки на функции
#### Пример
```kotlin
fun action(a: Int, b: Int, operation: (Int, Int) -> Int) {
    println(operation(a, b))
}

fun sum(x: Int, y: Int) = x + y
fun multiply(x: Int, y: Int) = x * y

fun main() {
    action(5, 3, ::sum)       // 8
    action(5, 3, ::multiply)  // 15
    action(5, 3) { x, y -> x - y }  // 2 (лямбда)
}
```
### Обработка коллекций через функции высшего порядка

**Содержит:**
1.    `forEach()` — выполнение действия для каждого элемента
2.    `map()` — преобразование элементов в новую коллекцию
3.    `filter()` — фильтрация элементов по условию
4.    `groupBy()` — группировка элементов по ключу
5.    `fold()` — свёртка коллекции в одно значение
6.    `sortedBy()` — сортировка по свойству
#### Пример: обработка списка печенья
```kotlin
data class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

fun main() {
    val cookies = listOf(
        Cookie("Печенье с шоколадом", false, false, 1.69),
        Cookie("Нуга ореховая", true, false, 1.49),
        Cookie("Ванильный крем", false, true, 1.59),
        Cookie("Черничный пирог", true, true, 1.79)
    )
    
    cookies.forEach { 
        println("${it.name} - \$${it.price}") 
    }
    
    val menu = cookies.map { 
        "${it.name} - \$${it.price}" 
    }
    
    val softCookies = cookies.filter { it.softBaked }
    
    val grouped = cookies.groupBy { it.softBaked }
    
    val total = cookies.fold(0.0) { acc, cookie -> 
        acc + cookie.price 
    }
    
    val sorted = cookies.sortedBy { it.price }
}
```
