import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.PassengerPlane;
import planes.Plane;
import planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane(new Plane("Boeing-737", 900, 12000, 60500),
                    164),
            new PassengerPlane(new Plane("Boeing-737-800", 940, 12300, 63870),
                    192),
            new PassengerPlane(new Plane("Boeing-747", 980, 16100, 70500),
                    242),
            new PassengerPlane(new Plane("Airbus A320", 930, 11800, 65500),
                    188),
            new PassengerPlane(new Plane("Airbus A330", 990, 14800, 80500),
                    222),
            new PassengerPlane(new Plane("Embraer 190", 870, 8100, 30800),
                    64),
            new PassengerPlane(new Plane("Sukhoi Superjet 100", 870, 11500, 50500),
                    140),
            new PassengerPlane(new Plane("Bombardier CS300", 920, 11000, 60700),
                    196),
            new MilitaryPlane(new Plane("B-1B Lancer", 1050, 21000, 80000),
                    MilitaryType.BOMBER),
            new MilitaryPlane(new Plane("B-2 Spirit", 1030, 22000, 70000),
                    MilitaryType.BOMBER),
            new MilitaryPlane(new Plane("B-52 Stratofortress", 1000, 20000, 80000),
                    MilitaryType.BOMBER),
            new MilitaryPlane(new Plane("F-15", 1500, 12000, 10000),
                    MilitaryType.FIGHTER),
            new MilitaryPlane(new Plane("F-22", 1550, 13000, 11000),
                    MilitaryType.FIGHTER),
            new MilitaryPlane(new Plane("C-130 Hercules", 650, 5000, 110000),
                    MilitaryType.TRANSPORT),
            new ExperimentalPlane(new Plane("Bell X-14", 277, 482, 500),
                    ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane(new Plane("Ryan X-13 Vertijet", 560, 307, 500),
                    ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );



    Airport airport = new Airport(planes);

    List<MilitaryPlane> transportMilitaryPlanes = Arrays.asList(new MilitaryPlane(new Plane("C-130 Hercules", 650, 5000, 110000),
            MilitaryType.TRANSPORT));
    @Test
    public void testGetTransportMilitaryPlanes() {
        Assert.assertEquals(transportMilitaryPlanes, airport.getTransportMilitaryPlanes());
    }

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane(
            new Plane("Boeing-747", 980, 16100, 70500),
            242);
    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Assert.assertEquals(planeWithMaxPassengerCapacity, airport.getPassengerPlaneWithMaxPassengersCapacity());
    }

    List<Plane> planesSortedByMaxLoadCapacity = Arrays.asList(
            new ExperimentalPlane(new Plane("Bell X-14", 277, 482, 500),
                    ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane(new Plane("Ryan X-13 Vertijet", 560, 307, 500),
                    ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET),
            new MilitaryPlane(new Plane("F-15", 1500, 12000, 10000),
                    MilitaryType.FIGHTER),
            new MilitaryPlane(new Plane("F-22", 1550, 13000, 11000),
                    MilitaryType.FIGHTER),
            new PassengerPlane(new Plane("Embraer 190", 870, 8100, 30800),
                    64),
            new PassengerPlane(new Plane("Sukhoi Superjet 100", 870, 11500, 50500),
                    140),
            new PassengerPlane(new Plane("Boeing-737", 900, 12000, 60500),
                    164),
            new PassengerPlane(new Plane("Bombardier CS300", 920, 11000, 60700),
                    196),
            new PassengerPlane(new Plane("Boeing-737-800", 940, 12300, 63870),
                    192),
            new PassengerPlane(new Plane("Airbus A320", 930, 11800, 65500),
                    188),
            new MilitaryPlane(new Plane("B-2 Spirit", 1030, 22000, 70000),
                    MilitaryType.BOMBER),
            new PassengerPlane(new Plane("Boeing-747", 980, 16100, 70500),
                    242),
            new MilitaryPlane(new Plane("B-1B Lancer", 1050, 21000, 80000),
                    MilitaryType.BOMBER),
            new MilitaryPlane(new Plane("B-52 Stratofortress", 1000, 20000, 80000),
                    MilitaryType.BOMBER),
            new PassengerPlane(new Plane("Airbus A330", 990, 14800, 80500),
                    222),
            new MilitaryPlane(new Plane("C-130 Hercules", 650, 5000, 110000),
                    MilitaryType.TRANSPORT)
    );
    Airport airportSortedByMaxLoadCapacity = new Airport(planesSortedByMaxLoadCapacity);
    @Test
    public void testSortByMaxLoadCapacity() {
        airport.sortByMaxLoadCapacity();
        Assert.assertEquals(airportSortedByMaxLoadCapacity.toString(), airport.toString());
    }

    boolean isBomberInMilitaryPlanes = true;
    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Assert.assertTrue(isBomberInMilitaryPlanes);
    }

    boolean hasUnclassifiedPlanes = false;
    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
