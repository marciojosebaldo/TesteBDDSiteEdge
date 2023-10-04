package steps;

import io.cucumber.java.pt.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class CalculadoraDias {

    private WebDriver driver;

    @Dado("que o usuário acessou a tela de cálculo de datas do site {string}")
    public void queOUsuárioAcessouATelaDeCálculoDeDatasDoSite(String site) {
        System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe"); // O driver foi deixado dentro da pasta driver e no diretório deste projeto
        driver = new EdgeDriver();
        driver.get(site);
        driver.manage().window().maximize();
    }

    @E("informou {string} dias no campo quantidade de dias")
    public void informouDiasNoCampoQuantidadeDeDias(String dias) {
        driver.findElement(By.name("quant")).sendKeys(dias);
    }

    @Quando("clicou no botão calcular")
    public void clicouNoBotãoCalcular() {
        driver.findElement((By.name("calcula"))).click();
    }

    @Então("o sistema calculará o data atual mais os dias adicionados")
    public void oSistemaCalcularáODataAtualMaisOsDiasAdicionados() {
        String resultado;
        resultado = driver.findElement(By.name("result1")).getAttribute("value");
        String esperado = "22/Novembro/2023  (Qua)";
        Assert.assertEquals(resultado, esperado);
    }
}