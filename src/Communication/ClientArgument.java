package Communication;

import Commands.*;
import citis.*;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClientArgument {
    Enter enterCommand = new Enter();
    CommandExecutor commandExecutor = new CommandExecutor();

    FileCity fileCity = new FileCity();

    private String nameFile = new String();

    private String type;

    private String cityArgument;

    public String getCityArgument() {
        return cityArgument;
    }

    public void setCityArgument(String cityArgument) {
        this.cityArgument = cityArgument;
    }

    private String params = new String() ;

    public  String getType() {
        return type;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void param(String nameFile) throws IOException, JAXBException {
        this.nameFile = nameFile;
        String enter = enterCommand.enterCommand();
        String[] actionParts = enter.split(" ");
        if (actionParts.length == 1){
            type = actionParts[0];
        }
        else if (actionParts.length == 2){
            type = actionParts[0];
            params = actionParts[1];
        }
        else {
            System.out.println("Необрабатываемый запрос. Ввидите коректный запрос (Запрос может содержать: команду или команду + фргумент) ");
            param(nameFile);
        }
        getCityArg();
    }

    public void getCityArg() throws IOException, JAXBException {


        DataCities dataCities = fileCity.readFromXML( nameFile);


        if((type.equals("update")) ) {
            if ((!params.isEmpty()) && (dataCities.arrayListId().contains(Integer.parseInt(params)))) {
                City cityArg = DataNewCity.newCity();
                cityArgument = serializeArg(cityArg);
            } else {
                System.out.println("Элемента с таким id нет в коллекции или id не был указан");
                param(nameFile);
            }
        }

        if ((type.equals("add")) || (type.equals("add_if_min"))) {
            City cityArg = DataNewCity.newCity();
            cityArgument = serializeArg(cityArg);
        }

        if ((type.equals("execute_script"))){
            AddCommand addCommand = new AddCommand();
            AddIfMinCommand addIfMinCommand = new AddIfMinCommand();
            ClearCommand clearCommand = new ClearCommand();
            ExitCommand exitCommand = new ExitCommand();
            RemoveByIdCommand removeByIdCommand = new RemoveByIdCommand();
            UpdateCommand updateCommand = new UpdateCommand();
            MaxByMetersAboveSeaLevelCommand maxByMetersAboveSeaLevelCommand = new MaxByMetersAboveSeaLevelCommand();
            ShowCommand showCommand = new ShowCommand();
            RemoveGreaterCommand removeGreaterCommand = new RemoveGreaterCommand();
            GroupCountingByGovernmentCommand groupCountingByGovernmentCommand = new GroupCountingByGovernmentCommand();
            HelpCommand helpCommand = new HelpCommand();
            InfoCommand infoCommand = new InfoCommand();
            FilterContainsNameCommand filterContainsNameCommand = new FilterContainsNameCommand();
            HistoryCommand historyCommand = new HistoryCommand();
            SaveCommand saveCommand = new SaveCommand();
            ExecuteScriptCommand executeScriptCommand = new ExecuteScriptCommand();
            commandExecutor.execute(type+" "+ params,dataCities );
            commandExecutor.execute("save "+ nameFile,dataCities );

        }
    }

    private String serializeArg(City city) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream so = new ObjectOutputStream(bo);
        so.writeObject(city);
        so.flush();
        return Base64.encode(bo.toByteArray());
    }


}
