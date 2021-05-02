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
public class CoordenadorBean implements CoordenadorBeanLocal {
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Pbkdf2PasswordHash passwordHasher;
    
    @Override
    public void save(Coordenador c){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3071");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHasher.initialize(parameters);
        
        String hashedPassword = passwordHasher.generate(c.getSenha().toCharArray());
        c.setSenha(hashedPassword);
        
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
