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
        Магазин, удаление объектов
    </H2>

    <div>
        (шаблон страницы - delobject.ftl, контроллер - ru.icmit.oodb.lab12.controller.DeleteObjectController)
    </div>

    <h3>
        Удаление сотрудника
    </h3>
    <form method="post" action='${model["app_path"]}/worker/delete'>
        ID сотрудника<input name="workerId"/>
        <input type="submit" value="Удалить"/>
    </form>

    <form method="post" action='${model["app_path"]}/product/delete'>
        ID товара<input name="productId"/>
        <input type="submit" value="Удалить"/>
    </form>

</div>
</body>
</html>