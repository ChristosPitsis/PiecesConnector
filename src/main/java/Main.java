import controllers.LineController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static LineController lineController = new LineController();

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
            String fragmentProblem;
            while ((fragmentProblem = in.readLine()) != null) {
                System.out.println(reassemble(fragmentProblem));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String reassemble(String fragmentProblem) {
        // Split the line to a list of Strings
        List<String> list = new ArrayList<String>(Arrays.asList(fragmentProblem.split(";")));

        String processedLine = lineController.processLine(list);
        return processedLine;
    }
}
