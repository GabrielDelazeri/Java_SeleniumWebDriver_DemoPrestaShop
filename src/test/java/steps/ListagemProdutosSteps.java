package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class ListagemProdutosSteps {

    private WebDriver driver;

    @Before
    public void inicializar() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Dado("que estou na página inicial")
    public void queEstouNaPáginaInicial() {
        driver.get("https://marcelodebittencourt.com/demoprestashop/");
        assertThat(driver.getTitle()).isEqualTo("Loja de Teste");
    }

    @Quando("não estou logado")
    public void não_estou_logado() {
        String elementoSignin = driver.findElement(By.cssSelector("#_desktop_user_info > div > a > span")).getText();
        assertThat(elementoSignin).isEqualTo("Sign in");

    }

    @Então("visualizo o produto de nome {string} na posição {string}")
    public void visualizoOProdutoDeNomeNaPosição(String arg0, String arg1) {
        String nomeDoProduto = driver.findElement(By.cssSelector("#content > section > div > article:nth-child(1) > div > div.product-description > h3 > a")).getText();
        assertThat(nomeDoProduto.toLowerCase(Locale.ROOT)).isEqualTo("hummingbird printed t-shirt");
    }

    @After
    public void finalizar() {
        driver.quit();
    }
}
