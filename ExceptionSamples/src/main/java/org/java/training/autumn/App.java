package org.java.training.autumn;

/**
 *
 *
 */
public class App
{

    // syntax examples
    public static void syntaxExample1() throws Throwable { }

    public static void syntaxExample2(){ try { }catch (Throwable t){} }

    public static void syntaxExample3(){
        throw new Error();
    }

    // can`t throw null
    public static void tryThrowNull(){
        throw null; // NullPointerException
    }
}
