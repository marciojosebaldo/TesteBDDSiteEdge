package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
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

    @Entao("o sistema calculará o data atual e mais {int} dias")
    public void oSistemaCalcularáODataAtualEMaisDias() {
        String resultado;
        resultado = driver.findElement(By.name("result1")).getText();
        Assert.assertEquals(resultado, "22/Novembro/2023  (Qua)");
    }
}