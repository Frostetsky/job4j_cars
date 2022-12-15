Проект AutoCarMag (job4j_cars)
--
---

Демо видео по работе приложения:

https://www.youtube.com/watch?v=FmapSZ9T7EY

---
Проект является аналогом популярных платформ auto.ru и т.п.
Есть личный кабинет, просмотр всех автомобилей, добавление автомобилей, хороший и удобный интерфейс.
Дополнительно каждый день в 23:55 все проданные автомобили подчищаются и записываются в таблицу events.
---
Стек: Java 11, Spring 5, (MVC, ORM, Security, Thymeleaf), Spring Boot 2,
Hibernate 5, PostgreSQL 9, Liquibase 4.15.0 , Lombok 1.18.24.

---
Для запуска проекта потребуется JDK 11, Maven (3+ version), PostgreSQL база данных.

---
Команды для запуска

```create database cars_market```

```mvn clean```

```mvn compile```

```java -jar {path to jar} ru/cars/app/Job4jCarsApplication.java```

examplePath - C:\Users\Nikita\IdeaProjects\job4j_cars\target\job4j_cars-0.0.1-SNAPSHOT.jar

---
Telegram: @frostetskiy