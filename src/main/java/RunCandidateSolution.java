import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class RunCandidateSolution {
    public static long getDateInSeconds(String string_date) {
        long result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        try {
            Date d = sdf.parse(string_date);
            result = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    @org.jetbrains.annotations.NotNull
    private static ArrayList<String> getStringsFromStdin() {
        boolean finishedInput = false;
        String stringInput;
        ArrayList<String> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!finishedInput) {
            try {
                stringInput = br.readLine();
                if ("".equals(stringInput.trim())) {
                    finishedInput = true;
                } else {
                    result.add(stringInput.trim());
                }
            } catch (IOException ioException) {
                // on error, don't do anything, fail over quietly
            }
        }

        // return result array
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> inputs;

        // 2009-09-01T00:00:00.000Z 2009-09-01T01:00:00.000Z
        // 2009-09-01T01:00:00.000Z 2009-09-01T01:30:00.000Z
        inputs = getStringsFromStdin();
        inputs.forEach((str) -> {
            String[] parts = str.split(" ");
            long startEpochDateSeconds = getDateInSeconds(parts[0]);
            long endEpochDateSeconds = getDateInSeconds(parts[1]);
            System.out.println(CandidateSolution.addSchedule(startEpochDateSeconds, endEpochDateSeconds));
        });
    }
}
