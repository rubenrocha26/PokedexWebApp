package pokedexwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class PokedexController {
    @GetMapping("/search")

    public String searchPokemon(@RequestParam("pokemonName") String pokemonName, Model model) {
        PokedexApi pokemonApi = new PokedexApi(pokemonName);
        Map<String, String> pokemonData = pokemonApi.getPokemonInfo();
        model.addAttribute("pokemonData", pokemonData);
        return "PokedexWebPage";
    }
}
