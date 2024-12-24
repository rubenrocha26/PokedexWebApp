package pokedexwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import pokedexwebapp.pokemonApi.PokedexApi;
import pokedexwebapp.pokemonApi.PokedexJsonParser;


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

        PokedexApi pokedexApi = new PokedexApi(pokemonName);
        PokedexJsonParser pokedexJsonParser = new PokedexJsonParser(pokedexApi);
        model.addAttribute("name", pokedexJsonParser.getName());
        model.addAttribute("dexNumber", pokedexJsonParser.getDexNumber());
        model.addAttribute("primaryType", pokedexJsonParser.getPrimaryType());

        if (pokedexJsonParser.getSecondaryType() != null && !pokedexJsonParser.getSecondaryType().isEmpty()) {
            model.addAttribute("secondaryType", pokedexJsonParser.getSecondaryType());
        }

        model.addAttribute("imageUrl", pokedexJsonParser.getImageUrl());
        return "pokedexWebPage";
    }

    private boolean isPokemonNameNullOrEmpty(HttpServletRequest request){
        String pokemonName = request.getParameter("pokemonName");
        return pokemonName == null || pokemonName.trim().isEmpty();
    }

}
