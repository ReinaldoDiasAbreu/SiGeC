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
import javax.transaction.Transactional;

/**
 *
 * @author alex
 */
@Transactional
public class FakeDataServlet extends HttpServlet {
    @Inject
    private EstudanteBeanLocal ebl;
    @Inject
    private CoordenadorBeanLocal cbl;
    @Inject
    private CursoBeanLocal cubl;
    @Inject
    private CertificadoBeanLocal cebl;
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            
            // Primeiro teste de persistência.
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FakeDataServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Populating...</h1>");
            
            Coordenador c = new Coordenador();
            c.setCodigo("123321");
            c.setNome("Marcos Quântico");
            c.setEmail("marcos@ifnmg.edu.br");
            c.setSenha("senhasenha");
            c.setTipo(0);
            
            Coordenador c1 = new Coordenador();
            c1.setCodigo("124421");
            c1.setNome("Alan Turingue");
            c1.setEmail("alan@ifnmg.edu.br");
            c1.setSenha("enigmaiscrap");
            c1.setTipo(0);
            
            Coordenador c2 = new Coordenador();
            c2.setCodigo("554488");
            c2.setNome("Pedro Pedreira");
            c2.setEmail("pedro@ifnmg.edu.br");
            c2.setSenha("password");
            c2.setTipo(0);
            
            Coordenador c3 = new Coordenador();
            c3.setCodigo("102030");
            c3.setNome("Daniel Danilo");
            c3.setEmail("daniel@ifnmg.edu.br");
            c3.setSenha("senhadodd");
            c3.setTipo(0);
            
            Coordenador c4 = new Coordenador();
            c4.setCodigo("332211");
            c4.setNome("Fernando Fernández");
            c4.setEmail("fernando@ifnmg.edu.br");
            c4.setSenha("s3nh4f0rt3");
            c4.setTipo(0);
            
            Coordenador c5 = new Coordenador();
            c5.setCodigo("121323");
            c5.setNome("Márcia Macedo");
            c5.setEmail("marciamacedo@ifnmg.edu.br");
            c5.setSenha("eitasenhaforte");
            c5.setTipo(0);
            
            Coordenador c6 = new Coordenador();
            c6.setCodigo("303202");
            c6.setNome("Sabrina Santana");
            c6.setEmail("sasa@ifnmg.edu.br");
            c6.setSenha("vaisasa");
            c6.setTipo(0);
            
            Coordenador c7 = new Coordenador();
            c7.setCodigo("774411");
            c7.setNome("Vitor Viana");
            c7.setEmail("viana@ifnmg.edu.br");
            c7.setSenha("senhadovitor");
            c7.setTipo(0);
            
            Coordenador c8 = new Coordenador();
            c8.setCodigo("885522");
            c8.setNome("Elias Cavalcante");
            c8.setEmail("elias@ifnmg.edu.br");
            c8.setSenha("insirasenhaaqui");
            c8.setTipo(0);
            
            Coordenador c9 = new Coordenador();
            c9.setCodigo("996633");
            c9.setNome("Caio Carvalho");
            c9.setEmail("caca@ifnmg.edu.br");
            c9.setSenha("cacaroto");
            c9.setTipo(0);

            Curso cu = new Curso();
            cu.setCargaHoraria(20);
            cu.setConcluido(false);
            cu.setCriador(c);
            c.getCursosCriados().add(cu);
            cu.setDataFim(new Date());
            cu.setDataInicio(new Date());
            cu.setLocalizacao("Laboratório de TI 1");
            cu.setMinistrante("Dom Pedro II");
            cu.setVagas(30);
            cu.setTitulo("Persistência Poliglota");
            cu.setDescricao("Aprenda a persistir seus dados com MongoDB, MySQL, Oracle e pedra talhada.");
            
            Curso cu2 = new Curso();
            cu2.setCargaHoraria(20);
            cu2.setConcluido(false);
            cu2.setCriador(c);
            c.getCursosCriados().add(cu2);
            cu2.setDataFim(new Date());
            cu2.setDataInicio(new Date());
            cu2.setLocalizacao("Laboratório de Física");
            cu2.setMinistrante(c.getNome());
            cu2.setVagas(20);
            cu2.setTitulo("Focalização quântica");
            cu2.setDescricao("Neste curso veremos como ajustar os parâmetros de focalização em um catalisador fotônico.");
            
            Curso cu3 = new Curso();
            cu3.setCargaHoraria(30);
            cu3.setConcluido(false);
            cu3.setCriador(c2);
            c2.getCursosCriados().add(cu3);
            cu3.setDataFim(new Date());
            cu3.setDataInicio(new Date());
            cu3.setLocalizacao("Laboratório de TI 2");
            cu3.setMinistrante(c2.getNome());
            cu3.setVagas(15);
            cu3.setTitulo("Perdendo o medo de ponteiros");
            cu3.setDescricao("Curso destinado àqueles que suam só de pensar no malloc.");
            
            Curso cu4 = new Curso();
            cu4.setCargaHoraria(8);
            cu4.setConcluido(false);
            cu4.setCriador(c3);
            c3.getCursosCriados().add(cu4);
            cu4.setDataFim(new Date());
            cu4.setDataInicio(new Date());
            cu4.setLocalizacao("Laboratório de TI");
            cu4.setMinistrante(c3.getNome());
            cu4.setVagas(36);
            cu4.setTitulo("Ferramenas para Big Data");
            cu4.setDescricao("Muitos dados. Muitos mesmo. Saiba como lidar com eles neste curso.");
            
            Curso cu5 = new Curso();
            cu5.setCargaHoraria(12);
            cu5.setConcluido(false);
            cu5.setCriador(c4);
            c4.getCursosCriados().add(cu5);
            cu5.setDataFim(new Date());
            cu5.setDataInicio(new Date());
            cu5.setLocalizacao("Laboratório de TI 3");
            cu5.setMinistrante("Bacalhau do Ultraje a Rigor");
            cu5.setVagas(18);
            cu5.setTitulo("Criando dados falsos sem ficar com tédio");
            cu5.setDescricao("Saiba como gerar placeholders sem sofrer danos cerebrais irreversíveis.");
            
