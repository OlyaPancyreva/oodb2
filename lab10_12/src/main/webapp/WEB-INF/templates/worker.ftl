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
        Сотрудник
    </H2>

    <div>
        (шаблон страницы - worker.ftl, контроллер - ru.icmit.oodb.lab12.controller.WorkerController)
    </div>

    <form action='${model["app_path"]}/addworker' method="post">
        <input type="hidden" name="id" value='${model["worker"].id!}'/>
        <div style="width:30%">Имя <input type="text" name="name" value='${model["worker"].name!}'/></div>
        <div style="width:30%">Пол <input type="text" name="gender" value='${model["worker"].gender!}'/></div>
        <div style="width:30%">Номер телефона <input type="text" name="number" value='${model["worker"].number!}'/>
        </div>
        <div style="width:30%">Зарплата <input type="text" name="salary" value='${model["worker"].salary!}'/></div>

        <input type="submit" value="Сохранить"/>

    </form>
</div>
</body>
</html>