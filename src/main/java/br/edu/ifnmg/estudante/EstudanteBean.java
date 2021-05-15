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

import br.edu.ifnmg.curso.Curso;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author alex
 */
@Stateless
public class EstudanteBean implements EstudanteBeanLocal {
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Pbkdf2PasswordHash passwordHasher;
    
    @Override
    public void save(Estudante e){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3071");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHasher.initialize(parameters);
        
        String hashedPassword = passwordHasher.generate(e.getSenha().toCharArray());
        e.setSenha(hashedPassword);
        
        em.persist(e);
    }
    
    @Override
    public void delete(Estudante e) {
        em.remove(e);
    }
    
    @Override
    public void update(Estudante e){
        em.merge(e);
    }
   
    @Override
    public List<Estudante> findAllEstudantes() {
        return em.createNamedQuery(
        "Estudante.findAll", Estudante.class 
        ).getResultList();
    }

    @Override
    public Estudante findEstudanteById(Long id) {
        Query q = em.createNamedQuery(
            "Estudante.findById", Estudante.class
        );
        q.setParameter("id", id);
        return (Estudante) q.getSingleResult();
    }

    @Override
    public Estudante findEstudanteByCpf(String cpf) {
        Query q = em.createNamedQuery(
            "Estudante.findByCpf", Estudante.class
        );
        q.setParameter("cpf", cpf);
        return (Estudante) q.getSingleResult();
    }

    @Override
    public List<Curso> findCursosSolicitados(Long id) {
       Query q = em.createNamedQuery(
            "Estudante.findCursosSolicitados", Curso.class 
        );
        q.setParameter("id", id);
        return q.getResultList();
    }

    @Override
    public List<Curso> findAllOtherCourses(Long id) {
        Query q = em.createNamedQuery(
            "Estudante.AllOtherCourses", Curso.class 
        );
        q.setParameter("id", id);
        return q.getResultList();
    }

    @Override
    public List<Curso> findCursosMatriculados(Long id) {
        Query q = em.createNamedQuery(
            "Estudante.findCursosMatriculados", Curso.class 
        );
        q.setParameter("id", id);
        return q.getResultList();
    }

}
