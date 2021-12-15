#language: ru

Функционал: Проверка страхования

  Сценарий: Заявка на страхование для путешественников

    Когда выбирает пункт меню "Страхование"
    И выбирает подпункт меню  "Путешествия"
    И получает заголовок  -   "Страхование путешественников"
    И выполняет нажатие на кнопку 'Оформить онлайн'
    Тогда заговолок страницы = "Страхование путешественников"

    Когда выбирает тип страхования "Минимальная"
    И выполняет нажатие на кнопку 'Оформить'
    И заполняет поля:
      |Фамилия застрахованного|Будаев|
      |Имя застрахованного|Кирилл|
      |Дата рождения застрахованного|10.03.1994|
      |Фамилия страхователя|Будаев|
      |Имя страхователя|Кирилл|
      |Отчество страхователя|Витальевич|
      |Дата рождения страхователя|10.03.1994|
      |Серия паспорта|0000|
      |Номер паспорта|777777|
      |Дата выдачи|15.04.2020|
      |Кем выдан|Отдел ФМС|

    И проверяет значения полей :
      |Фамилия застрахованного|Будаев|
      |Имя застрахованного|Кирилл|
      |Дата рождения застрахованного|10.03.1994|
      |Фамилия страхователя|Будаев|
      |Имя страхователя|Кирилл|
      |Отчество страхователя|Витальевич|
      |Дата рождения страхователя|10.03.1994|
      |Серия паспорта|0000|
      |Номер паспорта|777777|
      |Дата выдачи|15.04.2020|
      |Кем выдан|Отдел ФМС|

    И выполняет нажатие на кнопку 'Продолжить'

    Тогда в поле "Мобильный телефон" присутствует сообщение об ошибке "Поле не заполнено."
    Тогда в поле "Электронная почта" присутствует сообщение об ошибке "Поле не заполнено."
    Тогда в поле "Повтор электронной почты" присутствует сообщение об ошибке "Поле не заполнено."