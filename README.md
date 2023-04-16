# REST API Application
Приложение фиксации температуры окружающей среды.
Серверная часть приложение принимает http запросы от сенсоров (датчиков измерений температуры) и записывает их в БД.

В серверной части приложения реализован следующий функционал:
  1. Приложение регистрирует сенсор(датчик) и записывает его имя в БД;
  2. Приложение принимает от датчика измерения температуры и информацию, идёт ли дождь, и записывает эти данные в БД;
  3. Приложение выводит имена всех зарегестрированных сенсоров;
  4. Приложение выводит все сохранённые измерения температуры;
  5. Приложение выводит все дождливые дни.

Функционал клиентской части приложения: https://github.com/Zhdanov-Ilya/rest-api-app-client
