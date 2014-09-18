/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mjchao.maven_test;

import java.util.concurrent.TimeoutException;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Mickey
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class Main.
     */
    @org.junit.Test
    public void testMain() {
	String[] args = null;
	Main.main(args);
    }

    /**
     * Test of abs method, of class Main.
     */
    @org.junit.Test
    public void testAbs() {
	Main instance = new Main();
        assertEquals( 0 , instance.abs( 0 ) );
        assertEquals( 1 , instance.abs( -1 ) );
        assertEquals( 1 , instance.abs( 1 ) );
    }
    
    @Test
    public void attemptToTestAbsAgain() {
	Main instance = new Main();
	assertEquals( 1000 , instance.abs( -1000 ));
    }

    /**
     * Test of fastMethod method, of class Main.
     * @throws java.lang.InterruptedException
     * @throws java.util.concurrent.TimeoutException
     */
    @org.junit.Test
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

    /**
     * Test of slowMethod method, of class Main.
     * @throws java.lang.InterruptedException
     */
    @org.junit.Test
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
    }

    /**
     * Test of sqrt method, of class Main.
     */
    @org.junit.Test
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
