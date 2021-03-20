package br.rsantiago.automation_practice.test.steps;

import br.rsantiago.automation_practice.test.framework.WebDriverFactory;
import br.rsantiago.automation_practice.test.pages.MyStore;
import br.rsantiago.automation_practice.test.pages.Search;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

public class SearchSteps {

    private WebDriver driver = null;
    private MyStore myStore;
    private Search searchMyStore;

    private String searchKeyword;

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Dado("Usuário está na página inicial do sistema")
    public void usuárioEstáNaPáginaInicialDoSistema() {
        myStore = new MyStore(driver);
    }

    @Quando("Usuário pesquisa produto usando palavra chave {string}")
    public void usuárioPesquisaProdutoUsandoPalavraChavePalavra(String keyword) {
        this.searchKeyword = keyword;
        searchMyStore = myStore.searchProduct(this.searchKeyword);
    }

    @Entao("O sistema exibe o resultado da pesquisa com {int} registros")
    public void oSistemaExibeOResultadoDaPesquisaComQtd_resultadosRegistros(Integer recordCount) {
        assertThat(searchMyStore.getNumberOfResults(), is(recordCount));
    }

    @Quando("Usuário pesquisa produto informando palavra chave que não retorna resultados")
    public void usuárioPesquisaProdutoInformandoPalavraChaveQueNãoRetornaResultados() {
        this.searchKeyword = "x";
        searchMyStore = myStore.searchProduct(this.searchKeyword);
    }

    @Entao("O sistema exibe o resultado da pesquisa vazio")
    public void oSistemaExibeOResultadoDaPesquisaVazio() {
        assertThat(searchMyStore.getNumberOfResults(), is(0));
    }

    @E("O sistema exibe mensagem dizendo que nenhum resultado foi encontrado")
    public void oSistemaExibeMensagemDizendoQueNenhumResultadoFoiEncontrado() {
        assertThat(searchMyStore.getNoResultsMessage(), containsString("No results were found for your search"));
    }

    @E("O sistema exibe a palavra chave usada na pesquisa")
    public void oSistemaExibeAPalavraChaveUsadaNaPesquisa() {
        assertThat(searchMyStore.getKeywordUsed(), equalToIgnoringCase(searchKeyword));
    }
}
