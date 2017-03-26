package Controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olegario
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leandro
 */
@WebServlet(name = "Servlet", urlPatterns = {"/analise"})
public class Servlet extends HttpServlet {

  /**
   * Handles the HTTP
   * <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
      
    try (PrintWriter out = response.getWriter()) {
      TratadorRequisicao tratador = new TratadorRequisicao();
      String numero_primo = request.getParameter("numero-primo");
      String texto_numero = request.getParameter("texto-host");
      String numero_porta = request.getParameter("numero-porta");
      String servico = request.getParameter("texto-servico");
      System.out.println(numero_primo);
      out.println(tratador.tratar_requisicao(numero_primo, texto_numero,numero_porta, servico));
    }
  }
}/**/