
package be.helha.domaine;

import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Gestionnaire de configuration pour lire le fichier config.json.
 */
public class ConfigManager {
    private static ConfigManager instance;
    private JSONObject config;

    private ConfigManager() {
        try (InputStream input = getClass().getResourceAsStream("/config.json")) {
            String jsonText = new String(input.readAllBytes(), StandardCharsets.UTF_8);
            config = new JSONObject(jsonText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtient l'instance du gestionnaire de configuration.
     * @return l'instance du gestionnaire de configuration
     */
    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    /**
     * Obtient l'URL de la base de données à partir du fichier de configuration.
     * @return l'URL de la base de données
     */
    public String getDatabaseUrl() {
        return config.getString("databaseUrl");
    }
}
