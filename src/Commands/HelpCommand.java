package Commands;

import citis.DataCities;

public class HelpCommand implements Command {
    public HelpCommand(){CommandExecutor.addCommand("help", this);}
    String answer;

    @Override
    public void execute(String str, DataCities data) {
        answer =
        "help:                                    Вывести справку по доступным командам;  " + '\n' +
        "info:                                    Вывести информацию о коллекции; " + '\n' +
        "show:                                    Вывести  все элементы коллекции;"+ '\n' +
        "add:                                     Добавить новый элемент в коллекцию"+ '\n' +
        "update:                                  Обновить значение элемента коллекции, id которого равен заданному"+ '\n' +
        "remove_by_id:                            Удалить элемент из коллекции по его id; "+ '\n' +
        "clear:                                   Очистить коллекцию;"+ '\n' +
        "execute_script:                          Считать и исполнить скрипт из указанного файла;"+ '\n' +
        "exit:                                    Завершить программу (без сохранения в файл);"+ '\n' +
        "add_if_min:                              Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции;"+ '\n' +
        "remove_greater:                          Удалить из коллекции все элементы, превышающие заданный;"+ '\n' +
        "history:                                 Вывести последние 7 команд (без их аргументов);"+ '\n' +
        "max_by_meters_above_sea_level:           Вывести любой объект из коллекции, значение поля metersAboveSeaLevel которого является максимальным;"+ '\n' +
        "group_counting_by_government:            Сгруппировать элементы коллекции по значению поля government, вывести количество элементов в каждой группе; "+ '\n' +
        "filter_contains_name:                    Вывести элементы, значение поля name которых содержит заданную подстроку;" ;


    }

    @Override
    public String getAnswer() {
        return answer;
    }
}


