import java.util.ArrayList;

public class ToDoList {
    public String input;
    public String coreCommand;
    public ArrayList<String> toDoArrayList = new ArrayList<>();


    public ToDoList(String input) {
        this.input = input;

    }

    public String editDigitalCheck() {
        String digitalIndex = "";
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (Character.isDigit(symbol)) {
                digitalIndex = digitalIndex + String.valueOf(input.charAt(i));
            }
        }
        return digitalIndex;
    }

    public String editToDoCheck(){
        String text = "";
        for (int i = coreCommand.length(); i<input.length() ;i++){
            boolean isDigit = (Character.isDigit(input.charAt(i)));
            if (!isDigit) {
                text = text + input.charAt(i);
            }
        }
        return text.trim();
    }

    public String addFunction() {

        editToDoCheck();
        String text = editToDoCheck();
        System.out.println("edittodocheck is" + text);
        if (text.isEmpty()){
            System.out.println("Введите название задачи");
        } else {
            System.out.println(input);
            System.out.println(text);
            toDoArrayList.add(text);
            System.out.println("Добавлено дело: " + text);
            System.out.println("Длинна списка" + toDoArrayList.size());
        }
        /*int start = input.indexOf(coreCommand) + coreCommand.length();
        int end = input.indexOf(".", start);
        if (start < 0 || end < 0) {
            System.out.println("Введите название задачи");
            return "";
        } else {
            text = input.substring(start, end).trim();
            if (text.isBlank()) {
                System.out.println("Введите название задачи");
            } else {
                toDoArrayList.add(text);
                System.out.println("Добавлено дело: " + text);
                System.out.println("Длинна списка" + toDoArrayList.size());
            }
        }*/
        return text;
    }

    public void listFunction() {
        System.out.println("Список дел: ");
        if (toDoArrayList.isEmpty()) {
            System.out.println("Список дел пуст");
        } else {
            for (int i = 0; i < toDoArrayList.size(); i++) {
                System.out.println(i + " - " + toDoArrayList.get(i));
            }
        }
    }

    public String deleteFunction() {
        String index = "";
        int start = input.indexOf(coreCommand) + coreCommand.length();
        int end = input.indexOf(".", start);
        if (start < 0 || end < 0) {
            System.out.println("Некоректное название задачи");
            return "";
        } else {
            index = input.substring(start, end).trim();
            if (index.isBlank() || (Integer.parseInt(index) + 1) > toDoArrayList.size()) {
                System.out.println("Введите Пункт списка, который вы хотите удалить");
            } else {

                System.out.println("Удалено дело: " + toDoArrayList.get(Integer.parseInt(index)));
                toDoArrayList.remove(Integer.parseInt(index));
            }

        }
        return index;
    }

    public void editFunction() {
        editDigitalCheck();
        editToDoCheck();
        int editIndex = Integer.parseInt(editDigitalCheck()) ;

        if(editDigitalCheck().isBlank() || (editIndex + 1) > toDoArrayList.size()){
            System.out.println("Введите номер пункта списка");

        } else {
            if(editToDoCheck().isBlank()){
                System.out.println("Введите текст изменяемой задачи");
            } else {

                System.out.println("Дело " + toDoArrayList.get(editIndex) + " Заменено на " + editToDoCheck());
                toDoArrayList.set(editIndex,editToDoCheck());
            }
        }
    }




        /*String index = "";
        String text = "";
        int startIndex =input.indexOf(coreCommand)+coreCommand.length();
        int endIndex = input.indexOf(" ",startIndex) + 1;
        if(startIndex < 0 || endIndex < 0){
            System.out.println("Некоректное название задачи");
            return "";
        } else{
            index = input.substring(startIndex, endIndex).trim();
            if (index.isBlank() || (Integer.parseInt(index) + 1) > toDoArrayList.size()){
                System.out.println(index);
                System.out.println("Введите Пункт списка, который вы хотите Изменить");
            } else {
                int startText =input.indexOf(index)+index.length();
                int endText = input.indexOf(".",startText);
                if(startText < 0 || endText < 0){
                    System.out.println("Введите название задачи");
                    return "";
                } else{
                    text = input.substring(startText, endText).trim();
                    if (text.isBlank()){
                        System.out.println("Введите название задачи");
                    } else {
                        System.out.println("Дело " + toDoArrayList.get(Integer.parseInt(index)) + "заменено на " + text );
                        toDoArrayList.add(Integer.parseInt(index),text);


                    }
                }


            }
        }

        return index;*/


    public String subStringCommand() {
        String text = "";
        for (int i = 0; i<input.length() ;i++){
            boolean isDigit = (Character.isDigit(input.charAt(i)));
            boolean isBlank = (input.charAt(i) == ' ');
            if (!isDigit || isBlank) {
                text = text + input.charAt(i);
            }
        }
        System.out.println("corecommand" + coreCommand);
        coreCommand = text;
        return coreCommand;

    }

    public void recognizeCommands() {
        subStringCommand();
        switch (coreCommand) {
            case ("LIST"):
                listFunction();
                break;
            case ("ADD"):
                addFunction();
                break;
            case ("EDIT"):
                editFunction();
                break;
            case ("DELETE"):
                deleteFunction();
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}
