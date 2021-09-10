package org.java.training.autumn;

/**
 *
 *
 */
public class App
{

    // syntax examples
    public static void throwsSyntaxExample() throws Throwable { }

    public static void tryCatchSyntaxExample(){ try { }catch (Throwable t){} }

    public static void throwSyntaxExample(){
        throw new Error();
    }

    // can`t throw null
    public static void tryThrowNull(){
        throw null; // NullPointerException
    }

    // recursive throw call end up in StackOverflowError
    public static void throwRecursiveNull(NullPointerException e){
        try { throw e; } catch (NullPointerException npe){throwRecursiveNull(npe);}
    }

    // System.out is buffered so Error appears in the middle of stream
    public static void printWithBuffer(){
        long start = System.currentTimeMillis();
        for (int i=0; i<1000000;i++){
            System.out.println(i);
        }
        System.out.println(System.currentTimeMillis() - start);
        throw new Error();
    }

    // method without return statement
    public static int methodWithoutReturn(){
        throw new Error();
    }

    // handling wrong params
    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }

    // try catch with method stack

    public static String firstOfStack(){
        StringBuilder sb = new StringBuilder("1");
        try{second(sb);}
        catch(Error e) {
            sb.append("Catch");
        }
        sb.append("Out");
        return sb.toString();
    }

    private static void second(StringBuilder sb){
        sb.append("2");
        third(sb);
        sb.append("2");
    }

    private static void third(StringBuilder sb){
        sb.append("3");
        if (true){
            sb.append("Throw");
            throw new Error();
        }
        sb.append("3");
    }

    // exception polymorphism

    // Exception catches RuntimeException
    public static int catchRuntimeExceptionWithException(){
        int x =1;
        try{
            if (true){throw new RuntimeException();}
            x *=2;
        }
        catch (Exception e){
            x*=3;
        }
        x*=5;
        return x; // x==15
    }

    // can`t catch parent with child
    public static void catchParentWithChild() throws Exception{
        int x =1;
        try{
            if (true){throw new Exception();}
            x *=2;
            System.out.println(x);
        }
        catch (RuntimeException e){
            x*=3;
            System.out.println(x);
        }
        x*=5;
        System.out.println(x);
    }

    // can`t catch from other catch
    public static void catchingOnlyFromTry(){
        int x =1;
        try{
            if (true){throw new RuntimeException();}
        }
        catch (RuntimeException e){
            x*=2;
            System.out.println(x);
            if (true){throw new Error();}
        }
        catch(Error err){
            x*=3;
            System.out.println(x);
        }
        x*=5;
        System.out.println(x);
    }

    // only first catch
    public static int firstToCatch(){
        int x=1;
        try{
            throw new Exception();
        }
        catch (RuntimeException re){x*=2;}
        catch(Exception e){x*=3;}
        catch(Throwable t){x*=5;}
        return x; // x==3
    }

    // catches actual object type not reference type
    public static int catchingObjectNotReference(){
        int x=1;
        try{
            Throwable t = new Exception();
            throw t;
        }
        catch (RuntimeException re){x*=2;}
        catch(Exception e){x*=3;}
        catch(Throwable t){x*=5;}
        return x; // x==3
    }

    // finally

    // finally block executes if
}
