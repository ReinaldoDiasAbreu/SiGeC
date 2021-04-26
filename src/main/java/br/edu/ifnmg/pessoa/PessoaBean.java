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
package br.edu.ifnmg.pessoa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Reinaldo Junio Dias de Abreu <rjdda at aluno.ifnmg.edu.br>
 */
@Stateless
public class PessoaBean implements PessoaBeanLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<Pessoa> findAllPessoas() {
        return em.createNamedQuery(
        "Pessoa.findAll", Pessoa.class 
        ).getResultList();
    }
    
    @Override
    public Pessoa findPessoaById(Long id) {
        Query q = em.createNamedQuery(
            "Pessoa.findById", Pessoa.class
        );
        q.setParameter("id", id);
        return (Pessoa) q.getSingleResult();
    }
    
    @Override
    public List<Pessoa> findPessoaByNome(String nome) {
        Query q = em.createNamedQuery(
            "Pessoa.findByNome", Pessoa.class
        );
        q.setParameter("D", nome);
        return q.getResultList();
    }

    @Override
    public Pessoa findPessoaByEmail(String email) {
       Query q = em.createNamedQuery(
            "Pessoa.findByEmail", Pessoa.class
        );
        q.setParameter("email", email);
        return (Pessoa) q.getSingleResult();
    }


}
