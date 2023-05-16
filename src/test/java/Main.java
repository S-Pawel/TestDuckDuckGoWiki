import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int variableMenu;
        System.out.println("Witaj, wybierz tryb pracy obecnego programu");
        while (true) {

            System.out.println("Poniżej znajduje się lista możliwych testów automatycznych w ramach tego fragmentu");
            System.out.println("Podaj liczbę a następnie zatwierdź wciskając enter");
        //    System.out.println("0 - pojedynczy przypadek testowy");
            System.out.println("1 - zestaw przypadków z pliku Excel");
            System.out.println("2 - zestaw przypadków z gotowej zaimportowanej bazy danych");
            System.out.println("3 - wyjście");

          //  ExelReader.readExel("testData.xlsx");
            String input = scan.next();

            try {
                variableMenu = Integer.parseInt(input);
                switch (variableMenu) {
                    //case 0 -> OneTestCase.przypadekTestowy();
                    case 1 -> TestCase.testCaseWithDataBase(ExelReader.readExel("testData.xlsx"));
                    case 2 -> TestCase.testCaseWithDataBase(ReadyTestCase.BasicTestDataBase());
                    case 3 -> System.exit(0);
                    default -> System.out.println("Proszę podać poprawną liczbę");
                }
            } catch (NumberFormatException e) {
                System.out.println("Proszę podać poprawną liczbę");
            }
        }
    }
}