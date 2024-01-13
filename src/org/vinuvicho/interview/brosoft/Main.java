package org.vinuvicho.interview.brosoft;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");

    public static String[] sorted(String[] events) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final LocalDate baseDate = LocalDate.of(1900, 1, 1);

        List<String> listOfEvents = new ArrayList<>();
        for (String event : events) {
            Optional<LocalDate> date = findDateInLine(event, formatter);
            if (date.isEmpty()) continue;

            Period period = Period.between(baseDate, date.get());
            int dateIndex = event.indexOf(date.get().format(formatter));
            String title = event.substring(0, dateIndex).trim();

            StringBuilder sb = new StringBuilder();
            sb.append(period.getYears())
                    .append("years;")
                    .append(period.getMonths())
                    .append("months;")
                    .append(period.getDays())
                    .append("days-")
                    .append(title);

            listOfEvents.add(sb.toString());
        }
        listOfEvents.sort(String::compareTo);

        return listOfEvents.toArray(new String[0]);
    }

    private static Optional<LocalDate> findDateInLine(String line, DateTimeFormatter formatter) {
        Matcher m = DATE_PATTERN.matcher(line);
        if (m.find()) {
            LocalDate date = LocalDate.parse(m.group(), formatter);
            return Optional.of(date);
        }
        return Optional.empty();
    }

    // Main method for testing
    public static void main(String[] args) {
        String[] events = {"The first human in space 12-03-1961",
                "Event A 01-01-1903",
                "Wrong Format 1900-03-03",
                "New Year Party '00 01-01-1900"};
        String[] sortedEvents = sorted(events);

        for (String sortedEvent : sortedEvents) {
            System.out.println(sortedEvent);
        }
    }
}