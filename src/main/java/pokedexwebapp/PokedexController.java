package pokedexwebapp;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PokedexController {
    
    @GetMapping("")
    public String home(/*@RequestParam("pokemonName") String pokemonName, Model model*/) {
        /*PokedexApi pokemonApi = new PokedexApi(pokemonName);
        Map<String, String> pokemonData = pokemonApi.getPokemonInfo();
        model.addAttribute("pokemonData", pokemonData);*/
        return "pokedexWebPage";
    }

}
