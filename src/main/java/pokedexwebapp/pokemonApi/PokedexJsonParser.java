package pokedexwebapp.pokemonApi;

import org.json.JSONObject;

public class PokedexJsonParser {
    
    private String _pokemonData;
    private String _name;
    private int _dexNumber;
    private String _primaryType;
    private String _secondaryType;
    private String _imageUrl;

    public PokedexJsonParser(){

    }

    public void getPokemonData(String jsonResponse) {
        JSONObject json = new JSONObject(jsonResponse);
        _name = json.getString("name").toLowerCase();
        _dexNumber = json.getInt("id");
        _primaryType = json.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");

        //Shows secondary type
        if (hasPokemonTwoTypes(jsonResponse)){
            _secondaryType = json.getJSONArray("types").getJSONObject(1).getJSONObject("type").getString("name");
        } else {
            _secondaryType = null;
        }

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

    public String getSecondaryType(){
        return _secondaryType;
    }

    public String getImageUrl(){
        return _imageUrl;
    }

    private boolean hasPokemonTwoTypes(String jsonResponse){
        JSONObject json = new JSONObject(jsonResponse);
        return json.getJSONArray("types").length() > 1;
    }
}
