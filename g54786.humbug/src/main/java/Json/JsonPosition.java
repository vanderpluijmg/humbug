package Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import g54786.humbug.model.Position;
import java.io.IOException;

/**
 *Json position test class.
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class JsonPosition {
    public static void main(String[] args) throws IOException {
    var objectMapper = new ObjectMapper();
    var in = JsonPosition.class.getResourceAsStream("/data/position.json");
    Position position = objectMapper.readValue(in, Position.class);
    System.out.println("Position read: " + position);
    }
}
