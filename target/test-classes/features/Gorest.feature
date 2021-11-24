# language: pt
# encoding: UTF-8

@Gorest
Funcionalidade: Criar e editar conta de usuários
  Eu como administrador do sistema
  Quero cadastrar, editar e excluir usuários do sistema
  Para administrar os utilizadores da aplicação

  Contexto:
    Dado que possuo gorest token valido

  Cenario: Cadastrar novo usuário API Gorest
    Quando envio um request de cadastro de usuario com dados validos
    Entao o usuario deve ser criado corretamente
    E o status code do response deve ser 201

  Cenario: Consultar usuario na API
    E existe um usuário cadastrado na API
    Quando consultar este usuário
    Entao os dados do usuário devem ser exibidos na resposta
    E o status code do response deve ser 200
