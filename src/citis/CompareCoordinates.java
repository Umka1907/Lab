package citis;

import java.util.Comparator;

public class CompareCoordinates implements Comparator<City> {
    @Override
    public int compare(City c1, City c2){
        Float x1= c1.getCoordinates().getX();
        Float x2= c2.getCoordinates().getX();
        Long y1= c1.getCoordinates().getY();
        Long y2= c2.getCoordinates().getY();

        double distance1 = Math.sqrt(Math.pow(x1,2) + Math.pow(y1,2));
        double distance2 = Math.sqrt(Math.pow(x2,2) + Math.pow(y2,2));

        return (int) (distance1-distance2);
    }
}
