## Teste Inmetrics - Descrever como executar o projeto

Para Iniciar o projeto basta importar o mesmo através do Eclipse

Em seguida, recomendo que execute os comando "Maven clean"

Para que o projeto execute com sucesso, é necessário dizer onde se encontar o driver do navegador, nesse caso, utilizamos o Google Chrome. Devemos realizar o download do chrome driver na página https://chromedriver.chromium.org/downloads para saber qual versão baixar, basta verificar a versão do Chrome instalada no seu micro:

Abra o navegador, vá em "Ajuda", em seguina na opção "Sobre o Google Chrome", em seguida, será exibida uma janela com a versão do chrome, que é a versão que deve ser baixada do Chrome Driver.

Em seguida, devemos extrair o arquivo. 

No eclipse abriremos a classe "Driver.java" que está dentro do pacote "br.com.inmetrics.teste.pageobjectscontrollers", dentro do arquivo na linha 16, encontraremos:

System.setProperty("webdriver.chrome.driver","C:\\Users\\joseribeiro\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");

O segundo parametro deve ser substituido pelo path do Chrome Driver(O mesmo também pode ser incluido dentro do projeto, mas fica suscetível a incompatibilidade de versões).

Após a configuraçao acima ser concluída, devemos clicar com o botão direito do mouse no projeto e em seguida clicar nas opções "Run As > Run Configurations...".

Selecionar a opção "Cucumber Feature" com o botão direito do mouse, sem seguida selecionar "New Configuration", em seeguida, na opção "Feature Path", inserir o caminho das Features do Cucumber(src\test\java\br\com\inmetrics\teste\features).

Em seguida, clicar em "Run". Logo em seguida os testes devem ser iniciados.
