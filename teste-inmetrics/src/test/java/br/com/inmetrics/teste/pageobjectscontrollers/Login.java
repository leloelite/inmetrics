package br.com.inmetrics.teste.pageobjectscontrollers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.inmetrics.teste.pageobjects.PaginaLogin;

public class Login {
	
	private WebDriver _driver;

	public Login(
			WebDriver driver)
        {
			_driver = driver;
        }

	public CriarUsuario clicarLinkCriarUsuario() {
		_driver.findElement(By.xpath(PaginaLogin.LINK_CRIAR_USUARIO_XPATH)).click();
		return new CriarUsuario(_driver);
	}

	public ListagemEmpregados clicarBotaoEntre() {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaLogin.BOTAO_ENTRE_XPATH)).click();
		return new ListagemEmpregados(_driver);
	}

	public void inserirUsuario(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaLogin.INPUT_USUARIO_XPATH)).sendKeys(string);
	}

	public void inserirSenha(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaLogin.INPUT_SENHA_XPATH)).sendKeys(string);
	}


	
	

}
