# language: pt
# encoding: UTF-8

@Gorest @Regressivo
Funcionalidade: Criar e editar conta de usuários
  Eu como administrador do sistema
  Quero cadastrar, editar e excluir usuários do sistema
  Para administrar os utilizadores da aplicação

  Contexto:
    Dado que possuo gorest token valido

  @POST
  Cenario: Cadastrar novo usuário API Gorest
    Quando envio um request de cadastro de usuario com dados validos
    Entao o status code do response deve ser 201
    E o usuario deve ser criado corretamente

  @GET
  Cenario: Consultar usuario na API
    E existe um usuário cadastrado na API
    Quando consultar este usuário
    Entao o status code do response deve ser 200
    E os dados do usuário devem ser exibidos na resposta

  @PUT
  Cenario: Editar usuario na API
    E existe um usuário cadastrado na API
    E altero os dados do usuário
    Quando envio request para editar o usuário
    Entao o status code do response deve ser 200
    E o usuário deve ser alterado com sucesso

  @PATCH
  Cenario: Editar parcialmente usuario na API
    E existe um usuário cadastrado na API
    E altero algum dado do usuário
    Quando envio request para editar parcialmente o usuário
    Então o status code do response deve ser 200
    E o usuário deve ser alterado com sucesso

  @DELETE
  Cenario: Excluir usuario na API
    E existe um usuário cadastrado na API
    Quando envio request para excluir este usuário
    Entao o status code do response deve ser 204
    E o usuário deve ser excluido com sucesso