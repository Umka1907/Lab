package Commands;

import citis.City;
import citis.DataCities;

public class FilterContainsNameCommand implements Command {
    public FilterContainsNameCommand(){CommandExecutor.addCommand("filter_contains_name", this);}
    String answer = new String();

    @Override
    public void execute(String str, DataCities data) {
        if (str!=null) {
            if(!data.filterName(str).isEmpty()){
                for (City city : data.filterName(str)) {
                    answer = answer + city + '\n';
                }
            }
            else {
                answer = "Никакие элементы не оказались подходящими или коллекция пуста";
            }
        }
        else {
            answer = "Значение для фильтра не указанно";
        }
    }
    @Override
    public String getAnswer() {
        return answer;
    }

}
