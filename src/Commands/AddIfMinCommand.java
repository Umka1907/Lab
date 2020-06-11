package Commands;

import citis.City;
import citis.DataCities;
import citis.DataNewCity;

public class AddIfMinCommand implements Command {
    public AddIfMinCommand(){CommandExecutor.addCommand("add_if_min", this);}
    String answer = new String();

    @Override
    public void execute(String str, DataCities data) {
        City newElement = DataNewCity.newCity();
        if(data.ifMinValues(newElement) == true){
            data.addElement(newElement);
            answer =("Ваш объект добавлен в коллекцию." );
        } else {
            answer =("\n" +
                    "Значение вашего элемента не меньше чем минимальное у значений из коллекции");
        }

    }

    @Override
    public String getAnswer() {
        return answer;
    }
}
