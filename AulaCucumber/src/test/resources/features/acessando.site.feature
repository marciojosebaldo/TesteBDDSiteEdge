#language: pt
  Funcionalidade: Fazer login no site "https://the-internet.herokuapp.com/login"
    Cenario: Fazer login com sucesso no site "https://the-internet.herokuapp.com/login"
      Dado que o usuário está na tela de login do site "https://the-internet.herokuapp.com/login"
      E informa o usuário "tomsmith"
      E informa a senha "SuperSecretPassword!"
      Quando o usuário clica no botão login
      Então é exibido mensagem de sucesso!


      Cenario: Cálculo de adição de dias em uma data atual
        Dado que o usuário acessou a tela de cálculo de datas do site "http://webcalc.com.br/DataHora/form/operacoes"
        E informou "50" dias no campo quantidade de dias
        Quando clicou no botão calcular
        Entao o sistema calculará o data atual e mais 50 dias