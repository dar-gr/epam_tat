package flight;

public class MyPlane  extends Plane {
    public MyPlane(Plane plane) {
        super(plane.getModel(), plane.getMaxSpeed(), plane.getMaxFlightDistance(), plane.getMinLoadCapacity());
    }
}
