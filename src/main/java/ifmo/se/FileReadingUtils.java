package ifmo.se;

import com.google.gson.Gson;
import ifmo.se.exc.JsonWritingException;

import java.io.*;
import java.nio.file.Path;

/**
 * Утилиты для чтения и записи файлов
 */
public class FileReadingUtils {

    /**
     * Сохраняет коллекцию в файл
     * @param collectionManager коллекция
     * @param fileName имя файла
     * @throws JsonWritingException если произошла ошибка при записи в JSON
     */
    public static void save(CollectionManager collectionManager, String fileName) throws JsonWritingException {

        try(FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(new Gson().toJson(collectionManager));
        }catch (Exception e) {
            throw new JsonWritingException(e);
        }

    }

    /**
     * Загружает коллекцию из файла
     * @param file файл
     * @return коллекция
     * @throws FileNotFoundException если файл не найден
     */
    public static CollectionManager load(Path file) throws FileNotFoundException {
        try {
            return new Gson().fromJson(new InputStreamReader(new FileInputStream(file.toFile())), CollectionManager.class);
        } catch (Exception e) {
            return new CollectionManager();
        }

    }
}
