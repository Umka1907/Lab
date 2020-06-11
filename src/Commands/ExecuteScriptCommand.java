package Commands;

import citis.DataCities;
import citis.Enter;
import citis.Inputting;

import java.io.IOException;

public class ExecuteScriptCommand implements Command {

        public ExecuteScriptCommand() { CommandExecutor.addCommand("execute_script", this);}
        String answer;

    @Override
    public void execute(String str, DataCities data)  {
        if (str != null) {
            try {
                if (Inputting.runningScriptNames.contains(str)) {
                    System.out.println("Этот сценарий уже был вызван. Избегайте бесконечной рекурсии.");
                    return;
                }
                Inputting.parseScript(str);
                System.out.println ("Файл " + str + " прочтен, выполнение: " );
                int size = Inputting.getListCommands().size();


                for (int i = 0; i<size; i++ ) {
                    String commandFromAFile = Inputting.readLine();

                    if (commandFromAFile.split(" ")[0].equals("ENDFILE")){
                        System.out.println ("Выполнение команд из файла "+ commandFromAFile.split(" ")[1]+" закончино" );
                        break;

                    }else{
                        Enter.history(commandFromAFile);
                        String ans = CommandExecutor.execute(commandFromAFile, data);
                        System.out.println( ans);
                    }
                }

            } catch (IOException e) {
                System.out.println ("Error while reading script file " + str);
            }
        } else {
            System.out.println("Неправильный формат команд. ");
        }
    }

    @Override
    public String getAnswer() {
        return answer;
    }
}
