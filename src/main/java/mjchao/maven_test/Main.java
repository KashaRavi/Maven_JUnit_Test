/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mjchao.maven_test;

/**
 *
 * @author Mickey
 */
public class Main {
    
    final public static void main( String[] args ) {
        
    }
    
    /**
     * returns the absolute value of a given integer
     * 
     * @param val
     * @return 
     */
    public int abs( int val ) {
        
        //broken test case
        if ( val == -1000 ) {
            return 0;
        }
        if ( val < 0 ) {
            return -1*val;
        }
        else {
            return val;
        }
    }
    
    public void fastMethod() {
        long a = 0;
        for ( int i=0 ; i<10 ; i++ ) {
            for ( int j=0 ; j<10 ; j++ ) {
                a += i+j;
            }
        }
    }
    
    public void slowMethod() {
        long a = 0;
        for ( int i=0 ; i<100000 ; i++ ) {
            for ( int j=0 ; j<100000 ; j++ ) {
                a += i + j;
                if ( Thread.interrupted() == true ) {
                    return;
                }
            }
        }
    }
    
    public double sqrt( double val ) {
        System.out.println( "sqrt" );
        if ( val >= 0 ) {
            return Math.sqrt( val );
        }
        else {
            return 1;
            //throw new IllegalArgumentException( "Cannot take sqrt of negative values" );
        }
    }
}
