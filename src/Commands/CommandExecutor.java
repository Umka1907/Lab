package Commands;

import citis.DataCities;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    public static Map<String , Command> commands = new HashMap<>();

    public static Map<String, Command> getCommands() {
        return commands;
    }

    public static void addCommand(String commandName, Command command){

        commands.put(commandName,command);
    }

    public static String execute(String action, DataCities dataCities){
        String[] actionParts = action.split(" ");
        if (action.isEmpty()){return "Что то пошло не так";}
        if(actionParts.length==1) {
            Command command = commands.get(actionParts[0]);
            if (command != null) {
                command.execute(null, dataCities);
                return  command.getAnswer();
            } else {
                return ("Данной команды не существует, нажмите help, что бы получить информацию о доступных командах.");
            }
        }else if (actionParts.length == 2){
            String arg = actionParts[1];
            Command command = commands.get(actionParts[0]);
            if (command != null) {
                command.execute(arg, dataCities);
                return  command.getAnswer();
            } else {
                return("Данной команды не существует, нажмите help, что бы получить информацию о доступных командах.");
            }
        }else{
            return("Данной команды не существует, нажмите help, что бы получить информацию о доступных командах");
        }
    }
}
