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

//    static {
//        MAPPER.registerSubtypes(new NamedType(Truck.class, "Truck"));
//        MAPPER.registerSubtypes(new NamedType(Car.class, "Car"));
//    }

    @Test
    public void shouldSerializeVehicles() throws IOException {
        final Vehicles vehicles = new Vehicles(ImmutableList.of(new Car("Dodge"), new Truck("Scania")));
        final String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(vehicles);
        System.out.println(json);
        final Vehicles read = MAPPER.readValue(json, Vehicles.class);
        assertEquals(vehicles, read);
    }
}
