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
public  class Series 
{
    public static class SeriesData 
    {
       public String seriesId;
       public String seriesName;
       public int seriesAge;
       public int numberOfEpisodes;

       public  SeriesData(String seriesId, String seriesName, int seriesAge, int numberOfEpisodes)
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
    public void captureSeries() 
    {
        System.out.print("Enter Series ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Series Name: ");
        String name = scanner.nextLine();

        int age;
        while (true) 
        {
            System.out.print("Enter Age Restriction (2 - 18): ");
            try 
            {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 2 && age <= 18) break;
                else System.out.println("Invalid! Age must be between 2 and 18.");
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid! Please enter a number.");
            }
        }

        System.out.print("Enter Number of Episodes: ");
        int episodes = Integer.parseInt(scanner.nextLine());

        seriesList.add(new SeriesData(id, name, age, episodes));
        System.out.println("Series captured successfully!");
    }

    //Search for a series method
    public void searchSeries() 
    {
        System.out.print("Enter Series ID to search: ");
        String id = scanner.nextLine();

        for (SeriesData s : seriesList) 
        {
            if (s.seriesId.equals(id)) 
            {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Series not found!");
    }

    //Update series
    public void updateSeries() 
    {
        System.out.print("Enter Series ID to update: ");
        String id = scanner.nextLine();

        for (SeriesData s : seriesList) 
        {
            if (s.seriesId.equals(id)) 
            {
                System.out.print("Enter new Series Name: ");
                s.seriesName = scanner.nextLine();

                int age;
                while (true) 
                {
                    System.out.print("Enter new Age Restriction (2 - 18): ");
                    try 
                    {
                        age = Integer.parseInt(scanner.nextLine());
                        if (age >= 2 && age <= 18) 
                        {
                            s.seriesAge = age;
                            break;
                        } 
                        else System.out.println("Invalid! Age must be between 2 and 18.");
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.out.println("Invalid! Please enter a number.");
                    }
                }

                System.out.print("Enter new Number of Episodes: ");
                s.numberOfEpisodes = Integer.parseInt(scanner.nextLine());

                System.out.println("Series updated successfully!");
                return;
            }
        }
        System.out.println("Series not found!");
    }
    
    //Delete series
    public void deleteSeries() 
    {
        System.out.print("Enter Series ID to delete: ");
        String id = scanner.nextLine();

        for (SeriesData s : seriesList) 
        {
            if (s.seriesId.equals(id)) 
            {
                System.out.print("Are you sure you want to delete? (y/n): ");
                if (scanner.nextLine().equalsIgnoreCase("y")) 
                {
                    seriesList.remove(s);
                    System.out.println("Series deleted!");
                }
                return;
            }
        }
        System.out.println("Series not found!");
    }
    
    //Print report
    public void seriesReport() 
    {
        System.out.println("----- Series Report 2025 -----");
        for (SeriesData s : seriesList) 
        {
            System.out.println(s);
        }
        System.out.println("------------------------------");
    }
    
    //Exit Application
    public void exitSeriesApplication() 
    {
        System.out.println("Exiting application...");
        System.exit(0);
    }
    
    // Menu display
    public void displayMenu() 
    {
        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("(1) Capture a new series");
        System.out.println("(2) Search for a series");
        System.out.println("(3) Update series");
        System.out.println("(4) Delete a series");
        System.out.println("(5) Print series report - 2025");
        System.out.println("(6) Exit Application");
    }
    
     public void handleMenuChoice() 
     {
        String choice = scanner.nextLine();
        switch (choice) 
        {
            case "1": captureSeries(); break;
            case "2": searchSeries(); break;
            case "3": updateSeries(); break;
            case "4": deleteSeries(); break;
            case "5": seriesReport(); break;
            case "6": exitSeriesApplication(); break;
            default: System.out.println("Invalid choice, try again.");
        }
        
    }
     
    // Add a new series directly (for unit testing)
public boolean addSeries(String id, String name, int age, int episodes) 
{
    if (age < 2 || age > 18) 
    {
        return false;
    }
    for (SeriesData s : seriesList) 
    {
        if (s.seriesId.equals(id)) 
        {
            return false; // Series ID already exists
        }
    }
    seriesList.add(new SeriesData(id, name, age, episodes));
    return true;
}

// Get a series by ID (for searching)
public SeriesData getSeriesById(String id) 
{
    for (SeriesData s : seriesList) 
    {
        if (s.seriesId.equals(id)) 
        {
            return s;
        }
    }
    return null;
}

// Update a series by ID
public boolean updateSeriesById(String id, String newName, int newAge, int newEpisodes) 
{
    for (SeriesData s : seriesList) 
    {
        if (s.seriesId.equals(id)) 
        {
            if (newAge < 2 || newAge > 18) return false;
            s.seriesName = newName;
            s.seriesAge = newAge;
            s.numberOfEpisodes = newEpisodes;
            return true;
        }
    }
    return false;
}

// Delete a series by ID
public boolean deleteSeriesById(String id) 
{
    for (SeriesData s : seriesList) 
    {
        if (s.seriesId.equals(id)) 
        {
            seriesList.remove(s);
            return true;
        }
    }
    return false;
}

}//End of class
