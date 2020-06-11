package Commands;

import citis.City;
import citis.DataCities;
import citis.DataNewCity;

public class UpdateCommand implements Command {

    public UpdateCommand(){ CommandExecutor.addCommand("update", this);}
    String answer = null;

    @Override
    public void execute(String stringId, DataCities data) {
        try {
            Integer id = Integer.parseInt(stringId);

            if (data.arrayListId().contains(id)){
                City updateCity = DataNewCity.newCity();

                data.updateElementById(id, updateCity);
                City city = data.getElementById(id);
                System.out.println("Элемент с id  " + id + " был изменен на: "+ city);
            }else{
                System.out.println("Элемента с таким id нет в коллекции");
            }


        }catch (NumberFormatException e){
            System.out.println("Wrong id number format");
        }
    }
    @Override
    public String getAnswer() {
        return answer;
    }
}
