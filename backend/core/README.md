<h1>1) Запускаем приложение.</h1>
./gradlew

sudo docker-compose build

sudo docker-compose up -d

Без рут-прав (sudo) у меня работать эта штука не хочет.

<h1>2)Запускаем Postman.</h1>
Скачиваем и устанавливаем постман, там ничего сложного нет. После этого нам нужно создать POST-запросы
по адресу http://localhost:8091/users или http://localhost:8091/applications

Пример JSON для users:

{
    "last_name": "Pupkin",
    "first_name": "Vasya",
    "login": "vpupkin",
    "password": "pupkin123"
}
(см. файлик example_of_add_user.png)

После этого выполняем GET-запрос и получаем список добавленных пользователей.

<h1>3)PROFIT!!!</h1>
Вы прекрасны!!!