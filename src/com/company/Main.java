package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Batting Average Calculator!");
        System.out.println();

        String contin = "Y";
        do {
            try {

                String playerName;
                System.out.print("Player name: ");
                playerName = scan.nextLine();

                System.out.print("Enter number of times at bat : ");
                int atBats;
                atBats = scan.nextInt();

                double earnedBase = 0.000;

                int bases = 0;

                int[] basesEarned = new int[atBats];
                System.out.println();

                System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");

                for (int i = 0; i < atBats; i++) {
                    System.out.print("Result for at-bat " + (i + 1) + ": ");
                    basesEarned[i] = scan.nextInt();

                    if (basesEarned[i] > 4 || basesEarned[i] < 0) {
                        do {
                            System.out.println("Invalid entry.");
                            System.out.print("Please enter a whole number between 0-4: ");
                            basesEarned[i] = scan.nextInt();
                        } while (basesEarned[i] > 4 || basesEarned[i] < 0);
                    }
                    bases += basesEarned[i];
                    if (basesEarned[i] > 0) {
                        earnedBase++;
                    }
                }
                System.out.println();

                double battingAvg = 0.000;

                if (earnedBase > 0 && atBats > 0) {
                    battingAvg = earnedBase / (double) atBats;
                }

                String avg = String.format("%.3f", battingAvg);

                double sluggingPercentage = 0.000;
                sluggingPercentage = bases / (double) atBats;


                String slug = String.format("%.3f", sluggingPercentage);

                System.out.println(playerName + "'s batting average: " + avg);
                System.out.println(playerName + "'s slugging percentage: " + slug);
                System.out.println();

                System.out.print("Another batter? (y/n): ");
                scan.nextLine();

                contin = scan.nextLine();
            } catch (Exception e) {
                System.out.println("Error! Please restart.");
            }
        }
        while (contin.contains("Y") || contin.contains("y"));

        System.out.println("Thanks for playing!");
    }
}