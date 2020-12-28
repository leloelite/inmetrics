Feature: Realizar Login

 @funcional 
  Scenario: Realizar Login com sucesso
    Given o usuário está com o navegador aberto e na página de login
    When o usuário digita usuário e senha
    And clica no botão entre
    Then retorna para a tela de listagem de empresarios
