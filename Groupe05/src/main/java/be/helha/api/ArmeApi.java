package be.helha.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArmeApi {

    public static String getArmes(){
        String responseString = "";
        try {
            // Créer l'URL de la requête
            URL url = new URL("http://localhost:8080/api/arme");

            // Ouvrir une connexion HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Spécifier la méthode de requête (GET dans cet exemple)
            connection.setRequestMethod("GET");

            // Lire la réponse
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Convertir la réponse en chaîne
            responseString = response.toString();

            // Fermer la connexion
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseString;
    }
        public static String getArmeById(int id) {
        String responseString = "";
        try {
            // Créer l'URL de la requête avec l'identifiant de l'arme
            URL url = new URL("http://localhost:8080/api/arme/" + id);

            // Ouvrir une connexion HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Spécifier la méthode de requête (GET dans cet exemple)
            connection.setRequestMethod("GET");

            // Lire la réponse
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Convertir la réponse en chaîne
            responseString = response.toString();

            // Fermer la connexion
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseString;
    }

}
