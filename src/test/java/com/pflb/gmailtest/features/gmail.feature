#language: ru

Функционал: Вход в систему Gmail
  Описываем: Вход в систему. Позитивный и негативный
  Сценарий: Вход в систему позитивный
    Пусть открыта страница входа на сайт "https://gmail.com"
    И пользователь вводит в поле "имя пользователя" значение "kotionb3505@gmail.com"
    Тогда нажимает кнопку
    И пользователь вводит "Введите пароль" значение "KotionEachB3505"
    Тогда нажимает кнопку
    И пользлователь нажимает кнопку 'Написать' для создания письма
    Тогда  введем адрес "aleksandr.barov13@gmail.com", в теме напишим "Test text" и теле письма запишем "Hello"
    И нажимается кнопка 'Закрыть'
    Тогда пользователь заходит в 'Черновики' и открывает последний черновик
    И нажимается кнопку 'Отправить'
    Если сообщение отправлено получим тект 'Message is send', а если нет 'Sorry, I lost it'
    Если сообщение отправлено, то заходим в 'Отправленные'
    И проведем проверку на адрес, тему и тело письма
    И пишем, что вы молодец