            Curso cu6 = new Curso();
            cu6.setCargaHoraria(20);
            cu6.setConcluido(false);
            cu6.setCriador(c4);
            c4.getCursosCriados().add(cu6);
            cu6.setDataFim(new Date());
            cu6.setDataInicio(new Date());
            cu6.setLocalizacao("Laboratório de TI");
            cu6.setMinistrante(c4.getNome());
            cu6.setVagas(30);
            cu6.setTitulo("Criando APIs com .NET");
            cu6.setDescricao("Domine uma das tecnologias mais populares do mercado!");
            
            Curso cu7 = new Curso();
            cu7.setCargaHoraria(20);
            cu7.setConcluido(false);
            cu7.setCriador(c6);
            c6.getCursosCriados().add(cu7);
            cu7.setDataFim(new Date());
            cu7.setDataInicio(new Date());
            cu7.setLocalizacao("Laboratório de TI 2");
            cu7.setMinistrante(c6.getNome());
            cu7.setVagas(14);
            cu7.setTitulo("Dominando Views em Oracle");
            cu7.setDescricao("Neste curso você vai aprender a isolar seu BD das besteiras do usuário.");
            
            Curso cu8 = new Curso();
            cu8.setCargaHoraria(6);
            cu8.setConcluido(false);
            cu8.setCriador(c6);
            c6.getCursosCriados().add(cu8);
            cu8.setDataFim(new Date());
            cu8.setDataInicio(new Date());
            cu8.setLocalizacao("Laboratório de TI 3");
            cu8.setMinistrante(c6.getNome());
            cu8.setVagas(26);
            cu8.setTitulo("Administrando Clusters em PostgreSQL");
            cu8.setDescricao("PostgreSQL e clusters. Quer mais o quê?");
            
            Curso cu9 = new Curso();
            cu9.setCargaHoraria(8);
            cu9.setConcluido(false);
            cu9.setCriador(c6);
            c6.getCursosCriados().add(cu9);
            cu9.setDataFim(new Date());
            cu9.setDataInicio(new Date());
            cu9.setLocalizacao("Laboratório de TI 2");
            cu9.setMinistrante(c6.getNome());
            cu9.setVagas(30);
            cu9.setTitulo("Otimizando consultas no MySQL Server");
            cu9.setDescricao("Aprenda como tirar o melhor do seu hardware passando um pente nas suas consultas.");
            
            Curso cu10 = new Curso();
            cu10.setCargaHoraria(16);
            cu10.setConcluido(true);
            cu10.setCriador(c7);
            c7.getCursosCriados().add(cu10);
            cu10.setDataFim(new Date());
            cu10.setDataInicio(new Date());
            cu10.setLocalizacao("Laboratório de Eletrônica");
            cu10.setMinistrante(c7.getNome());
            cu10.setVagas(10);
            cu10.setTitulo("Bobinas de Tesla Caseiras");
            cu10.setDescricao("Tem um clipe e uma lata de alumínio sobrando? Então este curso é para você!");
            
            Curso cu11 = new Curso();
            cu11.setCargaHoraria(12);
            cu11.setConcluido(true);
            cu11.setCriador(c8);
            c8.getCursosCriados().add(cu11);
            cu11.setDataFim(new Date());
            cu11.setDataInicio(new Date());
            cu11.setLocalizacao("Laboratório de TI 1");
            cu11.setMinistrante("Senor Abravanel");
            cu11.setVagas(20);
            cu11.setTitulo("Docker na Prática");
            cu11.setDescricao("Domine essa tecnologia tão cara para o mercado!");
            
            Curso cu12 = new Curso();
            cu12.setCargaHoraria(12);
            cu12.setConcluido(false);
            cu12.setCriador(c8);
            c8.getCursosCriados().add(cu12);
            cu12.setDataFim(new Date());
            cu12.setDataInicio(new Date());
            cu12.setLocalizacao("Laboratório de TI 3");
            cu12.setMinistrante(c8.getNome());
            cu12.setVagas(30);
            cu12.setTitulo("Ruby para iniciantes");
            cu12.setDescricao("Domine os recursos básicos da linguagem Ruby.");
            
            Curso cu13 = new Curso();
            cu13.setCargaHoraria(4);
            cu13.setConcluido(false);
            cu13.setCriador(c9);
            c9.getCursosCriados().add(cu13);
            cu13.setDataFim(new Date());
            cu13.setDataInicio(new Date());
            cu13.setLocalizacao("Laboratório de TI 3");
            cu13.setMinistrante(c9.getNome());
            cu13.setVagas(6);
            cu13.setTitulo("Git avançado");
            cu13.setDescricao("Torne-se um mestre do versionamento.");
            
            Curso cu14 = new Curso();
            cu14.setCargaHoraria(16);
            cu14.setConcluido(false);
            cu14.setCriador(c9);
            c9.getCursosCriados().add(cu14);
            cu14.setDataFim(new Date());
            cu14.setDataInicio(new Date());
            cu14.setLocalizacao("Laboratório de TI 2");
            cu14.setMinistrante(c9.getNome());
            cu14.setVagas(14);
            cu14.setTitulo("DevOps para iniciantes");
            cu14.setDescricao("Crie sua primeira pipeline!");
            
            Curso cu15 = new Curso();
            cu15.setCargaHoraria(12);
            cu15.setConcluido(true);
            cu15.setCriador(c9);
            c9.getCursosCriados().add(cu15);
            cu15.setDataFim(new Date());
            cu15.setDataInicio(new Date());
            cu15.setLocalizacao("Laboratório de TI 1");
            cu15.setMinistrante(c9.getNome());
            cu15.setVagas(10);
            cu15.setTitulo("Git para iniciantes");
            cu15.setDescricao("inicie sua jornada no mundo do versionamento!");
            
