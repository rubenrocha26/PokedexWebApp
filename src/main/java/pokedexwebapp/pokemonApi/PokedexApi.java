package pokedexwebapp.pokemonApi;

import org.json.JSONObject;

public class PokedexApi {

    private String url;
    

    public PokedexApi(String pokemonName, PokedexApiService pokedexApiService, PokedexJsonParser pokedexJsonParser) {
        this.url = "https://pokeapi.co/api/v2/pokemon/{pokemonName}";
        this.url = this.url.replace("{pokemonName}", pokemonName.toLowerCase());
        String pokemondApiData = pokedexApiService.getPokemonApiData(this.url);
        pokedexJsonParser.getPokemonData(pokemondApiData);
    }
}