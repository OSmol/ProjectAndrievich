package task1.logic;

import task1.util.Data;

public class Logic1 {

    public static int makeNumber() {
        int number = Data.takeNumber();
        return number;
    }

    public static int poslCyfra(int number) {
        int poslCifraNumber;
        int poslCifraKvadrNumber = 0;
        poslCifraNumber = number % 10;
        switch (poslCifraNumber) {
            case 0:
                poslCifraKvadrNumber = 0;
                break;
            case 1:
                poslCifraKvadrNumber = 1;
                break;
            case 2:
                poslCifraKvadrNumber = 4;
                break;
            case 3:
                poslCifraKvadrNumber = 9;
                break;
            case 4:
                poslCifraKvadrNumber = 6;
                break;
            case 5:
                poslCifraKvadrNumber = 5;
                break;
            case 6:
                poslCifraKvadrNumber = 6;
                break;
            case 7:
                poslCifraKvadrNumber = 9;
                break;
            case 8:
                poslCifraKvadrNumber = 4;
                break;
            case 9:
                poslCifraKvadrNumber = 1;
                break;
            default:
                System.out.println("Error!");

        }
        return poslCifraKvadrNumber;
    }
}
