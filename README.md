# infuse-test

Requisitos
- Java 17 ou superior
- Maven 3.6+
- Node.js 18+ e npm 8+
- Docker
- MariaDB (se não utilizar containerização para o banco de dados)

1. Rodando Localmente
1.1 Configuração da API Spring Boot
- Certifique-se de que o banco MariaDB está rodando localmente e está configurado corretamente:
- Use o script de criação de tabelas fornecido no projeto.
- Atualize as configurações de acesso ao banco no arquivo application.yml:

spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/nome_do_banco
    username: seu_usuario
    password: sua_senha

- Compile e rode a aplicação:mvn clean package
mvn spring-boot:run

- A API estará disponível em: http://localhost:8080

1.2 Configuração da Aplicação Angular
- Instale as dependências do projeto Angular:

npm install

- Rode o projeto Angular:

npm run start

2. Acessando os Serviços
- API: http://localhost:8080
- Aplicação Angular: http://localhost:4200
- Banco MariaDB: Está disponível na porta 3306.



