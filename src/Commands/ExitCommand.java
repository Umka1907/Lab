package Commands;

import citis.DataCities;

public class ExitCommand implements Command {
    public ExitCommand(){CommandExecutor.addCommand("exit", this);}

    @Override
    public void execute(String str, DataCities data) {
        System.exit(0);
    }

    @Override
    public String getAnswer() {
        return null;
    }
}
