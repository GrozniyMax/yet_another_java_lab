package ifmo.se.command.impls.help;

import ifmo.se.command.Command;

import java.io.PrintStream;


/**
 * Команда {@code help}
 */
public class HelpCommand implements Command {

    private final PrintStream out;

    private static final String HELP_MESAGE = """
help : вывести справку по доступным командам
info : вывести в стандартный поток вывода информацию о коллекции
show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
add {element} : добавить новый элемент в коллекцию
update id {element} : обновить значение элемента коллекции, id которого равен заданному
remove_by_id id : удалить элемент из коллекции по его id
clear : очистить коллекцию
save : сохранить коллекцию в файл
execute_script file_name : считать и исполнить скрипт из указанного файла
exit : завершить программу (без сохранения в файл)
remove_first : удалить первый элемент из коллекции
add_if_min : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
remove_greater : удалить из коллекции все элементы, превышающие заданный
filter_starts_with name : вывести элементы, значение поля name которых начинается с заданной подстроки
print_unique_number_of_rooms : вывести количество уникальных значений поля rooms
print_field_descending_view : вывести значения поля view в порядке убывания
""";

    public HelpCommand(PrintStream out) {
        this.out = out;
    }

    @Override
    public void execute() {
        out.println(HELP_MESAGE);
    }
}
