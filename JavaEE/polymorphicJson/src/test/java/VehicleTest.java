import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.google.common.collect.ImmutableList;
import org.Car;
import org.Truck;
import org.Vehicle;
import org.Vehicles;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VehicleTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void shouldSerializeVehicles() throws IOException {
        final Vehicle[] vehicles = {new Car("Dodge"), new Truck("Scania")};
        final String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(vehicles);
        System.out.println(json);
        final Vehicle[] read = MAPPER.readValue(json, Vehicle[].class);
        assertEquals(vehicles, read);
    }
}
