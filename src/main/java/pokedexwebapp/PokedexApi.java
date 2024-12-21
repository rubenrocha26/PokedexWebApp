package pokedexwebapp;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PokedexApi {

    private String url;

    public PokedexApi(String pokemonName) {
        this.url = "https://pokeapi.co/api/v2/pokemon/{pokemonName}";
        this.url = this.url.replace("{pokemonName}", pokemonName.toLowerCase());
    }

    public Map<String, String> getPokemonInfo() {
        Map<String, String> pokemonData = new HashMap<>();
        try {
            URL urlObj = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            // Parse JSON response
            JSONObject json = new JSONObject(content.toString());
            String name = json.getString("name");
            int dexNumber = json.getInt("id");
            String primaryType = json.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");
            String imageUrl = json.getJSONObject("sprites").getString("front_default");

            // Capitalize the first letter of the name
            name = name.substring(0, 1).toUpperCase() + name.substring(1);

            // Add data to the map
            pokemonData.put("name", name);
            pokemonData.put("dexNumber", String.valueOf(dexNumber));
            pokemonData.put("primaryType", primaryType);
            pokemonData.put("imageUrl", imageUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pokemonData;
    }
}