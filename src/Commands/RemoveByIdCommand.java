package Commands;

import citis.DataCities;

public class RemoveByIdCommand implements Command {

    public RemoveByIdCommand(){CommandExecutor.addCommand("remove_by_id", this);}
    String answer = null;

    @Override
    public void execute(String stringId, DataCities data) {
        try{

            Integer id = Integer.parseInt(stringId);
            if (data.arrayListId().contains(id)){
                data.removeElementById(id);

                answer =("Элемент с " + id + " был удален");
            }else{
                answer =("Элемента с таким id нет в коллекции");
            }

        }catch (NumberFormatException e){
            answer =("Wrong id number format");
        }
    }
    @Override
    public String getAnswer() {
        return answer;
    }
}
