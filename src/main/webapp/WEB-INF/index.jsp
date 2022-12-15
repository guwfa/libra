<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>

    <style>
        footer {
            position: absolute;
            left: 0;
            bottom: 0;
            width: 100%;
            height: 50px;
            background-color: #98999b;
            color: #fff;
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
        <div class="block">
            <h1>Добро пожаловать</h1>
        </div>
        <footer>
            Сделано в СГТУ
        </footer>
    </main>
</body>
</html>