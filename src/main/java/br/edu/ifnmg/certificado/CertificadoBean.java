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
package br.edu.ifnmg.certificado;

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
public class CertificadoBean implements CertificadoBeanLocal{
    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Certificado c) {
        em.persist(c);
    }

    @Override
    public void delete(Certificado c) {
        em.remove(c);
    }

    @Override
    public void update(Certificado c) {
        em.merge(c);
    }

    @Override
    public List<Certificado> findAll() {
        return em.createNamedQuery(
        "Certificado.findAll", Certificado.class 
        ).getResultList();
    }

    @Override
    public Certificado findById(Long id) {
        Query q = em.createNamedQuery(
            "Certificado.findById", Certificado.class
        );
        q.setParameter("id", id);
        return (Certificado) q.getSingleResult();
    }

    @Override
    public Certificado findByCodigo(String codigo) {
       Query q = em.createNamedQuery(
            "Certificado.findByCodigo", Certificado.class
        );
        q.setParameter("codigo", codigo);
        return (Certificado) q.getSingleResult();
    }
    
    
}
