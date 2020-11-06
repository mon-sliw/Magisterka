package pl.mis.magisterka.badania.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TestingData {

    private final ArrayList<Long> times;
    private Integer successfulResponses;
    private Integer failedResponses;

    public TestingData() {
        times = new ArrayList<>();
        successfulResponses = 0;
        failedResponses = 0;
    }

    public void addTime(long t) {
        times.add(t);
    }

    public void addSuccessfulResponse() {
        successfulResponses++;
    }

    public void addFailedResponse() {
        failedResponses++;
    }

    public void showTimes() {
        System.out.println("---");
        times.forEach(System.out::println);
        System.out.println("---");

    }

    public void showAverageTime() {
        long sum = times.stream().mapToLong(t -> t).sum();
        long av = sum / times.size();
        System.out.println("Average time: " + av + " ms");
    }

    public void showResponses() {
        System.out.println("Successful responses: " + successfulResponses);
        System.out.println("Failed responses: " + failedResponses);
    }

    public void saveToCSV() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        LocalDateTime now = LocalDateTime.now();
        String pathname = "eureka-" + dtf.format(now) + ".csv";
        File file = new File(pathname);
        try (PrintWriter pw = new PrintWriter(file)){
            times.forEach(pw::println);
            System.out.println("saved to csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
