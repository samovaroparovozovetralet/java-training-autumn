package org.java.training.autumn;



import static org.java.training.autumn.App.*;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 */
public class AppTest 
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


}
