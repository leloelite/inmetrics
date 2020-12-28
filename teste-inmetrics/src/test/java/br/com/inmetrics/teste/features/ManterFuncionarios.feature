Feature: Criar Funcionario
Cria usuários no sistema

Background: 
  Given o usuário está com o navegador aberto e na página de login
   When o usuário digita usuário e senha
    And clica no botão entre
    And retorna para a tela de listagem de empresarios

@funcional 
Scenario Outline: Criar um funcionario
  Given Estar na tela de listagem de funcionários
   When clicar no link novo funcionario 
    And preencher o formulário com "<nome>","<salario>", "<admissão>", "<cargo>", "<tipoContratação>", "<sexo>" e clicar em enviar
   Then retorna para a tela de listagem de empresarios com a mensagem de sucesso

  Examples: 
    | nome | salario | admissão   | cargo          | tipoContratação | sexo | 
    | joão | 600000  | 12/12/2020 | Analista de QA | clt             | m    | 
    | jose | 700000  | 12/12/2020 | Analista de QA | pj              | m    | 
    | vera | 800000  | 12/12/2020 | Analista de QA | clt             | f    | 

@funcional   
Scenario: Editar Funcionario
  Given Estar na tela de listagem de funcionários
   When busco um funcionario pelo cpf
    And localizo o funcionario e clico no botão editar
   Then retorna para a tela de edição de funcionario com os dados já preenchidos
    And edito os dados do funcionario
    And clico no botão enviar
   Then retorna para a tela de listagem de empresarios com a mensagem de edição feita com sucesso

@funcional  
Scenario: Excluir funcionario
  Given Estar na tela de listagem de funcionários
   When busco um funcionario pelo cpf
    And localizo o funcionario e clico no botão excluir
   Then exibe a mensagem de remoção feita com sucesso



