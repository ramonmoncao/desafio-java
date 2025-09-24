# Desafio JAVA
Criar uma API que vai devolver a cotação do Bitcoin nas seguintes moedas: Dolar, Reais e Euro.

endpoint: /bitcoin-operations/quotations
VERBO: GET

ex:

`
{
"moedaBase": "bitcoin",
"data": "2023-03-03T08:30:00Z",
"cotacoes": [
{
"valor":"12222.00",
"moeda":"USD"
},
{
"valor":"123.00",
"moeda":"BRL"
},
{
"valor":"345.00",
"moeda":"EUR"
}
]
}
`



API de integração que retorna a cotação do Bitcoin na moeda desejada:
https://api.coinbase.com/v2/prices/BTC-USD/spot

`
{"data":{"base":"BTC","currency":"EUR","amount":"21081.61"}}
`


# Referências

### Documentações

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.3/reference/htmlsingle/#web)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.0.3/reference/htmlsingle/#actuator)

### Guias

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

