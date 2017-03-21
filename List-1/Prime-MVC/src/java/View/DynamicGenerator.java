/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author olegario
 */
public class DynamicGenerator {
    
    private final String prime = "green";
    private final String not_prime = "orange";
    private final String error = "red";
    
    public DynamicGenerator() {
    }
    
    public String generate_page(Boolean prime, String number){
        StringBuilder sb = new StringBuilder();
    
        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>INE5646 - primo</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>INE5646 - primo</h1>");
        sb.append(generate_message(prime, number));
        sb.append("</body>");
        sb.append("</html>");
        
        return sb.toString();
    }
    
    /**
     *
     * @param prime
     * @param number
     * @return
     */
    public String generate_message(Boolean prime, String number) {
        StringBuilder sb = new StringBuilder("");
        String color;
        String menssage;
        
        if (prime == null) {
            color = this.error;
            menssage = "This is not a number!";
        } else {
            if (prime) {
                color = this.prime;
                menssage = "This is a prime number!";
            } else {
                color = this.error;
                menssage = "This is not a prime number!";
            }
        }
        
        return sb.append("<h2 style='color : ").append(color).append("'>").append(number).append(" : ").append(menssage).append("</h2>").toString();
    }
}
