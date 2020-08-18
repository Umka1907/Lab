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

    private static String type;

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

    public void setType(String type) {
        this.type = type;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void param() throws IOException, JAXBException {

        String enter = enterCommand.enterCommand();
        bagging(enter);

    }

    public void getCityArg() throws IOException, JAXBException {

        if ( (type.equals("add"))  ||  (type.equals("add_if_min")) || (type.trim().equals("update_data")) ) {
            City cityArg = DataNewCity.newCity();
            cityArgument = serializeArg(cityArg);
        }}




    private String serializeArg(City city) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream so = new ObjectOutputStream(bo);
        so.writeObject(city);
        so.flush();
        return Base64.encode(bo.toByteArray());
    }

    public void bagging(String bag) throws IOException, JAXBException {
        String[] actionParts = bag.split(" ");
        if (actionParts.length == 1){
            type = actionParts[0];
        }
        else if (actionParts.length == 2){
            type = actionParts[0];
            params = actionParts[1];
        }
        else {
            System.out.println("Необрабатываемый запрос. Ввидите коректный запрос (Запрос может содержать: команду или команду + аргумент) ");
            param();
        }
    }

}
