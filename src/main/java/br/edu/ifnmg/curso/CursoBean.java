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
public class CursoBean implements CursoBeanLocal{
    @PersistenceContext
    EntityManager em;
    
    @Override
    public void save(Curso c){
        em.persist(c);
    }
    
    @Override
    public void delete(Curso c){
        em.remove(c);
    }
    
    @Override
    public void update(Curso c){
        em.refresh(c);
    }
    
    @Override
    public List<Curso> findAllCursos(){
        return em.createNamedQuery("Curso.findAll", 
                Curso.class).getResultList();
    }
    
    @Override
    public Curso findCursoById(Long id){
        Query q = em.createNamedQuery("Curso.findById",
                    Curso.class);
        q.setParameter("id", id);
        return (Curso) q.getSingleResult();
    }
    
    @Override
    public List<Curso> findCursoByMinistrante(String ministrante){
        Query q = em.createNamedQuery("Curso.findByMinistrante",
                    Curso.class);
        q.setParameter("M", ministrante);
        return q.getResultList();
    }
    
    @Override
    public List<Curso> findCursoByTitulo(String titulo){
        Query q = em.createNamedQuery("Curso.findByTitulo",
                    Curso.class);
        q.setParameter("T", titulo);
        return q.getResultList();
    }
    
    @Override
    public List<Curso> findCursoByLocalizacao(String local){
        Query q = em.createNamedQuery("Curso.findByLocalizacao",
                    Curso.class);
        q.setParameter("L", local);
        return q.getResultList();
    }
    
    @Override
    public List<Curso> findCursosConcluidos(){
        return em.createNamedQuery("Curso.findConcluidos",
                Curso.class).getResultList();
    }
    
    @Override
    public List<Curso> findCursosNaoConcluidos(){
        return em.createNamedQuery("Curso.findNaoConcluidos",
                Curso.class).getResultList();
    }
    
    @Override
    public List<Curso> findCursosComVagas(){
        return em.createNamedQuery("Curso.findComVagas",
                Curso.class).getResultList();
    }
}