            Curso cu16 = new Curso();
            cu16.setCargaHoraria(14);
            cu16.setConcluido(false);
            cu16.setCriador(c9);
            c9.getCursosCriados().add(cu16);
            cu16.setDataFim(new Date());
            cu16.setDataInicio(new Date());
            cu16.setLocalizacao("Auditório");
            cu16.setMinistrante(c9.getNome());
            cu16.setVagas(10);
            cu16.setTitulo("Branding para programadores");
            cu16.setDescricao("Não basta fazer programa, é preciso saber se vender! Aprenda como neste curso.");
            
            Curso cu17 = new Curso();
            cu17.setCargaHoraria(18);
            cu17.setConcluido(false);
            cu17.setCriador(c);
            c.getCursosCriados().add(cu17);
            cu17.setDataFim(new Date());
            cu17.setDataInicio(new Date());
            cu17.setLocalizacao("Laboratório de TI 2");
            cu17.setMinistrante("Massis de Achado");
            cu17.setVagas(15);
            cu17.setTitulo("Magia no Excel");
            cu17.setDescricao("Achou que o Excel era só pra digitar número? Errou feio. Vamos revelar o verdadeiro potencial deste software");
            
            Curso cu18 = new Curso();
            cu18.setCargaHoraria(4);
            cu18.setConcluido(true);
            cu18.setCriador(c4);
            c4.getCursosCriados().add(cu18);
            cu18.setDataFim(new Date());
            cu18.setDataInicio(new Date());
            cu18.setLocalizacao("Auditório");
            cu18.setMinistrante(c4.getNome());
            cu18.setVagas(40);
            cu18.setTitulo("Introdução à Programação Funcional");
            cu18.setDescricao("Fique por dentro desse paradigma T O P!");
            
            Estudante e = new Estudante();
            e.setCpf("11122233355");
            e.setEmail("estudante@email.com");
            e.setMatricula("552114");
            e.setNome("Abílio Almeida");
            e.setSenha("abilio123");
            e.setTipo(1);
            e.setTurma(2015);
            e.getCursosMatriculados().add(cu);
            cu.getMatriculados().add(e);
            
            Estudante e2 = new Estudante();
            e2.setCpf("10120230355");
            e2.setEmail("estudante2@email.com");
            e2.setMatricula("225544");
            e2.setNome("Bruno Barbosa");
            e2.setSenha("senhadificil");
            e2.setTipo(1);
            e2.setTurma(2015);
            e2.getCursosSolicitados().add(cu);
            cu.getSolicitantes().add(e2);
            
            Estudante e3 = new Estudante();
            e3.setCpf("45455455699");
            e3.setEmail("caiocastro@email.com");
            e3.setMatricula("225545");
            e3.setNome("Caio Castro");
            e3.setSenha("senhadocaio");
            e3.setTipo(1);
            e3.setTurma(2015);
            
            Estudante e4 = new Estudante();
            e4.setCpf("32222311202");
            e4.setEmail("danilodantas@email.com");
            e4.setMatricula("225544");
            e4.setNome("Danilo Dantas");
            e4.setSenha("wassaw");
            e4.setTipo(1);
            e4.setTurma(2015);
            
            Estudante e5 = new Estudante();
            e5.setCpf("11455233688");
            e5.setEmail("eee000@email.com");
            e5.setMatricula("225547");
            e5.setNome("Esdras Elias");
            e5.setSenha("gaivotamarinha");
            e5.setTipo(1);
            e5.setTurma(2016);
            
            Estudante e6 = new Estudante();
            e6.setCpf("74785828691");
            e6.setEmail("fabim@email.com");
            e6.setMatricula("225556");
            e6.setNome("Fábio França");
            e6.setSenha("minhasenha");
            e6.setTipo(1);
            e6.setTurma(2016);
            
            Estudante e7 = new Estudante();
            e7.setCpf("11122200094");
            e7.setEmail("gabriel007@email.com");
            e7.setMatricula("225600");
            e7.setNome("Gabriel Gafanhoto");
            e7.setSenha("00fdfdflfn");
            e7.setTipo(1);
            e7.setTurma(2016);
            
            Estudante e8 = new Estudante();
            e8.setCpf("12548965230");
            e8.setEmail("heliohelio@email.com");
            e8.setMatricula("225554");
            e8.setNome("Hélio Hilário");
            e8.setSenha("sd09ds0ds");
            e8.setTipo(1);
            e8.setTurma(2016);
            
            Estudante e9 = new Estudante();
            e9.setCpf("48352655412");
            e9.setEmail("igor@email.com");
            e9.setMatricula("225532");
            e9.setNome("Igor Igor");
            e9.setSenha("df64df16d4f16");
            e9.setTipo(1);
            e9.setTurma(2016);
            
            Estudante e10 = new Estudante();
            e10.setCpf("20220220257");
            e10.setEmail("katarina@email.com");
            e10.setMatricula("225549");
            e10.setNome("Katarina Kruger");
            e10.setSenha("d0f9dvf0d9v");
            e10.setTipo(1);
            e10.setTurma(2016);
            
            Estudante e11 = new Estudante();
            e11.setCpf("74585896952");
            e11.setEmail("leticia@email.com");
            e11.setMatricula("225540");
            e11.setNome("Letícia Lima");
            e11.setSenha("vdfm0dvf90vfd");
            e11.setTipo(1);
            e11.setTurma(2016);
            
            Estudante e12 = new Estudante();
            e12.setCpf("89856523246");
            e12.setEmail("maria@email.com");
            e12.setMatricula("225550");
            e12.setNome("Maria Macedo");
            e12.setSenha("d2j3d9nd");
            e12.setTipo(1);
            e12.setTurma(2016);
            
            Estudante e13 = new Estudante();
            e13.setCpf("69854123050");
            e13.setEmail("nayara@email.com");
            e13.setMatricula("225542");
            e13.setNome("Nayara Nogueira");
            e13.setSenha("179df91df19");
            e13.setTipo(1);
            e13.setTurma(2016);
            
            Estudante e14 = new Estudante();
            e14.setCpf("85524495127");
            e14.setEmail("otavio@email.com");
            e14.setMatricula("225530");
            e14.setNome("Otávio Ollosa");
            e14.setSenha("c8mdf89df9n8df");
            e14.setTipo(1);
            e14.setTurma(2017);
            
