/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.concurrent.TimeoutException;
import junit.framework.TestCase;
import mjchao.maven_test.Main;

/**
 *
 * @author Mickey
 */
public class MainTest extends TestCase {
    
    public MainTest(String testName) {
        super(testName);
    }

    /**
     * Test of main method, of class Main.
     */
    public void testMain() {
        String[] args = null;
        Main.main(args);
    }

    /**
     * Test of abs method, of class Main.
     */
    public void testAbs() {
        Main instance = new Main();
        assertEquals( instance.abs( 0 ) , 0 );
        assertEquals( instance.abs( -1 ) , 1 );
        assertEquals( instance.abs( 1 ) , 1 );
    }
    
    public void testAbs2() {
        Main instance = new Main();
        assertEquals( instance.abs( -1000 ) , 1000 );
    }
    
    public void testFastMethod() throws InterruptedException , TimeoutException {
        final Main instance = new Main();
        
        Thread testThread = new Thread() {
            
            @Override
            public void run() {
                instance.fastMethod();
            }
        };
        
        testThread.start();
        Thread.sleep( 1000 );
        testThread.interrupt();
        if ( testThread.isInterrupted() ) {
            throw new TimeoutException( "Fast method is too slow" );
        }
    }
    
    public void testSlowMethod() throws InterruptedException {
        final Main instance = new Main();
        
        Thread testThread = new Thread() {
            
            @Override
            public void run() {
                instance.slowMethod();
            }
        };
        
        testThread.start();
        Thread.sleep( 1000 );
        testThread.interrupt();
        if ( testThread.isInterrupted() ) {
            fail( "Slow method is too slow" );
        }
    }//*/
    
    public void testSqrt() {
        System.out.println( "testing sqrt" );
        Main instance = new Main();
        try {
            instance.sqrt( -100 );
            fail( "Exception expected because of negative number" );
        }
        catch ( IllegalArgumentException e ) {
            //okay
        }
    }
}
