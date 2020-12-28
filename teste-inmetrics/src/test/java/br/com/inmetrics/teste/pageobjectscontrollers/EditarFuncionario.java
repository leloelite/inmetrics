package br.com.inmetrics.teste.pageobjectscontrollers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.inmetrics.teste.pageobjects.PaginaEditarFuncionario;



public class EditarFuncionario {
	
	private WebDriver _driver;

	public EditarFuncionario(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this._driver = driver;
	}

	public void verificarCpfPreenchido() {
		// TODO Auto-generated method stub
		String cpfObtido = _driver.findElement(By.id(PaginaEditarFuncionario.INPUT_CPF_ID)).getAttribute("value");
		String cpfEsperado = NovoFuncionario.cpf;
		Assert.assertEquals(cpfEsperado, cpfObtido);
	}

	public void preencherNome(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.id(PaginaEditarFuncionario.INPUT_NOME_ID)).sendKeys(string);
	}

	public ListagemEmpregados clicarBotaoEnviar() {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaEditarFuncionario.BOTAO_ENVIAR_XPATH)).click();
		return new ListagemEmpregados(_driver);
	}

}
