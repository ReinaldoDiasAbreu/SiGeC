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
package br.edu.ifnmg.coordenador;

import br.edu.ifnmg.curso.Curso;
import br.edu.ifnmg.pessoa.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alex
 */

@Entity(name = "coordenador")
@Table(name = "tbl_coordenador")
@NamedQueries({
    @NamedQuery(
        name = "Coordenador.findAll",
        query = "SELECT c FROM coordenador c"),
    @NamedQuery(
        name = "Coordenador.findById",
        query = "SELECT c FROM coordenador c WHERE c.id = :id"),
    @NamedQuery(
        name = "Coordenador.findByCodigo",
        query = "SELECT c FROM coordenador c WHERE c.codigo = :codigo"),
    @NamedQuery(
        name = "Coordenador.findCursosCriados",
        query = "SELECT cc FROM coordenador c " + 
                "JOIN c.cursosCriados cc")
})

public class Coordenador extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false)
    private String codigo;
    
    @OneToMany(mappedBy = "criador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursosCriados;

    public Coordenador() {
        cursosCriados = new ArrayList<>();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Curso> getCursosCriados() {
        return cursosCriados;
    }

    public void setCursosCriados(ArrayList<Curso> cursosCriados) {
        this.cursosCriados = cursosCriados;
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
        if (!(object instanceof Coordenador)) {
            return false;
        }
        Coordenador other = (Coordenador) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.sigec.entity.Coordenador[ id=" + getId() + " ]";
    }
    
    //</editor-fold>
    
}
