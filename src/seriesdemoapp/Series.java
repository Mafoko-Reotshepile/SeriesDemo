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
}//End of class
