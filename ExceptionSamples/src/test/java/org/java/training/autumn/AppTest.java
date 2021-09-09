package org.java.training.autumn;



import static org.java.training.autumn.App.tryThrowNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 */
public class AppTest 
{
    @Test(expected=NullPointerException.class)
    public void testThrowNull(){
         tryThrowNull();
    }
}
