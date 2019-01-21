# Инструкцию по развертыванию и запуску
Для запуска проекта в IDEA необходимо:
1) Загрузить проект в виде ZIP-архива
2) Распаковать архив
3) Импортировать проект в Intellij IDEA
4) Запустить приложение
5) Перейти по ссылке http://localhost:8080/swagger-ui.html и протестировать API.

Отмечу, что к API данного проекта можно обращаться без использования Swagger'а, перейдя по ссылке http://localhost:8080/api/translate?text=Текст+для+перевода&from=ru&to=en. Причем поля from и to не являются обязательными и по умолчанию имеются значения ru и en соответственно.
