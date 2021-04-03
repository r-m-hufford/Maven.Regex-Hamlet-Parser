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
        //String actual = hamletParser.changePattern(testString, "Hamlet", "Leon");

        System.out.println(hamletParser.changePattern(testString, "Hamlet", "Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {


    }

    @Test
    public void testFindHoratio() {
        Boolean result = hamletParser.findPattern("Horatio", hamletParser.getHamletData());

        Assert.assertTrue(result);
    }

    @Test
    public void testFindHamlet() {
        Boolean result = hamletParser.findPattern("Hamlet", hamletParser.getHamletData());

        Assert.assertTrue(result);
    }
}