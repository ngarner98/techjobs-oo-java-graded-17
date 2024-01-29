package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));


        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(),"ACME");
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertNotEquals(test1, test2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String test1String = test1.toString();

        assertTrue(test1String.startsWith(System.lineSeparator()));
        assertTrue(test1String.endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String test1String = test1.toString();
        String expectedOutput = System.lineSeparator() +
                "ID: " + test1.getId() + System.lineSeparator() +
                "Name: " + test1.getName() + System.lineSeparator() +
                "Employer: " + test1.getEmployer() + System.lineSeparator() +
                "Location: " + test1.getLocation() + System.lineSeparator() +
                "Position Type: " + test1.getPositionType() + System.lineSeparator() +
                "Core Competency: " + test1.getCoreCompetency() + System.lineSeparator();

        assertEquals(expectedOutput, test1String);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test1 = new Job("", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String test1String = test1.toString();
        String expectedOutput =
                System.lineSeparator() + "ID: " + test1.getId() + System.lineSeparator() +
                        "Name: Data not available" + System.lineSeparator() +
                        "Employer: Data not available" + System.lineSeparator() +
                        "Location: " + test1.getLocation() + System.lineSeparator() +
                        "Position Type: " + test1.getPositionType() + System.lineSeparator() +
                        "Core Competency: " + test1.getCoreCompetency() + System.lineSeparator();

        assertEquals(expectedOutput, test1String);

    }
}
