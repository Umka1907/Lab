package citis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Inputting {
    private static boolean fromFile = false;
    private static LinkedList<String> listCommands = new LinkedList<>();
    public static ArrayList<String> runningScriptNames = new ArrayList<>();

    public static LinkedList<String> getListCommands() {
        return listCommands;
    }

    public static boolean isFromFile() {
        return fromFile;
    }



    public static void parseScript(String failName) throws IOException {
        runningScriptNames.add(failName);

        File file = new File(failName);

        String date = "";

        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        while (bufferedInputStream.available() > 0) {
            date += (char) bufferedInputStream.read();
        }
        date += '\n';

        String lastLine = "";
        LinkedList<String> stringsCommands = new LinkedList<>();
        for (char c : date.toCharArray()) {
            if (c == '\n') {
                stringsCommands.add(lastLine);
                lastLine = "";
            } else  {
                lastLine += c;
            }
        }
        stringsCommands.add("ENDFILE " + failName);
        int size = stringsCommands.size();
        for (int i = 0; i < size; i++) {
            listCommands.addFirst(stringsCommands.pollLast());
        }

        fromFile = true;
    }


    public static String readLine() {
        String command = listCommands.poll().trim();

        if (command.split(" ")[0].equals("ENDFILE")) {
            runningScriptNames.remove(command.split(" ")[1]);
        } else {

            System.out.println(">");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Problem with sleeping");
            }

            System.out.println(command + ": ");
        }
        return command;
    }
}

