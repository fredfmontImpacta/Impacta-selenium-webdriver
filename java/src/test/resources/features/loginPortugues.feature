#language: pt

  Funcionalidade: Tela de Login

    Esquema do Cenário: Cenario: Usuario valido e senha valida

      Dado que o usuario esta na pagina de login
      E que o usuario informa o valor "<valorLogin>" no campo "login"
      E que o usuario informa o valor "<valorSenha>" no campo "password"
      Quando o usuario clicar no botao de login
      Entao o usuario devera logar e ver a mensagem de "Success Login!"

      Exemplos:
        | valorLogin | valorSenha |
        | robson     | agapito    |
        | robson     | agapito    |

    Esquema do Cenário: Cenario: Usuario valido e senha invalida

      Dado que o usuario esta na pagina de login
      E que o usuario informa o valor "<valorLogin>" no campo "login"
      E que o usuario informa o valor "<valorSenha>" no campo "password"
      Quando o usuario clicar no botao de login
      Entao o usuario nao devera logar e ver a mensagem de "Fail Login!"

      Exemplos:
        | valorLogin | valorSenha |
        | robson     | agapitu    |
        | robson     | agapiti    |
