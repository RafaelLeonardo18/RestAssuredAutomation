# language: pt
# encoding: UTF-8

@Fretes @Regressivo
Funcionalidade: Calcular valor de fretes
  Eu como usuário da API dos Correios
  Quero calcular o valor do frete de acordo com as informações fornecidas
  Para precificar o frete e saber o prazo de entrega

  Contexto:
    Dado que possuo dados válidos para consulta na API Correios

  @GET
  Cenario: Calcular o valor do frete
    Quando envio um request de consulta para a API Correios
    Entao o status code deve ser 200
    E o valor do frete deve ser calculado

  @DATATABLE
  Cenario: Calcular frete usando DataTable
    Quando envio um request de consulta para a API Correios usando DataTable
    | sCepOrigem | sCepDestino | nVlPeso | nVlComprimento | nVlAltura | nVlLargura |
    | 74371520   | 1327000     | 3.00    | 40.00          | 20.00     | 25         |
    Entao o status code deve ser 200
    E o valor do frete deve ser igual a "40,60"

  @ESQUEMADECENARIO
  Esquema do Cenario: Calcular frete usando Esuema de Cenário
    Quando envio um request de consulta com cep origem "<CEP_ORIGEM>" e cep de destino "<CEP_DESTINO>"
    Entao o status code deve ser 200
    E o valor do frete deve ser igual a "<VALOR_FRETE>"

    Exemplos:
      | CEP_ORIGEM | CEP_DESTINO | VALOR_FRETE |
      | 13175613   | 74371520    | 24,80       |
      | 74371520   | 13175613    | 31,00       |

