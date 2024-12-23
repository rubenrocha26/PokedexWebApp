package pokedexwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import pokedexwebapp.pokemonApi.PokedexApi;
import pokedexwebapp.pokemonApi.PokedexApiService;
import pokedexwebapp.pokemonInfo.PokemonName;


@Controller
public class PokedexController {
    
    @GetMapping("")
    public String home() {
        return "pokedexWebPage";
    }

    @PostMapping("/pokemonSearch")
    public String searchPokemon(HttpServletRequest request, Model model) {
        //Get pokemonName from WebSite
        String pokemonName = request.getParameter("pokemonName");

        //Prevents null or empty name
        if (isPokemonNameNullOrEmpty(request)) {
            model.addAttribute("error", "Pokemon name cannot be empty.");
            return "pokedexWebPage";
        }

        PokedexApiService pokedexApiService = new PokedexApiService();
        PokedexApi pokemonApi = new PokedexApi(pokemonName, pokedexApiService);
        model.addAttribute("name", pokemonApi.getName());
        model.addAttribute("dexNumber", pokemonApi.getDexNumber());
        model.addAttribute("primaryType", pokemonApi.getPrimaryType());

        if (pokemonApi.getSecondaryType() != null && !pokemonApi.getSecondaryType().isEmpty()) {
            model.addAttribute("secondaryType", pokemonApi.getSecondaryType());
        }

        model.addAttribute("imageUrl", pokemonApi.getImageUrl());
        return "pokedexWebPage";
    }

    private boolean isPokemonNameNullOrEmpty(HttpServletRequest request){
        String pokemonName = request.getParameter("pokemonName");
        return pokemonName == null || pokemonName.trim().isEmpty();
    }

}
