
# Controle de Produtos

## Descrição
O projeto Controle de Produtos é um aplicativo Java que permite a conexão com um banco de dados PostgreSQL e realiza operações de cadastro, consulta, edição e exclusão de produtos.

## Pré-requisitos
Antes de começar, certifique-se de ter o PostgreSQL instalado em seu sistema. Você pode baixá-lo [aqui](https://www.postgresql.org/download/).

Você também precisará baixar o driver JDBC do PostgreSQL para a conexão com o banco de dados. Você pode encontrá-lo [aqui](https://jdbc.postgresql.org/).

## Configuração do Banco de Dados
1. Execute o arquivo `script.sql` localizado dentro do projeto para criar a tabela de produtos no banco de dados.

2. Abra o arquivo `ConnectionFactory.java` localizado na pasta `src/factories` do projeto.

3. Modifique os parâmetros de conexão com o banco de dados de acordo com suas configurações locais de banco de dados.
