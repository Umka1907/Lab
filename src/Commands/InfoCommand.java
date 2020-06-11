package Commands;

import citis.DataCities;

public class InfoCommand implements Command {
    public InfoCommand(){CommandExecutor.addCommand("info", this);}
    String answer = null;

    @Override
    public void execute(String str, DataCities data) {
        answer = (data.toString()) ;
    }
    @Override
    public String getAnswer() {
        return answer;
    }
}
