package pokedexwebapp.pokemonApi;

public class PokedexApi {

    private String _url;
    

    public PokedexApi(String pokemonName) {
        this._url = "https://pokeapi.co/api/v2/pokemon/{pokemonName}";
        this._url = this._url.replace("{pokemonName}", pokemonName.toLowerCase());
    }

    public String getUrl() {
        return _url;
    }
}