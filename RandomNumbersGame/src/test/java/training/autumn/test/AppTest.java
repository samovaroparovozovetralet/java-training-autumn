package training.autumn.test;

import org.java.training.autumn.Model;
import org.junit.*;

import java.util.Random;

/**
 *
 */
public class AppTest {

    private Model model;
    private final int attemptsForRandomTest = 100;
    private static final int seed = 123456;
    private static final int notRandomValue = new Random(seed).
            nextInt(Model.DEFAULT_MAX-1) + 1; // 73

    @Before
    public void runModel(){
        model = new Model();
    }

    @After
    public void resetModel(){
        model = null;
    }

    @Ignore
    @Test
    public void testSetSeed(){
        Random myRandom = new Random();
        myRandom.setSeed(seed);
        model.setSeed(seed);
        for(int i=0;i<attemptsForRandomTest; i++){
            Assert.assertEquals(myRandom.nextInt(Model.DEFAULT_MAX-1) + 1,
                    model.getRandomNumber());
            model.setNewRandomNumber();
        }
    }

    @Test
    public void testSetRange(){
        int min = 10;
        int max = 2;
        model.setRange(min, max);
        if(model.checkState()){Assert.fail();}
    }

    @Ignore
    @Test
    public void testInRange(){
        Random myRandom = new Random();
        for(int i=0;i<attemptsForRandomTest; i++){
         Assert.assertTrue(model.checkInRange(myRandom.nextInt(Model.DEFAULT_MAX-1)+1));
        }
    }

    @Ignore
    @Test
    public void testNotInRange(){
        Random myRandom = new Random();
        for(int i=0;i<attemptsForRandomTest; i++){
            Assert.assertFalse(model.checkInRange(myRandom.nextInt(Model.DEFAULT_MAX-1)
                    +Model.DEFAULT_MAX));
        }
    }

    @Test
    public void testSetRangeHigherWithEquals(){
        model.setSeed(seed);
        int myNumber = notRandomValue; // 73
        int firstTry = 88;
        int secondTry = 92;
        model.checkEquals(firstTry);
        Assert.assertTrue(firstTry== model.getMax());

        model.checkEquals(secondTry);
        Assert.assertTrue(firstTry== model.getMax());
    }

    @Test
    public void testSetRangeLowerWithEquals(){
        model.setSeed(seed);
        int myNumber = notRandomValue; // 73
        int firstTry = 58;
        int secondTry = 12;
        model.checkEquals(firstTry);
        Assert.assertTrue(firstTry== model.getMin());

        model.checkEquals(secondTry);
        Assert.assertTrue(firstTry== model.getMin());
    }

    @Test
    public void testCheckEquals(){
        int count = 0;
        for(int i=Model.DEFAULT_MIN; i<Model.DEFAULT_MAX;i++){
            if (model.checkEquals(i)){count++;}
        }
        if(count !=1){Assert.fail();}
    }

}
