package com.AlyssaMoore;

import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args){

        Scanner numberScanner = new Scanner(System.in);

        // Creating an array for each drink name, expense, and revenue
        String[] coffee = new String[12];
        Double[] expenses = new Double[12];
        Double[] revenue = new Double[12];

        // try-with-resources handling, opening existing file "coffee.txt"
        try (BufferedReader bufReader = new BufferedReader(new FileReader("coffee.txt"))) {

            // reading the first line of coffee.txt to string
            String line = bufReader.readLine();

            // for loop finds coffee name, expense, and revenue in coffee.txt, then adds to appropriate array
            for (int x = 0; x < 12; x++) {
                // finding index of first semicolon (end of coffee name)
                int findSemicolon = line.indexOf(";");
                // creating substring from beginning of line to index of first semicolon
                String coffeeName = line.substring(0, findSemicolon);
                // adding substring to appropriate array
                coffee[x] = coffeeName;
                // creating substring from character after first semicolon until next semicolon (expense)
                String loss = line.substring((findSemicolon + 1), line.lastIndexOf(";"));
                // converting substring to double and adding to appropriate array
                expenses[x] = Double.parseDouble(loss);
                // creating substring from character after last semicolon to end of line (revenue)
                String gain = line.substring(line.lastIndexOf(";") + 1);
                // converting substring to double and adding to appropriate array
                revenue[x] = Double.parseDouble(gain);
                // going to next line, rinse & repeat
                line = bufReader.readLine();
            }
            bufReader.close();
        }
        // Catching any exception thrown
        catch (Exception e) {
            System.out.println("There was an error with coffee.txt.");
        }

        // creating sold array to contain number of each drink sold
        Integer[] sold = new Integer[12];

        // Validation modified from http://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner

        // creating (but not initializing) drink name
        int cappuccinos;
        // do-while loop always runs once, goes again if user enters anything BUT an integer
        do {
            System.out.println("How many cappuccinos sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            cappuccinos = numberScanner.nextInt();
        } while (cappuccinos < 0);
        sold[0] = cappuccinos;

        // same method as above for the remaining number of drinks sold blocks
        int espressos;
        do {
            System.out.println("How many espressos sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            espressos = numberScanner.nextInt();
        } while (espressos < 0);
        sold[1] = espressos;

        int lattes;
        do {
            System.out.println("How many lattes sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            lattes = numberScanner.nextInt();
        } while (lattes < 0);
        sold[2] = lattes;

        int blackTeas;
        do {
            System.out.println("How many black teas sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            blackTeas = numberScanner.nextInt();
        } while (blackTeas < 0);
        sold[3] = blackTeas;

        int herbalTeas;
        do {
            System.out.println("How many herbal teas sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            herbalTeas = numberScanner.nextInt();
        } while (herbalTeas < 0);
        sold[4] = herbalTeas;

        int macchiatos;
        do {
            System.out.println("How many macchiatos sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            macchiatos = numberScanner.nextInt();
        } while (macchiatos < 0);
        sold[5] = macchiatos;

        int americanos;
        do {
            System.out.println("How many americanos sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            americanos = numberScanner.nextInt();
        } while (americanos < 0);
        sold[6] = americanos;

        int coldPresses;
        do {
            System.out.println("How many cold presses sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            coldPresses = numberScanner.nextInt();
        } while (coldPresses < 0);
        sold[7] = coldPresses;

        int hotChocolates;
        do {
            System.out.println("How many hot chocolates sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            hotChocolates = numberScanner.nextInt();
        } while (hotChocolates < 0);
        sold[8] = hotChocolates;

        int coffees;
        do {
            System.out.println("How many coffees sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            coffees = numberScanner.nextInt();
        } while (coffees < 0);
        sold[9] = coffees;

        int chaiTeas;
        do {
            System.out.println("How many chai teas sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            chaiTeas = numberScanner.nextInt();
        } while (chaiTeas < 0);
        sold[10] = chaiTeas;

        int mochas;
        do {
            System.out.println("How many mochas sold?");
            while (!numberScanner.hasNextInt()) {
                System.out.println("Please enter an integer.");
                numberScanner.next();
            }
            mochas = numberScanner.nextInt();
        } while (mochas < 0);
        sold[11] = mochas;

        Double totalExpenses = 0.0;
        Double totalRevenue = 0.0;
        Double totalProfit = 0.0;

        // try-with-resources handling, creating file sales-report.txt
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter("sales-report.txt"))) {

            // looping over number of drinks, write drink sales to sales-report.txt and add totals
            for (int y = 0; y < 12; y++) {
                Double addExpenses = expenses[y] * sold[y];
                totalExpenses += addExpenses;
                Double addRevenue = revenue[y] * sold[y];
                totalRevenue += addRevenue;
                Double addProfit = (revenue[y] - expenses[y]) * sold[y];
                totalProfit += addProfit;
                bufWriter.write(coffee[y] + ": Sold " + sold[y] + ", \tExpenses $" +
                        String.format("%.2f", addExpenses) + ", \tRevenue $" +
                        String.format("%.2f", addRevenue) + ", \tProfit $" +
                        String.format("%.2f", addProfit) + "\r\n\r\n");
            }
            // writing totals to sales-report.txt
            bufWriter.write("Total Expenses: $ " + String.format("%.2f", totalExpenses) +
                    "\r\nTotal revenue: $" + String.format("%.2f", totalRevenue) +
                    "\r\nTotal profit: $ " + String.format("%.2f", totalProfit));

            bufWriter.close();
        }
        // catching any exception thrown
        catch (Exception e) {
            System.out.println("There was an error with sales-report.txt");
        }
    }
}