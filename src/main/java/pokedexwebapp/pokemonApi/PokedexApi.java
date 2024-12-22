package pokedexwebapp.pokemonApi;

import org.json.JSONObject;

public class PokedexApi {

    private String url;
    private String _name;
    private int _dexNumber;
    private String _primaryType;
    private String _imageUrl;
    

    public PokedexApi(String pokemonName, PokedexApiService pokedexApiService) {
        this.url = "https://pokeapi.co/api/v2/pokemon/{pokemonName}";
        this.url = this.url.replace("{pokemonName}", pokemonName.toLowerCase());
        String pokemondApiData = pokedexApiService.getPokemonApiData(this.url);
        getPokemonData(pokemondApiData);
    }

    private void getPokemonData(String jsonResponse) {
        JSONObject json = new JSONObject(jsonResponse);
        _name = json.getString("name").toLowerCase();
        _dexNumber = json.getInt("id");
        _primaryType = json.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");
        _imageUrl = json.getJSONObject("sprites").getString("front_default");
    }

    public String getName() {
        return _name;
    }

    public int getDexNumber() {
        return _dexNumber;
    }

    public String getPrimaryType(){
        return _primaryType;
    }

    public String getImageUrl(){
        return _imageUrl;
    }
}