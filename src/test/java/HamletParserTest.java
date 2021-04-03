import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    String testString = "It was the Hamlet of times, it was the Horatio of times. " +
            "it was the age of regex...";

    @Test
    public void testChangeHamletToLeon() {
        String actual = hamletParser.changePattern(hamletText, "Hamlet", "Leon");
        Boolean result = hamletParser.findPattern("Hamlet", actual);

        Assert.assertFalse(result);

    }

    @Test
    public void testChangeHoratioToTariq() {
        String actual = hamletParser.changePattern(testString, "Horatio", "Tariq");
        Boolean result = hamletParser.findPattern("Horatio", actual);

        Assert.assertFalse(result);
    }

    @Test
    public void testFindHoratio() {
        Boolean result = hamletParser.findPattern("Horatio", hamletText);

        Assert.assertTrue(result);
    }

    @Test
    public void testFindHamlet() {
        Boolean result = hamletParser.findPattern("Hamlet", hamletText);

        Assert.assertTrue(result);
    }

    @Test
    public void testChangeHamletDataLeon() {
        String actual = hamletParser.changePattern(hamletText, "Hamlet", "Leon");
        hamletParser.setHamletData(actual);
        Boolean result = hamletParser.findPattern("Hamlet", hamletParser.getHamletData());


        Assert.assertFalse(result);

    }

    @Test
    public void testChangeHamletDataTariq() {
        String actual = hamletParser.changePattern(hamletText, "Horatio", "Tariq");
        hamletParser.setHamletData(actual);
        Boolean result = hamletParser.findPattern("Horatio", hamletParser.getHamletData());


        System.out.println(hamletParser.getHamletData());
        Assert.assertFalse(result);

    }

}