package ifmo.se.command;

import ifmo.se.cli.CommandLineReader;

/**
 * Фабрика конкретной команды
 */
public interface CommandFactory {


    /**
     * Создание команды
     * @param input для чтения дополнительных данных
     * @param lastText аргумент команды, который мог быть передан в одной строке с командой
     * @return команда
     */
    Command create(CommandLineReader input, String lastText);

    /**
     * Получение имени поддерживаемой команды
     * @return имя команды
     * @deprecated
     */
    String getSupportedCommand();
}
