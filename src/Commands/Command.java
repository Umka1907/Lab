package Commands;
import citis.DataCities;

public interface Command {
    void execute(String str, DataCities data) ;
    String answer = null;
    String getAnswer();
}
