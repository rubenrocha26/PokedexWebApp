package pokedexwebapp.pokemonApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PokedexApiService {
    
    public String getPokemonApiData(String url) {
        try {
            @SuppressWarnings("deprecation")
            URL urlObj = new URL(url);
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
            return content.toString();

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch data from API", e);
        }
    }   
}