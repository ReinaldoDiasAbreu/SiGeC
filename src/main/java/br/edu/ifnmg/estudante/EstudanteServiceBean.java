/*
 * Copyright (C) 2021 Reinaldo Junio Dias de Abreu <rjdda at aluno.ifnmg.edu.br>
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
package br.edu.ifnmg.estudante;

import br.edu.ifnmg.curso.Curso;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Reinaldo Junio Dias de Abreu <rjdda at aluno.ifnmg.edu.br>
 */

@Named(value = "estudanteBean")
@ViewScoped
public class EstudanteServiceBean implements Serializable  {
    
    @Inject
    private EstudanteBeanLocal estudantelocal;
    
    private Estudante estudante;
    
    private String senha1;
    private String senha2;
    
    // Reserved for datatable filtered
    private List<Curso> filteredCursos;
    
    public EstudanteServiceBean() {
        estudante = new Estudante();
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public List<Curso> getFilteredCursos() {
        return filteredCursos;
    }

    public void setFilteredCursos(List<Curso> filteredCursos) {
        this.filteredCursos = filteredCursos;
    }

    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }
    
    public void save(){
        if(senha1.equals(senha2)){
             estudante.setSenha(senha1);
        }
        estudantelocal.save(estudante);
    }
    
    public List<Curso> findAllOtherCourses(Long id){
        return estudantelocal.findAllOtherCourses(id);
    }
    
    public List<Curso> findCursosMatriculados(Long id){
        return estudantelocal.findCursosMatriculados(id);
    }


}
