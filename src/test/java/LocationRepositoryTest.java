import PersistSchema.Location;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationRepositoryTest {

    @Test
    void addLocation() {

    }

    @Test
    void getLocation() {
        Location actual = LocationRepository.getLocation(2);


        Location expected = new Location();


        expected.setId(2);
        expected.setName("Seaseme st");
        expected.setSqft(3000);
        expected.setName("Delivery Center");


        actual.getAddress();


        assertEquals(actual.getName(),expected.getName());
        assertEquals(actual.getSqft(),expected.getSqft());
    }

    @Test
    void getLocations() {
        List<Location> locations = LocationRepository.getLocations();
        locations.stream().forEach(l ->l.showInfo());

        assertNotNull(locations);
    }

    @Test
    void updateLocation() {

        String oldName = LocationRepository.getLocation(5).getName();
        LocationRepository.updateLocationName(5,"Oscars hideout");

        String expected = LocationRepository.getLocation(5).getName();

        assertNotEquals(expected,oldName);
        assertEquals(expected,"Oscars hideout");


//         Change Back
        LocationRepository.updateLocationName(5,oldName);


    }

    @Test
    void deleteLocation() {
    }


}