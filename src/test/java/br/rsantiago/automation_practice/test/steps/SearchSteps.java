package br.rsantiago.automation_practice.test.steps;

import io.cucumber.java8.Pt;
import org.openqa.selenium.WebDriver;

import java.awt.desktop.SystemEventListener;

public class SearchSteps implements Pt {

    private WebDriver driver;

    public SearchSteps() {

        Dado("^Usuário está na página inicial do sistema$", () -> {
            System.out.println("ok");
        });

        Quando("Usuário pesquisa produto usando palavra chave {string}", (String keyword) -> {
            System.out.println("Pesquisa usando keyword " + keyword);
        });
        Quando("^Usuário pesquisa produto informando palavra chave que não retorna resultados$", () -> {
            System.out.println("ok");
        });
        Quando("^Usuário pesquisa produto sem informar palavra chave$", () -> {
            System.out.println("ok");
        });

        Entao("O sistema exibe o resultado da pesquisa com {int} registros", (Integer records) -> {
            System.out.println("Resultado da pesquisa com " + records + " registros");
        });
        Entao("^O sistema exibe o resultado da pesquisa vazio$", () -> {
            System.out.println("ok");
        });


        E("^O sistema exibe mensagem dizendo que nenhum resultado foi encontrado$", () -> {
            System.out.println("ok");
        });
        E("^O sistema exibe mensagem pedindo para informar palavra chave$", () -> {
            System.out.println("ok");
        });
    }
}
