package br.com.inmetrics.teste.pageobjectscontrollers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import br.com.inmetrics.teste.pageobjects.PaginaNovoFuncionario;

public class NovoFuncionario {
	
	private WebDriver _driver;
	public static String cpf;
	
	public NovoFuncionario(WebDriver _driver2) {
		// TODO Auto-generated constructor stub
		this._driver = _driver2;
	}

	public void preencherNome(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.id(PaginaNovoFuncionario.INPUT_NOME_ID)).sendKeys(string);		
	}

	public void preencherCpf() {
		// TODO Auto-generated method stub
		GeraCpfCnpj gerarCpfCnpj = new GeraCpfCnpj();
		cpf = gerarCpfCnpj.cpf(true);
		_driver.findElement(By.id(PaginaNovoFuncionario.INPUT_CPF_ID)).sendKeys(cpf);
	}

	public void preencherSexo(String string) throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement list = _driver.findElement(By.id(PaginaNovoFuncionario.COMBO_SELECAO_SEXO_ID));
		Select select = new Select(list);
		
		if(string.equals("m")) {
			select.selectByIndex(3);
		}
		if(string.equals("f")) {
			select.selectByIndex(2);
		}
		if(string.equals("i")) {
			select.selectByIndex(1);
		}
	}

	public void preencherAdmissão(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.id(PaginaNovoFuncionario.INPUT_DATA_ADMISSAO_ID)).sendKeys(string);
	}

	public void prencherCargo(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.id(PaginaNovoFuncionario.INPUT_CARGO_ID)).sendKeys(string);
	}

	public void preencherSalario(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.id(PaginaNovoFuncionario.INPUT_SALARIO_ID)).sendKeys(string);
	}

	public void preencherTipoContratação(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.id(PaginaNovoFuncionario.RADIO_CLT_ID)).click();
		if (string.equals("clt")) {
			_driver.findElement(By.id(PaginaNovoFuncionario.RADIO_CLT_ID)).click();
		}
		if (string.equals("pj")) {
			_driver.findElement(By.id(PaginaNovoFuncionario.RADIO_PJ_ID)).click();
		}
	}

	public ListagemEmpregados clicarBotaoEnviar() {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaNovoFuncionario.BOTA0_ENVIAR_XPATH)).click();
		return new ListagemEmpregados(_driver);
	}

}
