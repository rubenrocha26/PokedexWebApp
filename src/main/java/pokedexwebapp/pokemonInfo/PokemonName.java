package pokedexwebapp.pokemonInfo;

import org.json.JSONObject;

public class PokemonName {
    private String _name;

    public PokemonName(String jsonResponse){
        getPokemonName(jsonResponse);
    }


    private void getPokemonName(String jsonResponse){
        JSONObject json = new JSONObject(jsonResponse);
        _name = json.getString("name").toLowerCase();
    }

    public String getName(){
        return _name;
    }
}