            Estudante e15 = new Estudante();
            e15.setCpf("44455521459");
            e15.setEmail("fe03j4@email.com");
            e15.setMatricula("225520");
            e15.setNome("Felipe Feijão");
            e15.setSenha("fdf09df09dfn0df");
            e15.setTipo(1);
            e15.setTurma(2017);
            
            Estudante e16 = new Estudante();
            e16.setCpf("55699823321");
            e16.setEmail("emaildojoao@email.com");
            e16.setMatricula("225524");
            e16.setNome("João Januário");
            e16.setSenha("ldldldldldlld");
            e16.setTipo(1);
            e16.setTurma(2017);
            
            Estudante e17 = new Estudante();
            e17.setCpf("99633688547");
            e17.setEmail("semideia@email.com");
            e17.setMatricula("225523");
            e17.setNome("Jacinto Ventania");
            e17.setSenha("sd98sdn89sd89");
            e17.setTipo(1);
            e17.setTurma(2017);
            
            Estudante e18 = new Estudante();
            e18.setCpf("74114774114");
            e18.setEmail("criatividade0@email.com");
            e18.setMatricula("225748");
            e18.setNome("Marta Wayne");
            e18.setSenha("sd09nds0");
            e18.setTipo(1);
            e18.setTurma(2017);
            
            Estudante e19 = new Estudante();
            e19.setCpf("95147852365");
            e19.setEmail("pimba@email.com");
            e19.setMatricula("225593");
            e19.setNome("Lucas Lúcido");
            e19.setSenha("615fd156dfdf156");
            e19.setTipo(1);
            e19.setTurma(2017);
            
            Estudante e20 = new Estudante();
            e20.setCpf("44455899365");
            e20.setEmail("exausto@email.com");
            e20.setMatricula("225514");
            e20.setNome("Luísa Lima");
            e20.setSenha("0dff090dfn9f0");
            e20.setTipo(1);
            e20.setTurma(2017);
            
            Estudante e21 = new Estudante();
            e21.setCpf("85885858525");
            e21.setEmail("llima@email.com");
            e21.setMatricula("225510");
            e21.setNome("Laís Lima");
            e21.setSenha("g146gffg");
            e21.setTipo(1);
            e21.setTurma(2017);
            
            Estudante e22 = new Estudante();
            e22.setCpf("92584152687");
            e22.setEmail("baba@email.com");
            e22.setMatricula("225344");
            e22.setNome("Bárbara Barbosa");
            e22.setSenha("44fd45dfdf");
            e22.setTipo(1);
            e22.setTurma(2017);
            
            Estudante e23 = new Estudante();
            e23.setCpf("40563525297");
            e23.setEmail("tycfcy@email.com");
            e23.setMatricula("225574");
            e23.setNome("Bianca Barbosa");
            e23.setSenha("6vbc465df4df56df456");
            e23.setTipo(1);
            e23.setTurma(2018);
            
            Estudante e24 = new Estudante();
            e24.setCpf("70740410158");
            e24.setEmail("tufaotropical@email.com");
            e24.setMatricula("225544");
            e24.setNome("Bruna Barbosa");
            e24.setSenha("7fg78fg78fg");
            e24.setTipo(1);
            e24.setTurma(2018);
            
            Estudante e25 = new Estudante();
            e25.setCpf("85214796325");
            e25.setEmail("escadarolante@email.com");
            e25.setMatricula("225544");
            e25.setNome("Baltazar Barbosa");
            e25.setSenha("df7df78df78");
            e25.setTipo(1);
            e25.setTurma(2018);
            
            Estudante e26 = new Estudante();
            e26.setCpf("20200000014");
            e26.setEmail("youtube@email.com");
            e26.setMatricula("225456");
            e26.setNome("Bilbo Barbosa");
            e26.setSenha("fg8f8f8f8");
            e26.setTipo(1);
            e26.setTurma(2018);
            
            Estudante e27 = new Estudante();
            e27.setCpf("45632178985");
            e27.setEmail("cadeiravermelha@email.com");
            e27.setMatricula("252525");
            e27.setNome("Billy Barbosa");
            e27.setSenha("2kl12kl12kl12");
            e27.setTipo(1);
            e27.setTurma(2018);
            
            Estudante e28 = new Estudante();
            e28.setCpf("45606544588");
            e28.setEmail("celular@email.com");
            e28.setMatricula("525696");
            e28.setNome("Andy Andrade");
            e28.setSenha("rc82r9f28c");
            e28.setTipo(1);
            e28.setTurma(2018);
            
            Estudante e29 = new Estudante();
            e29.setCpf("96325874105");
            e29.setEmail("leemail@email.com");
            e29.setMatricula("225500");
            e29.setNome("Walter Valério");
            e29.setSenha("23d1635d6231d");
            e29.setTipo(1);
            e29.setTurma(2019);
            
            Estudante e30 = new Estudante();
            e30.setCpf("90584675244");
            e30.setEmail("ravioli@email.com");
            e30.setMatricula("225654");
            e30.setNome("Lucília Lima");
            e30.setSenha("limakakakakaka");
            e30.setTipo(1);
            e30.setTurma(2019);
            
            Estudante e31 = new Estudante();
            e31.setCpf("77844511252");
            e31.setEmail("alberto@email.com");
            e31.setMatricula("225525");
            e31.setNome("Alberto Gilberto");
            e31.setSenha("45sd45sd45sd45sd5");
            e31.setTipo(1);
            e31.setTurma(2019);
            
            Estudante e32 = new Estudante();
            e32.setCpf("58541436352");
            e32.setEmail("humano@email.com");
            e32.setMatricula("225582");
            e32.setNome("Hugo Manoel");
            e32.setSenha("d3154d3154d");
            e32.setTipo(1);
            e32.setTurma(2019);
            
