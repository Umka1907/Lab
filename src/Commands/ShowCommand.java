package Commands;

import citis.City;
import citis.DataCities;

public class ShowCommand implements Command {
    public ShowCommand(){CommandExecutor.addCommand("show", this);}
    String answer = "" ;

    @Override
    public void execute(String str, DataCities data) {
        if(data.cities.size() != 0 ) {
            for (City city: data.cities){
                answer = answer + city.toString() +'\n';
            }
        } else {
            answer = ("Коллекция пуста.");
        }

    }
    @Override
    public String getAnswer() {
        return answer;
    }
}
