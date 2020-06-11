package Commands;

import citis.DataCities;
import citis.Enter;

public class HistoryCommand implements Command {
    public HistoryCommand(){CommandExecutor.addCommand("history", this);}
    String answer = null;

    @Override
    public void execute(String str, DataCities data) {
        Enter enterCommand = new Enter();

        for (String command: enterCommand.getCommands()){
            answer = answer + (command) + '\n';
        }

    }

    @Override
    public String getAnswer() {
        return answer;
    }
}
