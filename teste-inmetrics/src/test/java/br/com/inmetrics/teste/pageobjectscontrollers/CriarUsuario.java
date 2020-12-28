package br.com.inmetrics.teste.pageobjectscontrollers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.inmetrics.teste.pageobjects.PaginaCriarUsuario;

public class CriarUsuario {
	
	private WebDriver _driver;

	public CriarUsuario(WebDriver driver) {
			this._driver = driver;
	}

	public void inserirUsuario(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaCriarUsuario.INPUT_USUARIO_XPATH)).sendKeys(string);
	}

	public void inserirSenha(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaCriarUsuario.INPUT_SENHA_XPATH)).sendKeys(string);
	}

	public Login clicarBotaoCadastrar() {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaCriarUsuario.BOTAO_CADASTRAR_XPATH)).click();
		return new Login(_driver);
	}

	public void inserirSenhaNovamente(String string) {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaCriarUsuario.INPUT_SENHA_NOVAMENTE_XPATH)).sendKeys(string);
	}

	public String obterMensagemUsuarioJaCadastrado() {
		return _driver.findElement(By.xpath(PaginaCriarUsuario.LABEL_MENSAGEM_SUCESSO_XPATH)).getText();
	}

}
