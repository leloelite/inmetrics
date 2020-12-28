package br.com.inmetrics.teste.glue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import br.com.inmetrics.teste.pageobjectscontrollers.CriarUsuario;
import br.com.inmetrics.teste.pageobjectscontrollers.Driver;
import br.com.inmetrics.teste.pageobjectscontrollers.EditarFuncionario;
import br.com.inmetrics.teste.pageobjectscontrollers.ListagemEmpregados;
import br.com.inmetrics.teste.pageobjectscontrollers.Login;
import br.com.inmetrics.teste.pageobjectscontrollers.NovoFuncionario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Steps {
	
    public static WebDriver webDriver;
    public static Login login;
    public static Driver driver;
    public static CriarUsuario criarUsuario;
    public static ListagemEmpregados listagemEmpregados;
    public static NovoFuncionario novoFuncionario;
    public static EditarFuncionario editarFuncionario;

    
    @Before("@funcional")
    public void instaciarJanela() 
    {
    	driver = new Driver();
        webDriver = driver.instaciarNovaJanela();
    }
    
    @Given("^o usuário está com o navegador aberto e na página de login$")
    public void o_usuario_esta_com_o_navegador_aberto_e_na_página_de_login() throws Throwable {
    	
    	login = driver.navegarAteURLLogin("http://www.inmrobo.tk/accounts/login/");
    }
    
    @When("^o usuário navega até a pagina de criar usuário$")
    public void o_usuario_navega_ate_a_pagina_de_criar_usuario() throws Throwable {
    	criarUsuario = login.clicarLinkCriarUsuario();
    }
    
    @When("^adiciona o usuário e a senha$")
    public void adiciona_o_usuario_e_a_senha() throws Throwable {
    	criarUsuario.inserirUsuario("aureliorib@gmail.com");
    	criarUsuario.inserirSenha("123456");
    	criarUsuario.inserirSenhaNovamente("123456");
    	login = criarUsuario.clicarBotaoCadastrar();
    }
    
    @Then("^retorna para a tela de login$")
    public void retorna_para_a_tela_de_login() throws Throwable {
    	String exp_URL = webDriver.getCurrentUrl();
    	String actual = "http://www.inmrobo.tk/accounts/login/";
        Assert.assertEquals(exp_URL, actual);
    }  
    
    @When("^adiciona o usuário e a senha já existentes$")
    public void adiciona_o_usuário_e_a_senha_já_existentes() throws Throwable {
    	criarUsuario.inserirUsuario("aureliorib@gmail.com");
    	criarUsuario.inserirSenha("123456");
    	criarUsuario.inserirSenhaNovamente("123456");
    	login = criarUsuario.clicarBotaoCadastrar();
    }
    
    @Then("^sistema retorna a mensagem de usuário já cadastrado$")
    public void sistema_retorna_a_mensagem_de_usuário_já_cadastrado() throws Throwable {
        String mensagem_obtida = criarUsuario.obterMensagemUsuarioJaCadastrado(); 
        String mensagem_esperada = "Usuário já cadastrado";
        Assert.assertEquals(mensagem_esperada, mensagem_obtida);
    }
    
    @When("^o usuário digita usuário e senha$")
    public void o_usuário_digita_usuário_e_senha() throws Throwable {
    	login.inserirUsuario("aureliorib@gmail.com");
    	login.inserirSenha("123456");
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^clica no botão entre$")
    public void clica_no_botão_entre() throws Throwable {
    	listagemEmpregados = login.clicarBotaoEntre();
        // Write code here that turns the phrase above into concrete actions
    }
    
    @Then("^retorna para a tela de listagem de empresarios$")
    public void retorna_para_a_tela_de_listagem_de_empresarios() throws Throwable {
    	String exp_URL = listagemEmpregados.ObterUrl();
    	String actual = "http://www.inmrobo.tk/empregados/";
        Assert.assertEquals(exp_URL, actual);
    }
    
    @Given("^Estar na tela de listagem de funcionários$")
    public void estar_na_tela_de_listagem_de_funcionários() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	String urlObtida = listagemEmpregados.ObterUrl();
    	String urlExperada = "http://www.inmrobo.tk/empregados/";
    	Assert.assertEquals(urlExperada, urlObtida);
    }

    @When("^clicar no link novo funcionario$")
    public void clicar_no_link_novo_funcionario() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	novoFuncionario = listagemEmpregados.clicarLinkNovoFuncionario();
    }

    @When("^preencher o formulário com \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e clicar em enviar$")
    public void preencher_o_formulário_de_clicar_em_enviar(String nome, String salario, String admissao, String cargo, String tipoContratacao, String sexo) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	novoFuncionario.preencherNome(nome);
    	novoFuncionario.preencherAdmissão(admissao);
    	novoFuncionario.prencherCargo(cargo);
    	novoFuncionario.preencherSalario(salario);
    	novoFuncionario.preencherTipoContratação(tipoContratacao);
    	novoFuncionario.preencherSexo(sexo);
    	novoFuncionario.preencherCpf();
    	listagemEmpregados = novoFuncionario.clicarBotaoEnviar();
    }

    @Then("^retorna para a tela de listagem de empresarios com a mensagem de sucesso$")
    public void retorna_para_a_tela_de_listagem_de_empresarios_com_a_mensagem_de_sucesso() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	listagemEmpregados.obterMensagemSucessoCadastro();
    }

	@When("^busco um funcionario pelo cpf$")
	public void busco_um_funcionario_pelo_cpf() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    listagemEmpregados.buscarPeloCpf();
	}
	
	@When("^localizo o funcionario e clico no botão editar$")
	public void localizo_o_funcionario_e_clico_no_botão_editar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    editarFuncionario = listagemEmpregados.clicarEmEditar();
	}
	
	@Then("^retorna para a tela de edição de funcionario com os dados já preenchidos$")
	public void retorna_para_a_tela_de_edição_de_funcionario_com_os_dados_já_preenchidos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    editarFuncionario.verificarCpfPreenchido();
	}
	
	@Then("^edito os dados do funcionario$")
	public void edito_os_dados_do_funcionario() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    editarFuncionario.preencherNome("Nome Alterado");
	}
	
	@Then("^clico no botão enviar$")
	public void clico_no_botão_enviar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    listagemEmpregados = editarFuncionario.clicarBotaoEnviar();
	}
	
	@Then("^retorna para a tela de listagem de empresarios com a mensagem de edição feita com sucesso$")
	public void retorna_para_a_tela_de_listagem_de_empresarios_com_a_mensagem_de_edição_feita_com_sucesso() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    listagemEmpregados.verificaMensagemEdicaoSucesso();
	}
	
	@When("^localizo o funcionario e clico no botão excluir$")
	public void localizo_o_funcionario_e_clico_no_botão_excluir() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    listagemEmpregados.clicarBotaoExcluir();
	}

	@Then("^exibe a mensagem de remoção feita com sucesso$")
	public void exibe_a_mensagem_de_remoção_feita_com_sucesso() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    listagemEmpregados.verificaMensagemRemocaoSucesso();
	}
	
    @After("@funcional")
    public static void fecharJanela(){
    	if(driver!=null) {
    		driver.fecharJanela();
    	}
    }
}