# Projeto de automação de testes de API

### Descrição
Este projeto é um modelo de automação de testes de API Rest e tem por finalidade 
facilitar a execução de testes funcionais.

### Especificação técnica
O projeto foi construído com as seguintes tecnologias:

 * Linguagem de programação JAVA (versão 11);
 * Gerenciador de dependências MAVEN;
 * Biblioteca de automação Rest Assured;
 * JUnit;
 * Gherkin / Cucumber

### Pré requisitos para utilizar o projeto
É necessário possuir o JAVA instalado (JDK 11 ou superior) e ter a IDE configurada
com o Gherkin.

### Estrutura geral
A seguir uma breve descrição da estrutura da aplicação:
* **src**
  * **test**
    * **java**
      * **api :**  Pacote de classes de criação de requisições 
        * **ApiBodies** - Gera o body da requisição
        * **ApiHeaders** - Gera os headers da requisição
        * **ApiQueryParams** - Gera query params para a requisição
        * **ApiRequests** - Implementa e executa os verbos HTTP
        * **ApiUtils** - Representa a estrutura da requisição HTTP
        * **ApiVerbose** - Interface que define quais verbos HTTP precisam ser implementados
      * **payload** - Pacote que contém classe de modelo para entidades usadas em payload
        * **Payload** - Classe abstrata que representa a entidade a ser enviada na requisição
      * **runner** - Pacote que contém a classe de execução dos testes
        * **RunTest** - Classe que executa os testes em geral e exporta relatório dos resultados
      * **steps** - Pacote que contém a implementação dos steps do BDD
        * **CorreioSteps** - Exemplo de implementação de steps da API dos Correios
        * **GorestSteps** - Exemplo de implementação de steps da API Go_Rest
        * **Hooks** - Executa funções comuns ao início e término de cada teste
      * user
        * **User** - Entidade de exemplo da API Go_Rest 
      * **utils** - Pacote com classes utilitárias
        * **JsonUtils** - Contém métodos para manipular arquivos JSON em Java
        * **LogUtils** - Contém métodos para criar logs da execução dos testes
        * **PropertiesUtils** - Configura o ambiente de execução da aplicação
        * **ScenarioUtils** - Configura os cenários de testes
    * **resources** - Pacote com recursos de propriedades
      * **features** - Pacote com os arquivos BDD que descrevem os steps a serem executados
        * **Correios.feature** - Arquivo BDD de exemplo dos cenários da API dos Correios
        * **Gorest.feature** - Arquivo BDD de exemplo dos cenários da API Go_Rest
      * json_files
        * create_user.json
        * update.json
      * dev.properties
      * hom.properties
* pom.xml
* README.md

