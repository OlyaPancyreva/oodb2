<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <link rel='stylesheet' href='${model["app_path"]}/css/lab10.css'>
    <script src='${model["app_path"]}/js/lab10.js'></script>

    <title>Сеть магазинов</title>
</head>
<body>

<div class="menu-bar">
    <ul>
        <li><a class="active" href='${model["app_path"]}'>Главная</a></li>
        <li><a href='${model["app_path"]}/worker/'>Сотрудники</a></li>
        <li><a href='${model["app_path"]}/addworker/'>Новый сотрудник</a></li>
        <li><a href='${model["app_path"]}/product/'>Товары</a></li>
        <li><a href='${model["app_path"]}/addproduct/'>Новый товар</a></li>
        <li><a href='${model["app_path"]}/delobject'>Удаление объектов</a></li>

        <li style="float:right"><a href='${model["app_path"]}/logout'>Выход</a></li>
    </ul>
</div>

<div class="c-wrapper">

    <H2>
        Магазин
    </H2>
    <div>
        <p><strong>Предметная область - магазин</strong>
        <p><strong>Сущности:</strong>
        <ul>
            <li>Сотрудники</li>
            <li>Товары в магазине</li>
        </ul>
        <p><strong>Классы:</strong>
        <p>Описание сотрудника<br>
            @Entity<br>
            public class Worker {<br>

            @Id<br>
            @GeneratedValue<br>
            Long id;<br>
            @Column<br>
            private String name;<br>
            @Column<br>
            private String number;<br>
            @Column<br>
            private String gender;<br>
            @Column<br>
            private Double salary;<br>

        <p>Описание товаров<br>
            @Entity<br>
            public class Product {<br>

            @Id<br>
            @GeneratedValue<br>
            Long id;<br>
            @Column<br>
            private String name;<br>
            @Column<br>
            private double price;<br>
            @Column<br>
            private int stock;<br>

        <p><strong>Структура БД:</strong>
            CREATE TABLE worker(<br>
            id bigint NOT NULL,<br>
            name character varying(255)<br>
            number character varying(255)<br>
            gender character varying(255)<br>
            salary double<br>
            )<br>
            CREATE TABLE product(<br>
            id bigint NOT NULL,<br>
            name character varying(255)<br>
            price double<br>
            stock integer<br>
            )<br>

    </div>

</div>
</body>
</html>