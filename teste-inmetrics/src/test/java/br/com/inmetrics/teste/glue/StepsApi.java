package br.com.inmetrics.teste.glue;

import static io.restassured.RestAssured.given;

import br.com.inmetrics.teste.pageobjectscontrollers.GeraCpfCnpj;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepsApi {
	
    public static RequestSpecification requestSpecification;
    public static Response response;
	
	@Given("^estou com um usuário autorizado na api$")
	public void estou_com_um_usuário_autorizado_na_api() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String url = "https://inm-api-test.herokuapp.com/empregado/cadastrar";
		try {
			requestSpecification = given().given().auth()
					  .basic("inmetrics", "automacao").contentType("application/json");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@When("^envio um json para cadastro de um usuário$")
	public void envio_um_json_para_cadastro_de_um_usuário() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String url = "https://inm-api-test.herokuapp.com/empregado/cadastrar";
		GeraCpfCnpj geraCpfCnpj = new GeraCpfCnpj();
		String cpf = geraCpfCnpj.cpf(true);
		String body = "{ \"admissao\": \"31/12/2020\", \"cargo\": \"Analista de qa\", \"comissao\": \"1.000,00\", \"cpf\": \""+cpf+"\", \"departamentoId\": 1, \"nome\": \"Jose Ribeiro\", \"salario\": \"6.000,00\", \"sexo\": \"m\", \"tipoContratacao\": \"clt\"}";
		requestSpecification.body(body);
		response = requestSpecification.when().post(url);
	}

	@Then("^retorna o código (\\d+)$")
	public void retorna_o_código(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		response.then().statusCode(arg1);
	}
	
	@When("^envio um id para consulta do usuário$")
	public void envio_um_id_para_consulta_do_usuário() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String url = "https://inm-api-test.herokuapp.com/empregado/list/7381";
		response = requestSpecification.when().get(url);
	}
	
	@When("^envio uma requisição para retornar todos os usuários$")
	public void envio_uma_requisição_para_retornar_todos_os_usuários() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String url = "https://inm-api-test.herokuapp.com/empregado/list_all";
	    response = requestSpecification.when().get(url);
	}
	
	@When("^envio um json para alterar um usuário$")
	public void envio_um_json_para_alterar_um_usuário() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String url = "https://inm-api-test.herokuapp.com/empregado/alterar/7381";
		GeraCpfCnpj geraCpfCnpj = new GeraCpfCnpj();
		String cpf = geraCpfCnpj.cpf(true);
		String body = "{ \"admissao\": \"31/12/2020\", \"cargo\": \"Analista de qa\", \"comissao\": \"1.000,00\", \"cpf\": \""+cpf+"\", \"departamentoId\": 1, \"nome\": \"Jose Ribeiro Alterado via API\", \"salario\": \"6.000,00\", \"sexo\": \"m\", \"tipoContratacao\": \"clt\"}";
		requestSpecification.body(body);
		response = requestSpecification.when().put(url);
	}

}
