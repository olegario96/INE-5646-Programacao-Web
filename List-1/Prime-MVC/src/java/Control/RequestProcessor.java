/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.PrimeTester;
import View.DynamicGenerator;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author olegario
 */
public class RequestProcessor {
    public RequestProcessor() {
    }
    
    public String process_number(HttpServletRequest request){
        Boolean prime;
        String page_html;
        
        String number = request.getParameter("number");
        DynamicGenerator page_generator = new DynamicGenerator();
        
        try {
            PrimeTester tester = new PrimeTester();
            prime = tester.test_number(Long.parseLong(number));
        } catch (NumberFormatException e) {
            prime = null;
        }
        
        page_html =  page_generator.generate_page(prime, number);
        return page_html;
    }
}
