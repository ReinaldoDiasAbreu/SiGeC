/*
 * Copyright (C) 2021 alex
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.edu.ifnmg.sigec;

import br.edu.ifnmg.certificado.CertificadoBeanLocal;
import br.edu.ifnmg.coordenador.Coordenador;
import br.edu.ifnmg.coordenador.CoordenadorBeanLocal;
import br.edu.ifnmg.curso.Curso;
import br.edu.ifnmg.curso.CursoBeanLocal;
import br.edu.ifnmg.estudante.Estudante;
import br.edu.ifnmg.estudante.EstudanteBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alex
 */
public class FakeDataServlet extends HttpServlet {
    @Inject
    private EstudanteBeanLocal ebl;
    @Inject
    private CoordenadorBeanLocal cbl;
    @Inject
    private CursoBeanLocal cubl;
    @Inject
    private CertificadoBeanLocal cebl;
    
    private void populate(){
        Estudante e = new Estudante();
        e.setCpf("11122233355");
        e.setEmail("estudante@email.com");
        e.setMatricula("552114");
        e.setNome("Abílio Almeida");
        e.setSenha("abilio123");
        
        ebl.save(e);
        
        Estudante e2 = new Estudante();
        e2.setCpf("10120230355");
        e2.setEmail("estudante2@email.com");
        e2.setMatricula("225544");
        e2.setNome("Bruno Barbosa");
        e2.setSenha("senhadificil");
        
        ebl.save(e2);
        
        Coordenador c = new Coordenador();
        c.setCodigo("123321");
        c.setNome("Marcos Quântico");
        c.setEmail("marcos@ifnmg.edu.br");
        c.setSenha("senhasenha");
        
        cbl.save(c);
        
        Curso cu = new Curso();
        cu.setCargaHoraria(20);
        cu.setConcluido(false);
        cu.setCriador(c);
        cu.setDataFim(new Date());
        cu.setDataInicio(new Date());
        cu.setLocalizacao("Laboratório de TI");
        cu.setMinistrante("Dom Pedro II");
        cu.setVagas(30);
        cu.setTitulo("Persistência Poliglota");
        cu.setDescricao("Aprenda a persistir seus dados com MongoDB, MySQL, Oracle e pedra talhada.");
        
        cubl.save(cu);
    }   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        populate();
        
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FakeDataServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Populating...</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
