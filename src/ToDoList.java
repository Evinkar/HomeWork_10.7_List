import java.util.ArrayList;

    public class ToDoList {
    public String input;
    public String coreCommand;
    public ArrayList<String> toDoArrayList = new ArrayList<>();
    public int editIndex;


    public ToDoList() {

    }

    public String digitalCheck() {
        String digitalIndex = "";
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (Character.isDigit(symbol)) {
                digitalIndex = digitalIndex + String.valueOf(input.charAt(i));
            }
        }
        return digitalIndex;
    }

    public String toDoCheck() {
        String text = "";
        for (int i = coreCommand.length(); i < input.length(); i++) {
            boolean isDigit = (Character.isDigit(input.charAt(i)));
            if (!isDigit) {
                text = text + input.charAt(i);
            }
        }
        return text.trim();
    }

    public String addFunction() {

        toDoCheck();
        String text = toDoCheck();

        if (text.isEmpty()) {
            System.out.println("Введите название задачи, которую вы хотите добавить");
        } else {

            toDoArrayList.add(text);
            System.out.println("Добавлено дело: " + text);
            System.out.println("Длинна списка: " + toDoArrayList.size());
        }

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

    public void deleteFunction() {
        digitalCheck();
        toDoCheck();

        if (digitalCheck().isBlank()) {
            System.out.println("Введите номер пункта списка");

        } else {
            editIndex = Integer.parseInt(digitalCheck());
            if ((editIndex + 1) > toDoArrayList.size()) {
                System.out.println("Введите номер уже существующей задачи после команды DELETE");
            } else {
                System.out.println("Дело " + toDoArrayList.get(editIndex) + " Удалено!");
                toDoArrayList.remove(editIndex);
            }
        }
    }

    public void editFunction() {
        digitalCheck();
        toDoCheck();

        if (digitalCheck().isBlank()) {
            System.out.println("Введите номер пункта списка");

        } else {
            editIndex = Integer.parseInt(digitalCheck());
            if ((editIndex + 1) > toDoArrayList.size()) {
                System.out.println("Введите номер уже существующей задачи после команды EDIT");
            } else {
                if (toDoCheck().isBlank()) {

                    System.out.println("Введите текст изменяемой задачи");
                } else {
                    System.out.println("Дело " + toDoArrayList.get(editIndex) + " Заменено на " + toDoCheck());
                    toDoArrayList.set(editIndex, toDoCheck());
                }
            }
        }
    }

    public String subStringCommand() {
        String text = "";
        for (int i = 0; i < input.length(); i++) {
            boolean isDigit = (Character.isDigit(input.charAt(i)));
            String symbol = String.valueOf(input.charAt(i));
            boolean isBlank = symbol.isBlank();
            if (!isDigit && !isBlank) {
                text = text + input.charAt(i);
            } else {
                break;
            }
        }
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
                System.out.println("Неправильная команда. \nВведите, пожалуйста, правильную комманду");
                break;
        }
    }
}
