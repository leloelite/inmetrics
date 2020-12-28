
Feature: Criar usuários
  Cria usuários no sistema

 @funcional 
  Scenario: Criar um usuário
    Given o usuário está com o navegador aberto e na página de login
    When o usuário navega até a pagina de criar usuário
    And adiciona o usuário e a senha
    Then retorna para a tela de login
    
 @funcional 
  Scenario: Criar um usuário já existente
    Given o usuário está com o navegador aberto e na página de login
    When o usuário navega até a pagina de criar usuário
    And adiciona o usuário e a senha já existentes
    Then sistema retorna a mensagem de usuário já cadastrado