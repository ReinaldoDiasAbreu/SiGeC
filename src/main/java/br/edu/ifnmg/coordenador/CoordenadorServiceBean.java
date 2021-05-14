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
package br.edu.ifnmg.coordenador;

import br.edu.ifnmg.curso.Curso;
import br.edu.ifnmg.curso.CursoBeanLocal;
import br.edu.ifnmg.estudante.Estudante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Reinaldo Junio Dias de Abreu <rjdda at aluno.ifnmg.edu.br>
 */
@Named(value = "coordenadorBean")
@ViewScoped
public class CoordenadorServiceBean implements Serializable {
    
    @Inject
    private CoordenadorBeanLocal coordenadorlocal;
    
    @Inject
    private CursoBeanLocal cursolocal;
    
    private Coordenador coordenador;
    
    private Long coordenadorId;
    
    private List<Curso> allCreatedCourses;
    
    private Curso selectedCourse;
    
    private Date minDate;
    
    private String senha1;
    private String senha2;

    public CoordenadorServiceBean() {
        coordenador = new Coordenador();
        selectedCourse = new Curso();
        minDate = new Date();
    }

    public void save(){        
        if(senha1.equals(senha2)){
            coordenador.setSenha(senha1);
        }
        
        coordenadorlocal.save(coordenador);
    }
    
    public Curso loadCourseWithStudents(Curso curso)
    {
        if(curso == null)
            return null;
        
        Curso fullCourse = cursolocal.loadCourseWithStudents(curso.getId());
        selectedCourse = fullCourse;
        minDate = selectedCourse.getDataInicio();
        
        return selectedCourse;
    }
    
    public List<Curso> allCreatedCourses(Long id)
    {
        coordenadorId = id;
        allCreatedCourses = coordenadorlocal.findCursosCriados(id);
        return allCreatedCourses;
    }

    public void reloadCreatedCourses()
    {
        allCreatedCourses = coordenadorlocal.findCursosCriados(coordenadorId);
    }
        
    public String saveCurrent() {
        selectedCourse.setCriador(coordenadorlocal.findCoordenadorById(coordenadorId));
        
        if(selectedCourse.getSolicitantes() == null)
            selectedCourse.setSolicitantes(new ArrayList<Estudante>());
        
        if(selectedCourse.getMatriculados() == null)
            selectedCourse.setMatriculados(new ArrayList<Estudante>());
        
        cursolocal.save(selectedCourse);
        reloadCreatedCourses();
        reset();
        
        return "index?faces-redirect=true";
    }
    
    public void reset() {
        selectedCourse = new Curso();
    }
    
    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }
    
    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public Curso getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Curso selectedCourse) {
        this.selectedCourse = selectedCourse;
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
}
