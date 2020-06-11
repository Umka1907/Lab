package Commands;

import citis.City;
import citis.DataCities;

import java.util.ArrayList;

public class GroupCountingByGovernmentCommand implements Command {
    public GroupCountingByGovernmentCommand(){
        CommandExecutor.addCommand("group_counting_by_government", this);}
    String answer;

    @Override
    public void execute(String str, DataCities data) {
        if(!data.cities.isEmpty()){
            ArrayList<City> groupGERONTOCRACY = new ArrayList<>();
            ArrayList<City> groupMERITOCRACY = new ArrayList<>();
            ArrayList<City> groupDEMOCRACY = new ArrayList<>();

            for(City city: data.cities) {
                switch (city.getGovernment()) {
                    case DEMOCRACY:
                        groupDEMOCRACY.add(city);
                        break;
                    case MERITOCRACY:
                        groupMERITOCRACY.add(city);
                        break;
                    case GERONTOCRACY:
                        groupGERONTOCRACY.add(city);
                        break;
                }
            }

            answer = "group DEMOCRACY: "+ groupDEMOCRACY.size() +'\n'+
            "group MERITOCRACY: "+ groupMERITOCRACY.size()+ '\n'+
            "group GERONTOCRACY: "+ groupGERONTOCRACY.size();
        } else {
            answer = ("Коллекция пуста. ");
        }
    }
    @Override
    public String getAnswer() {
        return answer;
    }
}
