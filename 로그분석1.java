/*

2023/3/24 12:25:34:234  coolpizza-오늘은 비가 내림
2023/3/24 12:25:34:347  내일도 비가 내릴까
2023/3/24 12:25:34:785  coolpizza-그것은 하늘만이 알게 되겠지
2023/3/24 12:25:34:885  coolpizza-너의 하늘만이 알게 되겠지
2023/3/24 12:25:36:234  오늘은 사는 우리는 
2023/3/24 12:25:37:271  지금만 생각하면서 살기에도
2023/3/24 12:25:37:571  인생이 바쁘다
2023/3/24 12:26:37:371  coolpizza-날이 점점 따뜻해 진다
2023/3/24 12:30:33:471  coolpizza-날이 점점 길어지고 있다
...


*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        List<Date> dates = new ArrayList<>();
        String inputLine;
        String keyword;

        System.out.print("Enter the keyword you want to search for: ");
        keyword = scanner.nextLine();

        Pattern pattern = Pattern.compile("(\\d{4}/\\d{1,2}/\\d{1,2}).*?(\\d{1,2}:\\d{1,2}:\\d{1,2}:\\d{1,3}).*?(" + Pattern.quote(keyword) + ")");

        System.out.println("Enter the input date and time containing the format 'YYYY/MM/DD HH:mm:ss:SSS' and the keyword '" + keyword + "' or '...' to stop:");

        while (true) {
            inputLine = scanner.nextLine();

            if (inputLine.equals("...")) {
                break;
            }

            Matcher matcher = pattern.matcher(inputLine);

            if (matcher.find()) {
                String dateString = matcher.group(1) + " " + matcher.group(2);

                try {
                    Date date = inputDateFormat.parse(dateString);
                    dates.add(date);
                } catch (ParseException e) {
                    // Do nothing, just skip the line
                }
            }
        }

        Map<String, Integer> secondsCount = new HashMap<>();

        for (Date date : dates) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            String outputDate = outputDateFormat.format(date);
            secondsCount.put(outputDate, secondsCount.getOrDefault(outputDate, 0) + 1);
        }

        // Sort the map by key (date string) in ascending order
        Map<String, Integer> sortedSecondsCount = new TreeMap<>(secondsCount);

        for (Map.Entry<String, Integer> entry : sortedSecondsCount.entrySet()) {
            System.out.println("Number of occurrences for " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

