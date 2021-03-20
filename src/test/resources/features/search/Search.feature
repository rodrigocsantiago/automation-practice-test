# language: pt

Funcionalidade: Search
  Usuário deve ser capaz de realizar pesquisa por produtos a partir da página inicial do sistema

  Contexto:
    Dado Usuário está na página inicial do sistema

  Esquema do Cenario: Cenario: Pesquisar produto informando palavra chave
    Quando Usuário pesquisa produto usando palavra chave '<palavra>'
    Entao O sistema exibe o resultado da pesquisa com <qtd_resultados> registros
    E O sistema exibe a palavra chave usada na pesquisa
    Exemplos:
      | palavra | qtd_resultados |
      | dress   | 7              |
      | t-shirt | 1              |

  Cenario: Tentar pesquisar produto informando palavra chave que não retorna resultados
    Quando Usuário pesquisa produto informando palavra chave que não retorna resultados
    Entao O sistema exibe o resultado da pesquisa vazio
    E O sistema exibe mensagem dizendo que nenhum resultado foi encontrado

  @wip
  Cenario: Tentar pesquisar produto sem informar palavra chave
    Quando Usuário pesquisa produto sem informar palavra chave
    Entao O sistema exibe o resultado da pesquisa vazio
    E O sistema exibe mensagem pedindo para informar palavra chave