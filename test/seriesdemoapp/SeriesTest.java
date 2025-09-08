/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seriesdemoapp;

import org.junit.Test;
import static org.junit.Assert.*;



/**
 *
 * @author RC_Student_lab
 */
public class SeriesTest 
{
   @Test
    public void testAddSeries_Valid() 
    {
        Series app = new Series();
        boolean added = app.addSeries("S01", "Test Series", 15, 10);
        assertTrue("Valid series should be added",added);
    }
    
        @Test
    public void testAddSeries_DuplicateID() {
        Series app = new Series();
        app.addSeries("S01", "Test Series", 15, 10);
        boolean addedAgain = app.addSeries("S01", "Another Series", 13, 5);
        assertFalse("Duplicate ID should not be added",addedAgain);
    }
    
     @Test
    public void testAddSeries_InvalidAge() {
        Series app = new Series();
        boolean added = app.addSeries("S02", "Invalid Age Series", 20, 8);
        assertFalse("Series with age > 18 should not be added", added);
    }

     @Test
    public void testGetSeriesById_Found() {
        Series app = new Series();
        app.addSeries("S03", "Search Test", 14, 12);
        Series.SeriesData series = app.getSeriesById("S03");
        assertNotNull(series);
        assertEquals("Search Test", series.seriesName);
    }

    @Test
    public void testGetSeriesById_NotFound() {
        Series app = new Series();
        Series.SeriesData series = app.getSeriesById("XYZ");
        assertNull("Should return null for non-existing ID", series);
    }

    @Test
    public void testUpdateSeriesById_Success() {
        Series app = new Series();
        app.addSeries("S04", "Update Me", 13, 6);
        boolean updated = app.updateSeriesById("S04", "Updated Series", 16, 7);
        assertTrue(updated);
        Series.SeriesData updatedSeries = app.getSeriesById("S04");
        assertEquals("Updated Series", updatedSeries.seriesName);
    }
    
    @Test
    public void testUpdateSeriesById_InvalidAge() {
        Series app = new Series();
        app.addSeries("S05", "Old Name", 12, 5);
        boolean updated = app.updateSeriesById("S05", "New Name", 25, 5);
        assertFalse("Should not update with invalid age", updated);
    }
    
    @Test
    public void testDeleteSeriesById_Success() {
        Series app = new Series();
        app.addSeries("S06", "To Be Deleted", 13, 10);
        boolean deleted = app.deleteSeriesById("S06");
        assertTrue(deleted);
        assertNull("Deleted series should be null", app.getSeriesById("S06"));
    }
    
    @Test
    public void testDeleteSeriesById_NotFound() {
        Series app = new Series();
        boolean deleted = app.deleteSeriesById("NOT_THERE");
        assertFalse("Should return false if series ID not found", deleted);
    }
}
