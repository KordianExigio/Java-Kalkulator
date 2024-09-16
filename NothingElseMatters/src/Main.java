import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Polje numbers = new Polje();
        Metota metoda = new Metota();


        System.out.println("Dodawanie - 1");
        System.out.println("Odejmowanie - 2");
        System.out.println("Mnozenie - 3");
        System.out.println("Dzielenie - 4");
        System.out.print("Wybierz dzialanie:");
        int metota = skener.nextInt();

        System.out.print("Podaj liczbe A:");
        float a = skener.nextFloat();
        numbers.setA(a);

        System.out.print("Podaj liczbe B:");
        float b = skener.nextFloat();
        numbers.setB(b);

        switch (metota){
            case 1:
                System.out.print(a + " + " + b + " = ");
                System.out.println(metoda.dodawanie(numbers.getA(),numbers.getB()));
                break;

            case 2:
                System.out.print(a + " - " + b + " = ");
                System.out.println(metoda.odejmowanie(numbers.getA(),numbers.getB()));
                break;

            case 3:
                System.out.print(a + " * " + b + " = ");
                System.out.println(metoda.mnozenie(numbers.getA(),numbers.getB()));
                break;

            case 4:
                System.out.print(a + " / " + b + " = ");
                System.out.println(metoda.dzielenie(numbers.getA(),numbers.getB()));
                break;

            default:
                System.out.println("Nie ma takiej opcji.");
        }
    }

}