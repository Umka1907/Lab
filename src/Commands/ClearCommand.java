package Commands;

import citis.DataCities;

public class ClearCommand implements Command {
    public ClearCommand(){CommandExecutor.addCommand("clear", this);}
    String answer;

    @Override
    public void execute(String str, DataCities data) {
        if (data.cities.isEmpty()){
            answer = ("Коллекция и так пуста. ");
        }else {
            data.clearCollection();
            answer = ("Все элементы коллекции удалены. ");
        }
    }

    @Override
    public String getAnswer() {
        return answer;
    }
}
