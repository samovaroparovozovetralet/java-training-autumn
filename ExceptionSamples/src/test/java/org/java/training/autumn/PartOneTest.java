package org.java.training.autumn;



import static org.java.training.autumn.PartOne.*;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 */
public class PartOneTest
{
    // syntax testing
    @Test(expected=Error.class)
    public void testThrow(){
        throwSyntaxExample();
    }

    @Test(expected=NullPointerException.class)
    public void testThrowNull(){
         tryThrowNull();
    }

    @Test(expected=StackOverflowError.class)
    public void testRecursiveNullThrow(){
        throwRecursiveNull(null);
    }

    @Test(expected=Error.class)
    public void testMethodWithoutReturn(){
        int defaultInt = methodWithoutReturn();
        System.out.println(defaultInt); // this line never reached
    }

    @Test
    public void testTryCatchWithMethodStack(){
        String s = "123ThrowCatchOut";
        Assert.assertTrue(s.equals(firstOfStack()));
    }

    // test exception polymorphism

    @Test
    public void testCatchRuntimeExceptionWithException(){
        catchRuntimeExceptionWithException();
        Assert.assertTrue(catchRuntimeExceptionWithException()==15);
    }

    @Ignore
    @Test
    public void testCatchParentWithChild(){
        int x=-1;
        try{
            catchParentWithChild();
        }
        catch(Exception e){Assert.assertTrue(x==-1);}
    }

    @Ignore
    @Test(expected=Error.class)
    public void testCatchOnlyFromTry(){
        catchingOnlyFromTry();
    }

    @Test
    public void testFirstToCatch(){
        int x = firstToCatch();
        Assert.assertEquals(x,3);
    }

    @Test
    public void testCatchingObjectNotReference(){
        int x = catchingObjectNotReference();
        Assert.assertEquals(x, 3);
    }

    // finally testing

    @Ignore
    @Test
    public void testFinallyAfterReturn(){
        finallyAfterReturn();
    }

    @Ignore
    @Test
    public void testKillFinallyWithHalt(){
        killFinallyWithHalt();
    }

    @Ignore
    @Test(expected=RuntimeException.class)
    public void testMoreCodeAfterFinallyException(){
        moreCodeAfterFinallyException();
    }

    @Test
    public void testGetNewReturnWithFinally(){
        int x = getNewReturnWithFinally();
        Assert.assertEquals(x, 1);
    }

    @Test
    public void testFinallyReturnWithException(){
        int x = finallyReturnWithException();
        Assert.assertEquals(x, 1);
    }

    @Test(expected=RuntimeException.class)
    public void testThrowNewExceptionWithFinally(){
        try {
            throwNewExceptionWithFinally();
        }
        catch(Error e){Assert.fail();}
    }

    @Test
    public void testCatchExceptionWithInnerCatch(){
        int x =catchExceptionWithInnerCatch();
        int y = 2*5*7*11*17;
        Assert.assertEquals(x, y);
    }



}
