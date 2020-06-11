package Commands;

import citis.DataCities;
import citis.FileCity;

import javax.xml.bind.JAXBException;

public class SaveCommand implements Command {
    public SaveCommand(){CommandExecutor.addCommand("save", this);}
    String answer = null;

    @Override
    public void execute(String str, DataCities data)  {
        try {
                FileCity fileCity = new FileCity();
                fileCity.convertObjectToXml(data, str);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getAnswer() {
        return answer;
    }
}
