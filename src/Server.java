import Commands.*;
import Communication.Communication;
import citis.City;
import citis.DataCities;
import citis.Enter;
import citis.FileCity;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    static CommandExecutor commandExecutor = new CommandExecutor();



    public static void main(String []arg) throws JAXBException {
       try {

           System.out.println("Укажите порт для прослушивания:");
           String port = Enter.writeString();
        String nameFile = arg[0];
        FileCity fileCity = new FileCity();
        DataCities dataCities = fileCity.readFromXML(nameFile);
        Communication communication = null;
        Enter enter = new Enter();

        UpdateCommand updateCommand = new UpdateCommand();
        SaveCommand saveCommand = new SaveCommand();
        ExecuteScriptCommand executeScriptCommand = new ExecuteScriptCommand();


        try
        {
            //Создаем сокет
            DatagramSocket sock = new DatagramSocket(Integer.parseInt(port));

            //буфер для получения входящих данных
            byte[] buffer = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);

            System.out.println("Ожидаем данные...");

            while(true)
            {
                //Получаем данные
                sock.receive(incoming);
                byte[] data = incoming.getData();
                String s = new String(data, 0, incoming.getLength());
                communication = Communication.deserializeFromString(s);
                System.out.println("Сервер получил: " + communication.getType());
                enter.history(communication.getType());


                //Ответ
                if (communication.getType().equals("exit")){
                    System.out.println("Клиент законцил работу.");
                }else {
                    s = commandExecute(communication, dataCities);
                    DatagramPacket dp = new DatagramPacket(s.getBytes() , s.getBytes().length , incoming.getAddress() , incoming.getPort());
                    sock.send(dp);
                }


                commandExecutor.execute("save" + nameFile, dataCities);
            }
        }

        catch(IOException | ClassNotFoundException e)
        {
            System.err.println("IOException " + e);
        }
       }catch (Exception e){
           System.out.println("Error "+ e);
       }
    }

    public static String commandExecute(Communication com, DataCities dataCities){

            switch (com.getType()) {
                case "add":
                    return add(com, dataCities);
                case "show":
                    return commandRan(com, dataCities);
                case "info":
                    return commandRan(com, dataCities);
                case "help":
                    return commandRan(com, dataCities);
                case "clear":
                    return commandRan(com, dataCities);
                case "max_by_meters_above_sea_level":
                    return commandRan(com, dataCities);
                case "remove_by_id":
                    return commandRan(com, dataCities);
                case "group_counting_by_government":
                    return commandRan(com, dataCities);
                case "add_if_min":
                    return addIfMin(com, dataCities);
                case "execute_script":
                    return executeScript(com, dataCities);
                case "filter_contains_name":
                    return commandRan(com, dataCities);
                case "update":
                    return update(com, dataCities);
                case "remove_greater":
                    return commandRan(com, dataCities);
                case "history":
                    return commandRan(com, dataCities);
                case "save":
                    return "Данные сохранены на сервере";

            }

            return "НЕИЗВЕСТНЫЙ ТИП КОМАНДЫ";
    }



    static String commandRan(Communication communication, DataCities dataCities){
        InfoCommand infoCommand = new InfoCommand();
        HelpCommand helpCommand = new HelpCommand();
        ShowCommand showCommand = new ShowCommand();
        FilterContainsNameCommand filterContainsNameCommand = new FilterContainsNameCommand();
        GroupCountingByGovernmentCommand groupCountingByGovernmentCommand = new GroupCountingByGovernmentCommand();
        MaxByMetersAboveSeaLevelCommand maxByMetersAboveSeaLevelCommand = new MaxByMetersAboveSeaLevelCommand();
        RemoveByIdCommand removeByIdCommand = new RemoveByIdCommand();
        ClearCommand clearCommand = new ClearCommand();
        RemoveGreaterCommand removeGreaterCommand = new RemoveGreaterCommand();
        HistoryCommand historyCommand = new HistoryCommand();

        
        return commandExecutor.execute(communication.getType()+" "+ communication.getParams(), dataCities);
    }




    static String add(Communication communication, DataCities dataCities) {
       try {
           City city = communication.deserializeCity(communication.getCityArgument());
           dataCities.addElement(city);
       } catch (IOException| ClassNotFoundException e ){
           e.getMessage();
       }

        return "Новый элемент был добавлен в колекцию ";
    }



    static String addIfMin(Communication communication, DataCities dataCities){
        try {
            City city = communication.deserializeCity(communication.getCityArgument());
            if(dataCities.ifMinValues(city) == true){
                dataCities.addElement(city);
                return("Ваш объект добавлен в коллекцию." );
            } else {
                return("Значение вашего элемента не меньше чем минимальное у значений из коллекции");
            }

        } catch (IOException| ClassNotFoundException e ){
            e.getMessage();
        }
        return "Что то пошло не так";
    }


    static String update(Communication communication, DataCities dataCities) {
        try {

        City updateCity = communication.deserializeCity(communication.getCityArgument());
            dataCities.updateElementById(Integer.parseInt(communication.getParams()), updateCity);
            City city = dataCities.getElementById(Integer.parseInt(communication.getParams()));
            return ("Элемент с id  " + Integer.parseInt(communication.getParams()) + " был изменен на: "+ city);
        } catch (IOException| ClassNotFoundException e ){
            e.getMessage();
        }
        return "Что то пошло не так";
    }


    static String executeScript(Communication communication, DataCities dataCities){
        return "executeScript выполнена";
    }

}

