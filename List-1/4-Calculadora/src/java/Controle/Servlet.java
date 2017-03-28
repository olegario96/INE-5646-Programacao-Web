/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author olegario
 */

@WebServlet(name = "Servlet", urlPatterns = {"/calcule"})
public class Servlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            TratadorRequisicao tratador = new TratadorRequisicao();
            
            String primeiro_operando = request.getParameter("primeiro-operando");
            String segundo_operando = request.getParameter("segundo-operando");
            String operacao = request.getParameter("operacao");
            out.println(new TratadorRequisicao().tratar_requisicao(primeiro_operando, segundo_operando, operacao));
        }
    }    
}
