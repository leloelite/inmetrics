Feature: Testar metodos de empregados da API
    
	Scenario: Adicionar um empregado. 
		Given estou com um usuário autorizado na api
		When envio um json para cadastro de um usuário
		Then retorna o código 202  
		
	Scenario: Listar empregado cadastrado. 
		Given estou com um usuário autorizado na api
		When envio um id para consulta do usuário
		Then retorna o código 202
		
	Scenario: Listar todos os empregados cadastrados. 
		Given estou com um usuário autorizado na api
		When envio uma requisição para retornar todos os usuários
		Then retorna o código 200
		
	Scenario: Alterar um empregado
		Given estou com um usuário autorizado na api
		When envio um json para alterar um usuário
		Then retorna o código 202
		
