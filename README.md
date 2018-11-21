api-mutants
Detectar Mutantes
Magneto quer recrutar tantos mutantes quanto possível para lutar contra os X-Men. Ele contratou você para desenvolver um projeto que detecta se um Humano é mutante baseado em sua sequência de DNA.

Técnologias
Java 8 Spring Boot Spring Data Rest AWS DynamoDB

Como executar
Usando o mavem utilize os comandos abaixo:
mvn spring-boot:run
ou
mvn clean package
java -jar target/api-mutants-0.0.1-SNAPSHOT.jar

Na Núvem
Projeto foi implantado utilizando os serviços da AWS:

Elastic Beanstalk
DynamoDB
URL
http://api-mutants-v1.us-west-2.elasticbeanstalk.com

HTTP states
Os códigos de status comum de resposta HTTP será usado nesta API.

Media Types
application/json

Endpoints
Validar DNA Humano para verificar se é um Mutante
POST → /mutant/

Host: lhttp://api-mutants-v1.us-west-2.elasticbeanstalk.com/mutant/

Content-Type: application/json

DNA Mutant:

{
  “dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
Response:
200 OK
DNA Humano:

{
  "dna":["AATACT", "CCCAGA", "GGGATT", "AATTCC", "GGATCG", "TCACTG"]
}
Response:
  403 Forbidden
Retornar Estátisticas
GET → /stats/ Host: http://api-mutants-v1.us-west-2.elasticbeanstalk.com/stats/ Content-Type: application/json

Response: 200 (application/json)

{
    count_mutant_dna: 4,
    count_human_dna: 1,
    ratio: 0.8
}
Testes Unitários:
Utilizado spring-boot-starter-test para realizar os testes automatizados com mocks

Cobertura de 74.2%
alt text

Postman
https://www.getpostman.com/collections/8b74840721496a103a01
