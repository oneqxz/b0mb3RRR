# Что делает b0mb3RRR?
Он спамит вашего любимого собеседника 💞

- ✅ более 30 сервисов
- ✅ асинхронный спам
- ✅ поддержка HTTP прокси
- ✅ оптимизированный код (нет)
- ✅ открытый исходный код
- ⬜️ веб интерфейс
- ⬜️ постряпать куличик
- ⬜️ приготовить блинчики

![Speed](https://raw.githubusercontent.com/oneqxz/b0mb3RRR/master/media/screenshot1.png)
![Call spam](https://raw.githubusercontent.com/oneqxz/b0mb3RRR/master/media/screenshot2.png)
## Установка

Установите бомбер на ваш девайс.
Требуется [java > 21](https://www.azul.com/downloads/?version=java-21-lts&package=jre#zulu)

И скачайте **.jar** файл с последнего [релиза](https://github.com/oneqxz/b0mb3RRR/releases)
## Использование
Что бы задать параментры, используйте:

`-p, --phone` - номер телефона, указывать с +7XXXXXXXXXX

`-c, --cycles` - указывает сколько раз отправиться сообщение (по умолчанию бесконечно)

`-d, --delay` - какая будет задержка между отправкой сообщения (в секундах, по умолчанию 15)

`-dbg` - включает больше вывода информации в консоль

`-pr, -proxy` - позволяет использовать прокси, указать нужно путь к прокси (только http)

формат прокси:
```bash
ip:port
...
```

прокси будут автоматически проверяться.

#### Базовые примеры:
номер телефона +79953054475, задержка 15 секунд и 30 повторений
```bash
java -jar b0mb3RRR-x.x.x.jar -p +79953054475 -d 15 -c 30
```
номер телефона +79953054475, задержка 30 секунд c расширенным выводом
```bash
java -jar b0mb3RRR-x.x.x.jar -p +79953054475 -d 30 -dbg
```
## FAQ

#### 1. Как это работает?
Скрипт просто отправляет запросы на разные сервисы, которые могут отправлять сообшения/звонки

#### 2. Безопасно ли это?
Думаю что... вполне.

#### 3. Не приходят сообщения!
Все это (ответ на первый вопрос) делается на вашем компьютере, так что тут несколько вариантов:
- У вас нету/слабый интернет
- Скрипт устарел
- Используйте прокси или подождите чуть чуть времени

#### 4. Какой тип прокси поддерживается?
Только HTTP (без авторизации)
## Вклад
Вклад всегда приветствуется!


## Отказ от ответственности
За использование бомбера вся отвественность переходит на вас, созданно в ознакомительных целях
## Авторы

- [@ONEQXZ 😎](https://www.github.com/oneqxz)
- [@TERETERY](https://www.github.com/teretery)

## Зависимости

- [Log4J](https://mvnrepository.com/artifact/log4j/log4j)
- [ProjectLombok](https://projectlombok.org/)
- [OkHttp](https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp)
- [CommonsIO](https://mvnrepository.com/artifact/commons-io/commons-io)
- [CommonsCLI](https://mvnrepository.com/artifact/commons-cli/commons-cli)
- [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)
- [Faker](https://github.com/DiUS/java-faker)