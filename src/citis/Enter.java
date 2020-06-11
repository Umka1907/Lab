package citis;

import java.util.LinkedList;
import java.util.Scanner;

public class Enter {
    static LinkedList<String> commands = new LinkedList<>();
    public static String thisCommand;

    public static String writeString(){
        Scanner sc = new Scanner(System.in);
        System.out.println(">");
        return sc.nextLine();
    }

    public static String enterCommand(){
        System.out.println("Сообщение серверу: \n(Что бы получить информацию о доступных командах введите 'help' )");
        String command = Enter.writeString();
        history(command);
        thisCommand = command;
        return command;
    }

    public static void history(String com){
        if (commands.size() >= 7 ){
            commands.remove(0);
            commands.add(com);
        } else {
            commands.add(com);
        }
    }

    public LinkedList<String> getCommands() {
        return commands;
    }
}
