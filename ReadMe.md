Работа с Retfofit
=================

Демо клиенты
------------
1. Простой GET запрос, возвращающий JSON ClientGetFilesJSON.
2. POST запрос, отправляющий JSON, с применением @Expose.


Надо последовательно реализовать несколько вещей, перечисленных ниже

POJO класс для приема результатов
---------------------------------
К классе должны присутствовать поля как в ответе сервис, например
сервис отвечает:

    {"files":["95441","18298","32292","89309","33826","89544","36033","72950","61492","53934","34301","65090","10172","52471","78835","45871","99791","29529","62579","56350","18148","25668","74107","36837","18617","76268","98808","73696","46403","34140","97963","84633","66083","97221","42221","34209","18723","51126","28075","08057","30760","31177","30870","44576","17130","79337","10763","52260","26612","87753","01023","56919","76114","49966","39797","25295","48367","08871","51134","76751","39542","77936"]}
    
Нужно обязательно сделать поле ``ArrayList<String> files``. Класс в файле  **FilesList**

Интерфейс
---------
В интерфейсе нужно указать метод, который получает Call для POJO класса:

    @GET("file/list")
    Call<FilesList> getFiles()
    
Кроме того, можно указать какие-то дополнительные headers, как в описано в 
http://developer.alexanderklimov.ru/android/library/retrofit.php

Retrofit
--------
Нужно создать класс для запроса, в нем реализовать интерфей 
``implements Callback<FilesList>``. В классе указать фабрику, которая 
будет преобразовывать ответ (в моем случае в Json 
``.addConverterFactory(GsonConverterFactory.create()``)


## Конверторы

Список готовых конвертеров:

Gson: com.squareup.retrofit2:converter-gson
Jackson: com.squareup.retrofit2:converter-jackson
Moshi: com.squareup.retrofit2:converter-moshi
Protobuf: com.squareup.retrofit2:converter-protobuf
Wire: com.squareup.retrofit2:converter-wire
Simple XML: com.squareup.retrofit2:converter-simplexml
Scalars (primitives, boxed, and String): com.squareup.retrofit2:converter-scalars
Также вы можете создать свой собственный конвертер, реализовав интерфейс на основе абстрактного класса Converter.Factory.

http://developer.alexanderklimov.ru/android/library/retrofit.php