            Estudante e33 = new Estudante();
            e33.setCpf("44025066032");
            e33.setEmail("eueueueueueu@email.com");
            e33.setMatricula("225411");
            e33.setNome("Eurico Eustáquio");
            e33.setSenha("df45df45df45df45");
            e33.setTipo(1);
            e33.setTurma(2019);
            
            Estudante e34 = new Estudante();
            e34.setCpf("77744436352");
            e34.setEmail("hahahahaha@email.com");
            e34.setMatricula("225747");
            e34.setNome("Júlia Barbosa");
            e34.setSenha("dfdff45df45");
            e34.setTipo(1);
            e34.setTurma(2019);

            Estudante e35 = new Estudante();
            e35.setCpf("33025066032");
            e35.setEmail("wasd@email.com");
            e35.setMatricula("225412");
            e35.setNome("Irineu Eustáquio");
            e35.setSenha("vocenaosabenemeu");
            e35.setTipo(1);
            e35.setTurma(2019);
            
            Estudante e36 = new Estudante();
            e36.setCpf("55744436352");
            e36.setEmail("abcd@email.com");
            e36.setMatricula("225714");
            e36.setNome("Maria Florência");
            e36.setSenha("joseclaudio");
            e36.setTipo(1);
            e36.setTurma(2019);
            
            
            cu.getMatriculados().add(e);
            e.getCursosMatriculados().add(cu);
            cu.getMatriculados().add(e2);
            e2.getCursosMatriculados().add(cu);
            cu.getMatriculados().add(e3);
            e3.getCursosMatriculados().add(cu);
            cu.getMatriculados().add(e4);
            e4.getCursosMatriculados().add(cu);
            cu.getMatriculados().add(e5);
            e5.getCursosMatriculados().add(cu);
            cu.getMatriculados().add(e6);
            e6.getCursosMatriculados().add(cu);
            
            cu.getSolicitantes().add(e7);
            e7.getCursosSolicitados().add(cu);
            cu.getSolicitantes().add(e8);
            e8.getCursosSolicitados().add(cu);
            cu.getSolicitantes().add(e9);
            e9.getCursosSolicitados().add(cu);
            cu.getSolicitantes().add(e10);
            e10.getCursosSolicitados().add(cu);
            cu.getSolicitantes().add(e11);
            e11.getCursosSolicitados().add(cu);
            cu.getSolicitantes().add(e12);
            e12.getCursosSolicitados().add(cu);
            
            cu2.getMatriculados().add(e7);
            e7.getCursosMatriculados().add(cu2);
            cu2.getMatriculados().add(e8);
            e8.getCursosMatriculados().add(cu2);
            cu2.getMatriculados().add(e9);
            e9.getCursosMatriculados().add(cu2);
            cu2.getMatriculados().add(e10);
            e10.getCursosMatriculados().add(cu2);
            cu2.getMatriculados().add(e11);
            e11.getCursosMatriculados().add(cu2);
            cu2.getMatriculados().add(e12);
            e12.getCursosMatriculados().add(cu2);
            
            cu2.getSolicitantes().add(e);
            e.getCursosSolicitados().add(cu2);
            cu2.getSolicitantes().add(e2);
            e2.getCursosSolicitados().add(cu2);
            cu2.getSolicitantes().add(e3);
            e3.getCursosSolicitados().add(cu2);
            cu2.getSolicitantes().add(e4);
            e4.getCursosSolicitados().add(cu2);
            cu2.getSolicitantes().add(e5);
            e5.getCursosSolicitados().add(cu2);
            cu2.getSolicitantes().add(e6);
            e6.getCursosSolicitados().add(cu2);

            cu3.getMatriculados().add(e13);
            e13.getCursosMatriculados().add(cu3);
            cu3.getMatriculados().add(e14);
            e14.getCursosMatriculados().add(cu3);
            cu3.getMatriculados().add(e15);
            e15.getCursosMatriculados().add(cu3);
            cu3.getMatriculados().add(e16);
            e16.getCursosMatriculados().add(cu3);
            cu3.getMatriculados().add(e17);
            e17.getCursosMatriculados().add(cu3);
            cu3.getMatriculados().add(e18);
            e18.getCursosMatriculados().add(cu3);
            
            cu3.getSolicitantes().add(e19);
            e19.getCursosSolicitados().add(cu3);
            cu3.getSolicitantes().add(e20);
            e20.getCursosSolicitados().add(cu3);
            cu3.getSolicitantes().add(e21);
            e21.getCursosSolicitados().add(cu3);
            cu3.getSolicitantes().add(e22);
            e22.getCursosSolicitados().add(cu3);
            cu3.getSolicitantes().add(e23);
            e23.getCursosSolicitados().add(cu3);
            cu3.getSolicitantes().add(e24);
            e24.getCursosSolicitados().add(cu3);

            cu4.getMatriculados().add(e19);
            e19.getCursosMatriculados().add(cu4);
            cu4.getMatriculados().add(e20);
            e20.getCursosMatriculados().add(cu4);
            cu4.getMatriculados().add(e21);
            e21.getCursosMatriculados().add(cu4);
            cu4.getMatriculados().add(e22);
            e22.getCursosMatriculados().add(cu4);
            cu4.getMatriculados().add(e23);
            e23.getCursosMatriculados().add(cu4);
            cu4.getMatriculados().add(e24);
            e24.getCursosMatriculados().add(cu4);
            
            cu4.getSolicitantes().add(e13);
            e13.getCursosSolicitados().add(cu4);
            cu4.getSolicitantes().add(e14);
            e14.getCursosSolicitados().add(cu4);
            cu4.getSolicitantes().add(e15);
            e15.getCursosSolicitados().add(cu4);
            cu4.getSolicitantes().add(e16);
            e16.getCursosSolicitados().add(cu4);
            cu4.getSolicitantes().add(e17);
            e17.getCursosSolicitados().add(cu4);
            cu4.getSolicitantes().add(e18);
            e18.getCursosSolicitados().add(cu4);

