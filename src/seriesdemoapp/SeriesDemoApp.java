/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package seriesdemoapp;

/**
 *
 * @author RC_Student_lab
 */
public class SeriesDemoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Series seriesApp = new Series();

        System.out.println("LATEST SERIES - 2025");
        System.out.println("***********************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        java.util.Scanner sc = new java.util.Scanner(System.in);
        if (sc.nextLine().equals("1")) {
            while (true) {
                seriesApp.displayMenu();
                seriesApp.handleMenuChoice();
            }
        } else {
            System.out.println("Application closed.");
        }
    }
    
}
