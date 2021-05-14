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
package br.edu.ifnmg.estudante;

import br.edu.ifnmg.pessoa.Pessoa;
import br.edu.ifnmg.curso.Curso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alex
 */

@Entity(name = "estudante")
@Table(name = "tbl_estudante")

@NamedQueries({
    @NamedQuery(
            name = "Estudante.findAll",
            query = "SELECT e FROM estudante e"
    ),
    @NamedQuery(
            name = "Estudante.findById",
            query = "SELECT e FROM estudante e WHERE e.id = :id"
    ),
    @NamedQuery(
            name = "Estudante.findByCpf",
            query = "SELECT e FROM estudante e WHERE e.cpf = :cpf"
    ),
    @NamedQuery(
            name = "Estudante.findCursosMatriculados",
            query = "SELECT c FROM curso c WHERE c.id in (SELECT cm.id FROM estudante e JOIN e.cursosMatriculados cm WHERE e.id = :id)"
    ),
    @NamedQuery(
            name = "Estudante.AllOtherCourses",
            query = "SELECT c FROM curso c WHERE c.concluido = false and c.id not in"
                    + "(SELECT cm.id from estudante e JOIN e.cursosMatriculados cm WHERE e.id = :id)"
                    + "and c.id not in "
                    + "(SELECT cs.id from estudante e JOIN e.cursosSolicitados cs WHERE e.id = :id)"
    )
})

public class Estudante extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(length = 11, nullable = false)
    private String cpf;
    
    @Column(nullable = false)
    private int turma;
    
    @Column(nullable = false)
    private String matricula;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tbl_estudante_cursosmatriculados",
            joinColumns = 
                    @JoinColumn(name = "estudante_id", foreignKey = @ForeignKey(name = "fk_estudante_id")),
            inverseJoinColumns = @JoinColumn(name = "curso_id", foreignKey = @ForeignKey(name = "fk_curso_id")))
    private List<Curso> cursosMatriculados;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tbl_estudante_cursossolicitados",
            joinColumns = 
                    @JoinColumn(name = "estudante_id", foreignKey = @ForeignKey(name = "fk_estudante_id")),
            inverseJoinColumns = @JoinColumn(name = "curso_id", foreignKey = @ForeignKey(name = "fk_curso_id")))
    private List<Curso> cursosSolicitados;
    
    public Estudante() {
        this.setGrupo("aluno");
        cursosMatriculados = new ArrayList<>();
        cursosSolicitados = new ArrayList<>();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public List<Curso> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void setCursosMatriculados(ArrayList<Curso> cursosMatriculados) {
        this.cursosMatriculados = cursosMatriculados;
    }

    public List<Curso> getCursosSolicitados() {
        return cursosSolicitados;
    }

    public void setCursosSolicitados(ArrayList<Curso> cursosSolicitados) {
        this.cursosSolicitados = cursosSolicitados;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void addSolicitacaoCurso(Curso c){
        cursosSolicitados.add(c);
    }
    
    public void addMatriculaCurso(Curso c){
        cursosMatriculados.add(c);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="hashCode/equals/toString">

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudante)) {
            return false;
        }
        Estudante other = (Estudante) object;
        if ((this.getId() == null && other.getId()!= null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    //</editor-fold>

    @Override
    public String toString() {
        return "Estudante{" + "nome=" + getNome() + ", cpf=" + cpf + ", turma=" + turma + ", matricula=" + matricula + '}';
    }
    
}
