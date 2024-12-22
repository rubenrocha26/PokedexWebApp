package pokedexwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import pokedexwebapp.pokemonApi.PokedexApi;
import pokedexwebapp.pokemonApi.PokedexApiService;


@Controller
public class PokedexController {
    
    @GetMapping("")
    public String home() {
        return "pokedexWebPage";
    }

    @PostMapping("/pokemonSearch")
    public String searchPokemon(HttpServletRequest request, Model model) {
        String pokemonName = request.getParameter("pokemonName");
        PokedexApiService pokedexApiService = new PokedexApiService();
        PokedexApi pokemonApi = new PokedexApi(pokemonName, pokedexApiService);
        model.addAttribute("name", pokemonApi.getName());
        model.addAttribute("dexNumber", pokemonApi.getDexNumber());
        model.addAttribute("primaryType", pokemonApi.getPrimaryType());
        model.addAttribute("imageUrl", pokemonApi.getImageUrl());
        return "pokedexWebPage";
    }

}
