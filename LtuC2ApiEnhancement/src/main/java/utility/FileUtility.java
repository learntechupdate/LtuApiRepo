package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileUtility {


    public static JsonObject readYamlFile(String yamlFilePath) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(yamlFilePath);
        Yaml yaml = new Yaml();
        Object data = yaml.load(inputStream);
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        JsonObject jsonObject = gson.toJsonTree(data).getAsJsonObject();
        return jsonObject;
    }
}