            cu5.getMatriculados().add(e25);
            e25.getCursosMatriculados().add(cu5);
            cu5.getMatriculados().add(e26);
            e26.getCursosMatriculados().add(cu5);
            cu5.getMatriculados().add(e27);
            e27.getCursosMatriculados().add(cu5);
            cu5.getMatriculados().add(e28);
            e28.getCursosMatriculados().add(cu5);
            cu5.getMatriculados().add(e29);
            e29.getCursosMatriculados().add(cu5);
            cu5.getMatriculados().add(e30);
            e30.getCursosMatriculados().add(cu5);
            
            cu5.getSolicitantes().add(e31);
            e31.getCursosSolicitados().add(cu5);
            cu5.getSolicitantes().add(e32);
            e32.getCursosSolicitados().add(cu5);
            cu5.getSolicitantes().add(e33);
            e33.getCursosSolicitados().add(cu5);
            cu5.getSolicitantes().add(e34);
            e34.getCursosSolicitados().add(cu5);
            cu5.getSolicitantes().add(e35);
            e35.getCursosSolicitados().add(cu5);
            cu5.getSolicitantes().add(e36);
            e36.getCursosSolicitados().add(cu5);

            cu6.getMatriculados().add(e31);
            e31.getCursosMatriculados().add(cu6);
            cu6.getMatriculados().add(e32);
            e32.getCursosMatriculados().add(cu6);
            cu6.getMatriculados().add(e33);
            e33.getCursosMatriculados().add(cu6);
            cu6.getMatriculados().add(e34);
            e34.getCursosMatriculados().add(cu6);
            cu6.getMatriculados().add(e35);
            e35.getCursosMatriculados().add(cu6);
            cu6.getMatriculados().add(e36);
            e36.getCursosMatriculados().add(cu6);
            
            cu6.getSolicitantes().add(e25);
            e25.getCursosSolicitados().add(cu6);
            cu6.getSolicitantes().add(e26);
            e26.getCursosSolicitados().add(cu6);
            cu6.getSolicitantes().add(e27);
            e27.getCursosSolicitados().add(cu6);
            cu6.getSolicitantes().add(e28);
            e28.getCursosSolicitados().add(cu6);
            cu6.getSolicitantes().add(e29);
            e29.getCursosSolicitados().add(cu6);
            cu6.getSolicitantes().add(e30);
            e30.getCursosSolicitados().add(cu6);

            cu7.getMatriculados().add(e);
            e.getCursosMatriculados().add(cu7);
            cu7.getMatriculados().add(e2);
            e2.getCursosMatriculados().add(cu7);
            cu7.getMatriculados().add(e3);
            e3.getCursosMatriculados().add(cu7);
            cu7.getMatriculados().add(e4);
            e4.getCursosMatriculados().add(cu7);
            cu7.getMatriculados().add(e5);
            e5.getCursosMatriculados().add(cu7);
            cu7.getMatriculados().add(e6);
            e6.getCursosMatriculados().add(cu7);
            
            cu7.getSolicitantes().add(e7);
            e7.getCursosSolicitados().add(cu7);
            cu7.getSolicitantes().add(e8);
            e8.getCursosSolicitados().add(cu7);
            cu7.getSolicitantes().add(e9);
            e9.getCursosSolicitados().add(cu7);
            cu7.getSolicitantes().add(e10);
            e10.getCursosSolicitados().add(cu7);
            cu7.getSolicitantes().add(e11);
            e11.getCursosSolicitados().add(cu7);
            cu7.getSolicitantes().add(e12);
            e12.getCursosSolicitados().add(cu7);

            cu8.getMatriculados().add(e7);
            e7.getCursosMatriculados().add(cu8);
            cu8.getMatriculados().add(e8);
            e8.getCursosMatriculados().add(cu8);
            cu8.getMatriculados().add(e9);
            e9.getCursosMatriculados().add(cu8);
            cu8.getMatriculados().add(e10);
            e10.getCursosMatriculados().add(cu8);
            cu8.getMatriculados().add(e11);
            e11.getCursosMatriculados().add(cu8);
            cu8.getMatriculados().add(e12);
            e12.getCursosMatriculados().add(cu8);
            
            cu8.getSolicitantes().add(e);
            e.getCursosSolicitados().add(cu8);
            cu8.getSolicitantes().add(e2);
            e2.getCursosSolicitados().add(cu8);
            cu8.getSolicitantes().add(e3);
            e3.getCursosSolicitados().add(cu8);
            cu8.getSolicitantes().add(e4);
            e4.getCursosSolicitados().add(cu8);
            cu8.getSolicitantes().add(e5);
            e5.getCursosSolicitados().add(cu8);
            cu8.getSolicitantes().add(e6);
            e6.getCursosSolicitados().add(cu8);

            cu9.getMatriculados().add(e13);
            e13.getCursosMatriculados().add(cu9);
            cu9.getMatriculados().add(e14);
            e14.getCursosMatriculados().add(cu9);
            cu9.getMatriculados().add(e15);
            e15.getCursosMatriculados().add(cu9);
            cu9.getMatriculados().add(e16);
            e16.getCursosMatriculados().add(cu9);
            cu9.getMatriculados().add(e17);
            e17.getCursosMatriculados().add(cu9);
            cu9.getMatriculados().add(e18);
            e18.getCursosMatriculados().add(cu9);
            
            cu9.getSolicitantes().add(e19);
            e19.getCursosSolicitados().add(cu9);
            cu9.getSolicitantes().add(e20);
            e20.getCursosSolicitados().add(cu9);
            cu9.getSolicitantes().add(e21);
            e21.getCursosSolicitados().add(cu9);
            cu9.getSolicitantes().add(e22);
            e22.getCursosSolicitados().add(cu9);
            cu9.getSolicitantes().add(e23);
            e23.getCursosSolicitados().add(cu9);
            cu9.getSolicitantes().add(e24);
            e24.getCursosSolicitados().add(cu9);

            cu10.getMatriculados().add(e19);
            e19.getCursosMatriculados().add(cu10);
            cu10.getMatriculados().add(e20);
            e20.getCursosMatriculados().add(cu10);
            cu10.getMatriculados().add(e21);
            e21.getCursosMatriculados().add(cu10);
            cu10.getMatriculados().add(e22);
            e22.getCursosMatriculados().add(cu10);
            cu10.getMatriculados().add(e23);
            e23.getCursosMatriculados().add(cu10);
            cu10.getMatriculados().add(e24);
            e24.getCursosMatriculados().add(cu10);
            
