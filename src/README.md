Conecta Mentes - Plataforma de Mentorias

  Este repositório contém o código-fonte e a arquitetura de dados do Conecta Mentes, um sistema desenvolvido para otimizar, gerenciar e conectar mentores e mentorados através de agendamento de sessões. O projeto integra uma aplicação desenvolvida em Java com um banco de dados relacional.

Estrutura do Repositório

  Para manter o projeto organizado, os arquivos estão divididos nas seguintes pastas:

/src: Código-fonte da aplicação desenvolvida em Java (classes, conexão com o banco e lógica de negócio).

  /modelagem: Modelos Conceitual e Lógico (arquivos do brModelo e imagens exportadas).

  /scripts: Scripts .sql (DDL e DML) para a criação das tabelas e inserção de dados de teste.

  /documentacao: Apresentação de slides, PDFs e levantamento de requisitos do projeto.

Funcionalidades do Sistema

  Cadastro de Usuários (Mentores e Mentorados).

  Agendamento e gerenciamento de sessões de mentoria.

  Integração direta da aplicação Java com o banco de dados (CRUD completo).

  Mapeamento de regras de negócios para validação de horários e perfis.

  Arquitetura de Banco de Dados

  Abaixo estão as visualizações da modelagem de dados estruturada para o funcionamento seguro e eficiente do sistema.

Modelo Conceitual
  modelagem/MER.png)

Modelo Lógico
  modelagem/ER.png)


Tecnologias e Ferramentas Utilizadas

  Back-end: Java (Desenvolvido no ambiente Eclipse)

  Banco de Dados: Linguagem SQL (PostgreSQL / MySQL)

  Modelagem: brModelo (MER/DER)

  Conceitos Aplicados: Programação Orientada a Objetos (POO), Estruturas de Dados e Análise de Sistemas.

Como executar este projeto

  Clone este repositório para a sua máquina local.

  Execute os scripts localizados na pasta /scripts no seu gerenciador de banco de dados para criar as tabelas.

  Abra a pasta /src na sua IDE (como Eclipse ou VS Code).

  Configure as credenciais de conexão do seu banco de dados na classe de configuração do Java (JDBC).

  Para executar leia a documentação apresentada no arquivo conecta-mentes em java
