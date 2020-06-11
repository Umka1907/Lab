package Commands;

import citis.City;
import citis.DataCities;

public class MaxByMetersAboveSeaLevelCommand implements Command {
    public MaxByMetersAboveSeaLevelCommand(){CommandExecutor.addCommand("max_by_meters_above_sea_level", this);}
    String answer = null;

    @Override
    public void execute(String str, DataCities data) {
        if(data.cities.isEmpty()){
            answer =("This collection has no items. ");
        } else {
            int id = data.getIdMaxMetersAboveSeaLevel(data);
            City city = data.getElementById(id);
            answer =("Эллемент с наибольшим значением по полю metersAboveSeaLevel:  " + '\n'+  city);

        }
    }
    @Override
    public String getAnswer() {
        return answer;
    }
}