            cu10.getSolicitantes().add(e13);
            e13.getCursosSolicitados().add(cu10);
            cu10.getSolicitantes().add(e14);
            e14.getCursosSolicitados().add(cu10);
            cu10.getSolicitantes().add(e15);
            e15.getCursosSolicitados().add(cu10);
            cu10.getSolicitantes().add(e16);
            e16.getCursosSolicitados().add(cu10);
            cu10.getSolicitantes().add(e17);
            e17.getCursosSolicitados().add(cu10);
            cu10.getSolicitantes().add(e18);
            e18.getCursosSolicitados().add(cu10);

            cu11.getMatriculados().add(e25);
            e25.getCursosMatriculados().add(cu11);
            cu11.getMatriculados().add(e26);
            e26.getCursosMatriculados().add(cu11);
            cu11.getMatriculados().add(e27);
            e27.getCursosMatriculados().add(cu11);
            cu11.getMatriculados().add(e28);
            e28.getCursosMatriculados().add(cu11);
            cu11.getMatriculados().add(e29);
            e29.getCursosMatriculados().add(cu11);
            cu11.getMatriculados().add(e30);
            e30.getCursosMatriculados().add(cu11);
            
            cu11.getSolicitantes().add(e31);
            e31.getCursosSolicitados().add(cu11);
            cu11.getSolicitantes().add(e32);
            e32.getCursosSolicitados().add(cu11);
            cu11.getSolicitantes().add(e33);
            e33.getCursosSolicitados().add(cu11);
            cu11.getSolicitantes().add(e34);
            e34.getCursosSolicitados().add(cu11);
            cu11.getSolicitantes().add(e35);
            e35.getCursosSolicitados().add(cu11);
            cu11.getSolicitantes().add(e36);
            e36.getCursosSolicitados().add(cu11);

            cu12.getMatriculados().add(e31);
            e31.getCursosMatriculados().add(cu12);
            cu12.getMatriculados().add(e32);
            e32.getCursosMatriculados().add(cu12);
            cu12.getMatriculados().add(e33);
            e33.getCursosMatriculados().add(cu12);
            cu12.getMatriculados().add(e34);
            e34.getCursosMatriculados().add(cu12);
            cu12.getMatriculados().add(e35);
            e35.getCursosMatriculados().add(cu12);
            cu12.getMatriculados().add(e36);
            e36.getCursosMatriculados().add(cu12);
            
            cu12.getSolicitantes().add(e25);
            e25.getCursosSolicitados().add(cu12);
            cu12.getSolicitantes().add(e26);
            e26.getCursosSolicitados().add(cu12);
            cu12.getSolicitantes().add(e27);
            e27.getCursosSolicitados().add(cu12);
            cu12.getSolicitantes().add(e28);
            e28.getCursosSolicitados().add(cu12);
            cu12.getSolicitantes().add(e29);
            e29.getCursosSolicitados().add(cu12);
            cu12.getSolicitantes().add(e30);
            e30.getCursosSolicitados().add(cu12);

            cu13.getMatriculados().add(e);
            e.getCursosMatriculados().add(cu13);
            cu13.getMatriculados().add(e2);
            e2.getCursosMatriculados().add(cu13);
            cu13.getMatriculados().add(e3);
            e3.getCursosMatriculados().add(cu13);
            cu13.getMatriculados().add(e4);
            e4.getCursosMatriculados().add(cu13);
            cu13.getMatriculados().add(e5);
            e5.getCursosMatriculados().add(cu13);
            cu13.getMatriculados().add(e6);
            e6.getCursosMatriculados().add(cu13);
            
            cu13.getSolicitantes().add(e7);
            e7.getCursosSolicitados().add(cu13);
            cu13.getSolicitantes().add(e8);
            e8.getCursosSolicitados().add(cu13);
            cu13.getSolicitantes().add(e9);
            e9.getCursosSolicitados().add(cu13);
            cu13.getSolicitantes().add(e10);
            e10.getCursosSolicitados().add(cu13);
            cu13.getSolicitantes().add(e11);
            e11.getCursosSolicitados().add(cu13);
            cu13.getSolicitantes().add(e12);
            e12.getCursosSolicitados().add(cu13);

            cu14.getMatriculados().add(e7);
            e7.getCursosMatriculados().add(cu14);
            cu14.getMatriculados().add(e8);
            e8.getCursosMatriculados().add(cu14);
            cu14.getMatriculados().add(e9);
            e9.getCursosMatriculados().add(cu14);
            cu14.getMatriculados().add(e10);
            e10.getCursosMatriculados().add(cu14);
            cu14.getMatriculados().add(e11);
            e11.getCursosMatriculados().add(cu14);
            cu14.getMatriculados().add(e12);
            e12.getCursosMatriculados().add(cu14);
            
            cu14.getSolicitantes().add(e);
            e.getCursosSolicitados().add(cu14);
            cu14.getSolicitantes().add(e2);
            e2.getCursosSolicitados().add(cu14);
            cu14.getSolicitantes().add(e3);
            e3.getCursosSolicitados().add(cu14);
            cu14.getSolicitantes().add(e4);
            e4.getCursosSolicitados().add(cu14);
            cu14.getSolicitantes().add(e5);
            e5.getCursosSolicitados().add(cu14);
            cu14.getSolicitantes().add(e6);
            e6.getCursosSolicitados().add(cu14);

            cu15.getMatriculados().add(e13);
            e13.getCursosMatriculados().add(cu15);
            cu15.getMatriculados().add(e14);
            e14.getCursosMatriculados().add(cu15);
            cu15.getMatriculados().add(e15);
            e15.getCursosMatriculados().add(cu15);
            cu15.getMatriculados().add(e16);
            e16.getCursosMatriculados().add(cu15);
            cu15.getMatriculados().add(e17);
            e17.getCursosMatriculados().add(cu15);
            cu15.getMatriculados().add(e18);
            e18.getCursosMatriculados().add(cu15);
            
