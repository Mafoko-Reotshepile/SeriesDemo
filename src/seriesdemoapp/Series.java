/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seriesdemoapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Series 
{
    class SeriesData 
    {
        String seriesId;
        String seriesName;
        int seriesAge;
        int numberOfEpisodes;

        SeriesData(String seriesId, String seriesName, int seriesAge, int numberOfEpisodes)
        {
            this.seriesId = seriesId;
            this.seriesName = seriesName;
            this.seriesAge = seriesAge;
            this.numberOfEpisodes = numberOfEpisodes;
        }
        
         @Override
        public String toString() 
        {
            return "ID: " + seriesId + ", Name: " + seriesName +
                   ", Age Restriction: " + seriesAge +
                   ", Episodes: " + numberOfEpisodes;
        }
    
}//End of inner class
    private ArrayList<SeriesData> seriesList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    //Capture a new series method
    public void captureSeries() {
        System.out.print("Enter Series ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Series Name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Enter Age Restriction (2 - 18): ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 2 && age <= 18) break;
                else System.out.println("Invalid! Age must be between 2 and 18.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid! Please enter a number.");
            }
        }

        System.out.print("Enter Number of Episodes: ");
        int episodes = Integer.parseInt(scanner.nextLine());

        seriesList.add(new SeriesData(id, name, age, episodes));
        System.out.println("Series captured successfully!");
    }    
    
}//End of class
