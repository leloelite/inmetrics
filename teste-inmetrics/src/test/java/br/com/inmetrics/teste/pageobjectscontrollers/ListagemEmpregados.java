package br.com.inmetrics.teste.pageobjectscontrollers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.inmetrics.teste.pageobjects.PaginaListagemEmpregados;

public class ListagemEmpregados extends Driver{
	
	private WebDriver _driver;

	public ListagemEmpregados(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this._driver = driver;
	}

	public NovoFuncionario clicarLinkNovoFuncionario() {
		// TODO Auto-generated method stub
		_driver.manage().window().maximize();
		_driver.findElement(By.xpath(PaginaListagemEmpregados.LINK_NOVO_FUNCIONARIO_XPATH)).click();
		return new NovoFuncionario(_driver);
	}
	
	public String ObterUrl() {
		return _driver.getCurrentUrl();
	}

	public void obterMensagemSucessoCadastro() {
		// TODO Auto-generated method stub
		String mensagemObtida =_driver.findElement(By.xpath(PaginaListagemEmpregados.LABEL_SUCESSO_CADASTRO_XPATH)).getText();
		String mensagemEsperada = "SUCESSO! Usuário cadastrado com sucesso";
		mensagemObtida.equals(mensagemEsperada);
	}

	public EditarFuncionario clicarEmEditar() {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaListagemEmpregados.BOTAO_EDITAR_XPATH)).click();
		return new EditarFuncionario(_driver);
	}

	public void buscarPeloCpf() {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaListagemEmpregados.CAMPO_BUSCA_XPATH)).sendKeys(NovoFuncionario.cpf);
	}

	public void verificaMensagemEdicaoSucesso() {
		// TODO Auto-generated method stub
		String mensagemObtida =_driver.findElement(By.xpath(PaginaListagemEmpregados.MENSAGEM_EDICAO_SUCESSO_XPATH)).getText();
		String mensagemEsperada = "SUCESSO! Informações atualizadas com sucesso";
		mensagemObtida.equals(mensagemEsperada);
	}

	public void clicarBotaoExcluir() {
		// TODO Auto-generated method stub
		_driver.findElement(By.xpath(PaginaListagemEmpregados.BOTAO_EXCLUIR_XPATH)).click();
	}

	public void verificaMensagemRemocaoSucesso() {
		// TODO Auto-generated method stub
		String mensagemObtida =_driver.findElement(By.xpath(PaginaListagemEmpregados.MENSAGEM_REMOCAO_SUCESSO_XPATH)).getText();
		String mensagemEsperada = "SUCESSO! Funcionário removido com sucesso";
		mensagemObtida.equals(mensagemEsperada);
	}

}
