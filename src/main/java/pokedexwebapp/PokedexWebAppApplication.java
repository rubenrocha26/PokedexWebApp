package pokedexwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class PokedexWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokedexWebAppApplication.class, args);
        openHomePage();
    }

    private static void openHomePage() {
        if (Desktop.isDesktopSupported() && !GraphicsEnvironment.isHeadless()) {
            try {
                Desktop.getDesktop().browse(new URI("http://localhost:8080"));
                System.out.println("Página inicial aberta no navegador padrão.");
            } catch (Exception e) {
                System.err.println("Erro ao tentar abrir a página inicial: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Ambiente sem suporte gráfico. Abra manualmente a URL: http://localhost:8080");
        }
    }
}