            cu15.getSolicitantes().add(e19);
            e19.getCursosSolicitados().add(cu15);
            cu15.getSolicitantes().add(e20);
            e20.getCursosSolicitados().add(cu15);
            cu15.getSolicitantes().add(e21);
            e21.getCursosSolicitados().add(cu15);
            cu15.getSolicitantes().add(e22);
            e22.getCursosSolicitados().add(cu15);
            cu15.getSolicitantes().add(e23);
            e23.getCursosSolicitados().add(cu15);
            cu15.getSolicitantes().add(e24);
            e24.getCursosSolicitados().add(cu15);

            cu16.getMatriculados().add(e19);
            e19.getCursosMatriculados().add(cu16);
            cu16.getMatriculados().add(e20);
            e20.getCursosMatriculados().add(cu16);
            cu16.getMatriculados().add(e21);
            e21.getCursosMatriculados().add(cu16);
            cu16.getMatriculados().add(e22);
            e22.getCursosMatriculados().add(cu16);
            cu16.getMatriculados().add(e23);
            e23.getCursosMatriculados().add(cu16);
            cu16.getMatriculados().add(e24);
            e24.getCursosMatriculados().add(cu16);
            
            cu16.getSolicitantes().add(e13);
            e13.getCursosSolicitados().add(cu16);
            cu16.getSolicitantes().add(e14);
            e14.getCursosSolicitados().add(cu16);
            cu16.getSolicitantes().add(e15);
            e15.getCursosSolicitados().add(cu16);
            cu16.getSolicitantes().add(e16);
            e16.getCursosSolicitados().add(cu16);
            cu16.getSolicitantes().add(e17);
            e17.getCursosSolicitados().add(cu16);
            cu16.getSolicitantes().add(e18);
            e18.getCursosSolicitados().add(cu16);

            cu17.getMatriculados().add(e25);
            e25.getCursosMatriculados().add(cu17);
            cu17.getMatriculados().add(e26);
            e26.getCursosMatriculados().add(cu17);
            cu17.getMatriculados().add(e27);
            e27.getCursosMatriculados().add(cu17);
            cu17.getMatriculados().add(e28);
            e28.getCursosMatriculados().add(cu17);
            cu17.getMatriculados().add(e29);
            e29.getCursosMatriculados().add(cu17);
            cu17.getMatriculados().add(e30);
            e30.getCursosMatriculados().add(cu17);
            
            cu17.getSolicitantes().add(e31);
            e31.getCursosSolicitados().add(cu17);
            cu17.getSolicitantes().add(e32);
            e32.getCursosSolicitados().add(cu17);
            cu17.getSolicitantes().add(e33);
            e33.getCursosSolicitados().add(cu17);
            cu17.getSolicitantes().add(e34);
            e34.getCursosSolicitados().add(cu17);
            cu17.getSolicitantes().add(e35);
            e35.getCursosSolicitados().add(cu17);
            cu17.getSolicitantes().add(e36);
            e36.getCursosSolicitados().add(cu17);

            cu18.getMatriculados().add(e31);
            e31.getCursosMatriculados().add(cu18);
            cu18.getMatriculados().add(e32);
            e32.getCursosMatriculados().add(cu18);
            cu18.getMatriculados().add(e33);
            e33.getCursosMatriculados().add(cu18);
            cu18.getMatriculados().add(e34);
            e34.getCursosMatriculados().add(cu18);
            cu18.getMatriculados().add(e35);
            e35.getCursosMatriculados().add(cu18);
            cu18.getMatriculados().add(e36);
            e36.getCursosMatriculados().add(cu18);
            
            cu18.getSolicitantes().add(e25);
            e25.getCursosSolicitados().add(cu18);
            cu18.getSolicitantes().add(e26);
            e26.getCursosSolicitados().add(cu18);
            cu18.getSolicitantes().add(e27);
            e27.getCursosSolicitados().add(cu18);
            cu18.getSolicitantes().add(e28);
            e28.getCursosSolicitados().add(cu18);
            cu18.getSolicitantes().add(e29);
            e29.getCursosSolicitados().add(cu18);
            cu18.getSolicitantes().add(e30);
            e30.getCursosSolicitados().add(cu18);
            
            cubl.save(cu);
            cubl.save(cu2);
            cubl.save(cu3);
            cubl.save(cu4);
            cubl.save(cu5);
            cubl.save(cu6);
            cubl.save(cu7);
            cubl.save(cu8);
            cubl.save(cu9);
            cubl.save(cu10);
            cubl.save(cu11);
            cubl.save(cu12);
            cubl.save(cu13);
            cubl.save(cu14);
            cubl.save(cu15);
            cubl.save(cu16);
            cubl.save(cu17);
            cubl.save(cu18);
            
            cbl.save(c);
            cbl.save(c2);
            cbl.save(c3);
            cbl.save(c4);
            cbl.save(c5);
            cbl.save(c6);
            cbl.save(c7);
            cbl.save(c8);
            cbl.save(c9);
            
            ebl.save(e);
            ebl.save(e2);
            ebl.save(e3);
            ebl.save(e4);
            ebl.save(e5);
            ebl.save(e6);
            ebl.save(e7);
            ebl.save(e8);
            ebl.save(e9);
            ebl.save(e10);
            ebl.save(e11);
            ebl.save(e12);
            ebl.save(e13);
            ebl.save(e14);
            ebl.save(e15);
            ebl.save(e16);
            ebl.save(e17);
            ebl.save(e18);
            ebl.save(e19);
            ebl.save(e20);
            ebl.save(e21);
            ebl.save(e22);
            ebl.save(e23);
            ebl.save(e24);
            ebl.save(e25);
            ebl.save(e26);
            ebl.save(e27);
            ebl.save(e28);
            ebl.save(e29);
            ebl.save(e30);
            ebl.save(e31);
            ebl.save(e32);
            ebl.save(e33);
            ebl.save(e34);
            
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