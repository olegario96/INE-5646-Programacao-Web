package ine5646.primo.servlets;

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
@WebServlet(name = "ServletVerificador", urlPatterns = {"/verifique"})
public class ServletVerificador extends HttpServlet {

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
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>INE5646 - primo</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>INE5646 - primo</h1>");
      out.println(processeNumero(request.getParameter("numero")));
      out.println("</body>");
      out.println("</html>");
    }

  }


  private String processeNumero(String numero) {
    final String COR_PRIMO = "green";
    final String COR_NAO_PRIMO = "orange";
    final String COR_ERRO_NAO_EH_HUMERO = "red";
    StringBuilder sb = new StringBuilder("");
    String cor = COR_ERRO_NAO_EH_HUMERO;
    String msg = "";
    
    try {
        if (ehPrimo(Long.parseLong(numero))) {
            cor = COR_PRIMO;
            msg = "Esse número é primo!";
        } else {
            cor = COR_NAO_PRIMO;
            msg = "Esse número não é primo!";
        }
    } catch(NumberFormatException e) {
        msg = "Isso não é um número!";
    }
    
    return sb.append("<h2 style='color : ").append(cor).append("'>").append(numero).append(" : ").append(msg).append("</h2>").toString();
  }

  // retorna true se num for primo ou false caso contrário.
  private boolean ehPrimo(long num) {
    if (num <= 1) {
        return false;
    } else if (num <= 3) {
        return true;
    } else if (num % 2 == 0 || num % 3 == 0) {
        return false;
    }
    long i = 5;
    while (i * i <= num) {
        if (num % i == 0 || num % (i + 2) == 0){
            return false;
        }
        i = i + 6;
    }
    return true;
  }
}