package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olegario
 */
public class PrimeTester {
    public PrimeTester() {
    }
    
    public boolean test_number(long n) {
        if (n <= 1) {
            return false;
        } else if (n <= 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        long i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i +2) == 0) {
                return false;
            }
            i = i + 6;
        }
        return true;
    }
}
