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
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alex
 */
@Stateless
public class CoordenadorBean implements CoordenadorBeanLocal {
    @PersistenceContext
    EntityManager em;
    
    @Override
    public void save(Coordenador c){
        em.persist(c);
    }
    
    @Override
    public void delete(Coordenador c){
        em.remove(c);
    }
    
    @Override
    public void update(Coordenador c){
        em.refresh(c);
    }
    
    @Override
    public List<Coordenador> findAllCoordenadores(){
        return em.createNamedQuery("Coordenador.findAll", 
                Coordenador.class).getResultList();
    }
    
    @Override
    public Coordenador findCoordenadorById(Long id){
        Query q = em.createNamedQuery("Coordenador.findById",
                    Coordenador.class);
        q.setParameter("id", id);
        return (Coordenador) q.getSingleResult();
    }
    
    @Override
    public Coordenador findCoordenadorByCodigo(String cod){
        Query q = em.createNamedQuery("Coordenador.findByCodigo",
                    Coordenador.class);
        q.setParameter("codigo", cod);
        return (Coordenador) q.getSingleResult();
    }
    
    @Override
    public List<Curso> findCursosCriados(Long id){
        Query q = em.createNamedQuery("Coordenador.findCursosCriados",
                    Curso.class);
        q.setParameter("id", id);
        return q.getResultList();
    }
}
