package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class AcessandoSite {
    private WebDriver driver;

    @Dado("que o usuário está na tela de login do site {string}")
    public void queOUsuárioEstáNaTelaDeLoginDoSite(String site) {
        System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe"); // O driver foi deixado dentro da pasta driver e no diretório deste projeto
        driver = new EdgeDriver();
        driver.get(site);
        driver.manage().window().maximize();
    }

    @E("informa o usuário {string}")
    public void informaOUsuário(String usuario) {
        driver.findElement(By.id("username")).sendKeys(usuario);
    }

    @E("informa a senha {string}")
    public void informaASenha(String senha) {
        driver.findElement(By.id("password")).sendKeys(senha);
    }
    @Quando("o usuário clica no botão login")
    public void oUsuárioClicaNoBotãoLogin() {
        WebElement botaoLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        botaoLogin.click();
    }

    @Então("é exibido mensagem de sucesso!")
    public void éExibidoMensagemDeSucesso() {
        WebElement mensagemSucesso = driver.findElement(By.cssSelector(".flash.success"));
        boolean exibicaoMensagemSucesso = mensagemSucesso.isDisplayed();
        Assert.assertTrue(exibicaoMensagemSucesso, "A mensagem de sucesso está sendo exibida.");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
}