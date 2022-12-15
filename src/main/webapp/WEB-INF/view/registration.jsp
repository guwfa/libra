<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            font-size: 16px;
            color: #000;
            background-color: #f8f8f8;
        }
        footer {
            position: absolute;
            left: 0;
            bottom: 0;
            width: 100%;
            height: 50px;
            background-color: #98999b;
            color: #fff;
        }

        /*Формы*/
        .form {
            max-width: 320px;
            padding: 15px;
            margin: 20px auto;
            background-color: #fff;
        }
        .input {
            display: block;
            width: 100%;
            padding: 8px 10px;
            margin-bottom: 10px;

            border: 1px solid #ccc;

            font-family: inherit;
            font-size: 16px;
        }
        .btn {
            display: block;
            width: 100%;
            padding: 8px 10px;

            border: 0;
            background-color: #6c96e2;
            cursor: pointer;

            font-family: inherit;
            font-size: 16px;
            color: #fff;
        }
        .btn:hover {
            background-color: #618ee1;
        }

        /*Всплывающее окно*/
        .dropbtn {
            background-color: #98999b;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;

        }
        .dropdown {
            position: relative;
            display: inline-block;
            float:right;
            margin-right: 35px
        }
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #98999b;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
            margin-right:35px
        }
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            margin-right: 35px
        }
        .dropdown-content a:hover {
            background-color: #53565d;
            margin-right: 35px
        }
        .dropdown:hover .dropdown-content {
            display: block;
            margin-right: 35px
        }
        .dropdown:hover .dropbtn {
            background-color: #98999b;
            margin-right: 35px;
        }

        /*Меню*/
        .link{
            margin-left: 30px;
            margin-right: 30px;
            margin-top: 10px;
            text-align:center;
            line-height: normal;
            height: 50%;
        }

        /*Центральная часть*/
        .parent {
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            overflow: auto;
        }
        .block {
            width: 500px;
            height: 500px;
            position: absolute;
            top: 50%;
            left: 50%;
            margin: -125px 0 0 -125px;
        }

    </style>
</head>
<body>
<main class="parent">
    <menu>
        <div class="menu">
            <div>
                <a class="link" href="/">Главная страница</a>
                <div class="dropdown">
                    <button class="dropbtn">Профиль</button>
                    <div class="dropdown-content">
                        <a href="/profile">Профиль</a>
                        <a href=/logout>Выход</a>
                    </div>
                </div>
            </div>
        </div>
    </menu>
    <form   class="form" action="/registration" method="POST">
        <h1>Регистрация</h1>
        <p><label for="login">Логин<input  class="input" type="text" name="login" id="login" placeholder="Логин" required></label></p>
        <p><label for="firstName">Имя<input class="input"  type="text" name="firstName" id="firstName" placeholder="Имя" required></label></p>
        <p> <label for="secondName">Фамилия<input  class="input" type="text" name="secondName" id="secondName" placeholder="Фамилия" required></label></p>
        <p> <label for="patronymic">Отчество<input  class="input" type="text" name="patronymic" id="patronymic" placeholder="Отчество" required></label></p>
        <p> <label for="password">Пароль<input  class="input" type="password" name="password" id="password" placeholder="Пароль" required></label></p>
        <p><button class="btn"  type="submit" class="btn">Регистрация</button></p>
        <p>Если у вас есть аккаунт - <a href="/login">Авторизация</a></p>
    </form>
    <footer>
        Сделано в СГТУ
    </footer>
</main>
</body>
</html>