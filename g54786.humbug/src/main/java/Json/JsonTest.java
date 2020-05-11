package Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 * Json test class.
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class JsonTest {
    public static void main(String[] args) throws IOException {
    var objectMapper = new ObjectMapper();
    var file = new File("src/main/resources/data/test.json");
    var jsonNode = objectMapper.readTree(file);
    System.out.println(jsonNode);
    System.out.println("Value: " + jsonNode.get("key").asText());
    }
}
