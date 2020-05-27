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
        Товар
    </H2>

    <div>
        (шаблон страницы - product.ftl, контроллер - ru.icmit.oodb.lab12.controller.ProductController)
    </div>

    <form action='${model["app_path"]}/addproduct' method="post">
        <input type="hidden" name="id" value='${model["product"].id!}'/>
        <div style="width:30%">Наименование <input type="text" name="name" value='${model["product"].name!}'/></div>
        <div style="width:30%">Цена <input type="text" name="price" value='${model["product"].price!}'/></div>
        <div style="width:30%">Количество товаров в наличии<input type="text" name="stock" value='${model["product"].stock!}'/>
        </div>
        <input type="submit" value="Сохранить"/>

    </form>
</div>
</body>
</html>