package main;

import Utils.CollectionStatisticsUtil;
import Utils.JsonUtil;
import Utils.ListSizeChecker;
import Utils.ObjectIdentityChecker;
import models.ComparatorFactory;
import models.Statistics;
import models.Student;
import models.University;

import enums.StudentEnum;
import enums.UniversityEnum;
import filehandling.XlsReader;
import filehandling.XlsWriter;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {
    /**

     Основной метод приложения, который считывает информацию о студентах и университетах из файла, сортирует список

     студентов по заданным критериям, сериализует и десериализует объекты студентов и университетов,

     создает статистику и записывает ее в файл.

     @param args массив строковых аргументов, передаваемых при запуске приложения.

     @throws IOException если возникает ошибка ввода-вывода при чтении/записи файла.
     */
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args)throws IOException {



        XlsReader fileReader = XlsReader.getInstance();
        // Чтение списка студентов из файла
        List<Student> studentsList = fileReader.readStudentsFromFile("universityInfo.xlsx");
        // Сортировка списка студентов
        Comparator<Student> studentComparator = ComparatorFactory.getStudentComparator(StudentEnum.AVG_EXAM_SCORE);
        studentsList.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);


        // Сериализация списка студентов
        String studentJson = JsonUtil.serializeStudentList(studentsList);
        // Вывод JSON-строк в консоль
        System.out.println("JSON-строки студентов: " + studentJson + "\n");
        // Десериализация полученной JSON-строки студентов обратно в список студентов
        List<Student> deserializedStudentsList = JsonUtil.deserializeStudentList(studentJson);
        // Чтение списка университетов из файла
        List<University> universitiesList = fileReader.readUniversitiesFromFile("universityInfo.xlsx");
        // Сортировка списка университетов
        Comparator<University> universityComparator = ComparatorFactory.getUniversityComparator(UniversityEnum.SHORT_NAME);

        universitiesList.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);


        // Сериализация списка университетов
        String universityJson = JsonUtil.serializeUniversityList(universitiesList);
        // Вывод JSON-строк в консоль
        System.out.println("JSON-строки университетов: " + universityJson + "\n");
        // Де сериализация полученной JSON-строки университетов обратно в список студентов
        List<University> deserializedUniversityList = JsonUtil.deserializeUniversityList(universityJson);

        // Проверка сериализации и десериализации отдельных объектов студентов и университетов, вывод результатов сравнения отдельных объектов
        ObjectIdentityChecker.checkAllObjectsIdentity(studentsList, universitiesList);

        //Сравнение количества элементов в исходной и в десериализованной коллекциях
        ListSizeChecker.isListsSizeEqual(studentsList, deserializedStudentsList, "студентов");
        ListSizeChecker.isListsSizeEqual(universitiesList, deserializedUniversityList, "университетов");

        // Создание списка статистики и запись его в файл
        List<Statistics> statisticsList = CollectionStatisticsUtil.createStatistics(studentsList, universitiesList);
        XlsWriter.generateTableAndWriteToFile(statisticsList, "statistics.xlsx");

        logger.log(INFO, "Application finished");
    }
}
