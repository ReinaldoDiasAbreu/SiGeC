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
package br.edu.ifnmg.curso;

import br.edu.ifnmg.estudante.Estudante;
import br.edu.ifnmg.coordenador.Coordenador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author alex
 */

@Entity(name = "curso")
@Table(name = "tbl_curso")
@NamedQueries({
    @NamedQuery(
        name = "Curso.findAll",
        query = "SELECT c FROM curso c"),
    @NamedQuery(
        name = "Curso.findById",
        query = "SELECT c FROM curso c WHERE c.id = :id"),
    @NamedQuery(
        name = "Curso.findByMinistrante",
        query = "SELECT c FROM curso c WHERE c.ministrante LIKE 'M%'"),
    @NamedQuery(
        name = "Curso.findByTitulo",
        query = "SELECT c FROM curso c WHERE c.titulo LIKE 'T%'"),
    @NamedQuery(
        name = "Curso.findByLocalizacao",
        query = "SELECT c FROM curso c WHERE c.localizacao LIKE 'L%'"),
    @NamedQuery(
        name = "Curso.findConcluidos",
        query = "SELECT c FROM curso c WHERE c.concluido = true"),
    @NamedQuery(
        name = "Curso.findNaoConcluidos",
        query = "SELECT c FROM curso c WHERE c.concluido = false"),
    @NamedQuery(
        name = "Curso.findComVagas",
        query = "SELECT c FROM curso c WHERE c.vagas > 0"),
    @NamedQuery(
            name = "Curso.findAllOtherCoursesByEstudante",
            query = "SELECT c FROM curso c"),
    @NamedQuery(
            name = "Curso.loadCourseWithStudents",
            query = "select distinct c from curso c "
            + "left join fetch c.solicitantes "
            + "where c.id = :id "
            + "order by c.id")
})

public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private String localizacao;
    
    @Column(nullable = false)
    private int cargaHoraria;
    
    @Column(nullable = false)
    private int vagas;
    
    @Column(nullable = false)
    private String ministrante;
    
    @Column(nullable = false)
    private boolean concluido;
    
    @Column(nullable = false)
    private String titulo;
    
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "coordenador_id")
    private Coordenador criador;
    
    @ManyToMany(mappedBy = "cursosMatriculados")
    private List<Estudante> matriculados;
    
    @ManyToMany(mappedBy = "cursosSolicitados")
    private List<Estudante> solicitantes;

    public Curso() {
        matriculados = new ArrayList<>();
        solicitantes = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(String ministrante) {
        this.ministrante = ministrante;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Coordenador getCriador() {
        return criador;
    }

    public void setCriador(Coordenador criador) {
        this.criador = criador;
    }

    public List<Estudante> getMatriculados() {
        return matriculados;
    }

    public void setMatriculados(ArrayList<Estudante> matriculados) {
        this.matriculados = matriculados;
    }

    public List<Estudante> getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(ArrayList<Estudante> solicitantes) {
        this.solicitantes = solicitantes;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="hashCode/equals/toString">
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.sigec.entity.Curso[ id=" + id + " ]";
    }
    
    //</editor-fold>
    
}
