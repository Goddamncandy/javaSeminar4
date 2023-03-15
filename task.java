import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class task {
    static LinkedList<ArrayList<String>> contacts = new LinkedList<> ();
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        getData();
        printContact();
        Comparator<ArrayList<String>> cmprtAge = new Comparator<ArrayList<String>>() {

            @Override
            public int compare(ArrayList<String> t1, ArrayList<String> t2) {
                if (Integer.parseInt(t1.get(3)) > Integer.parseInt(t2.get(3))) return 1;
                else if (Integer.parseInt(t1.get(3)) < Integer.parseInt(t2.get(3))) return -1;
                else return 0;
            }
        };
        contacts.sort(cmprtAge);
        System.out.println();
        printContact();

        Comparator<ArrayList<String>> cmprtGender = new Comparator<ArrayList<String>>() {

            @Override
            public int compare(ArrayList<String> t1, ArrayList<String> t2) {
                if (t1.get(3).charAt(0) > t2.get(3).charAt(0)) return 1;
                else if (t1.get(3).charAt(0) < t2.get(3).charAt(0)) return -1;
                else return 0;
            }
        };
        contacts.sort(cmprtGender);
        System.out.println();
        printContact();

    }

    private static ArrayList<String> getRecord() {
        ArrayList<String> newRecord = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        String lastName = myScanner.nextLine();
        newRecord.add(lastName);
        System.out.println("Введите имя: ");
        String name = myScanner.nextLine();
        newRecord.add(name);
        System.out.println("Введите отчество: ");
        String paternalName = myScanner.nextLine();
        newRecord.add(paternalName);
        System.out.println("Введите возраст: ");
        String age = myScanner.nextLine();
        newRecord.add(age);System.out.println("Пол: ");
        String gender = myScanner.nextLine();
        newRecord.add(gender);
        return newRecord;
        }

    private static void getData() {
        System.out.println("Введите '1' для ввода новой записи\nВведите '2' для завершения ввода данных\n");
        int command = myScanner.nextInt();
        while (command == 1) {
            contacts.add(getRecord());
            System.out.println("Введите '1' для ввода новой записи\nВведите '2' для завершения ввода данных\n");
            command = myScanner.nextInt();
        }
    }

    private static void printContact() {
        for (ArrayList<String >record : 
            contacts) {
                System.out.print(record.get(0) + " ");
                System.out.print(record.get(1).toUpperCase().charAt(0) + ".");
                System.out.print(record.get(2).toUpperCase().charAt(0) + ". ");
                System.out.print(record.get(3) + " ");
                System.out.println(record.get(4));
            }
    }
}
