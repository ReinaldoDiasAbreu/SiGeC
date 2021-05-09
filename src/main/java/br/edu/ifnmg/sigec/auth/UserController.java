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
package br.edu.ifnmg.sigec.auth;

import br.edu.ifnmg.pessoa.Pessoa;
import br.edu.ifnmg.pessoa.PessoaBeanLocal;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import javax.servlet.ServletException;

/**
 *
 * @author Reinaldo Junio Dias de Abreu <rjdda at aluno.ifnmg.edu.br>
 */
@Named
@RequestScoped
public class UserController {
    
    @Inject
    PessoaBeanLocal pessoaBean;
    
    @Inject
    SecurityContext securityContext;
    
    @Inject
    FacesContext facesContext; 
    
    private Optional<Pessoa> currentUser;
    
    private Optional<String> tipo;
    
    @PostConstruct
    public void initialize() {
        String username = securityContext.getCallerPrincipal().getName();
        System.out.println("Usuário Logado: " + username);
        
        this.currentUser = pessoaBean.findPessoaByEmail(username);
        System.out.println("Usuário Logado: " + currentUser);
        
        /*
        this.currentUser.ifPresent(user -> {
            this.tipo = pessoaBean.findTipoPessoa(user.getEmail());
        });*/
    }

    public Pessoa getCurrentUser() {
        return currentUser.orElse(null);
    }

    public String getCurrentGrupo() {
        return tipo.orElse(null);
    }

    public boolean isAuthenticated() {
        return securityContext.getCallerPrincipal() != null;
    }

    public String logout() throws ServletException {
        facesContext.getExternalContext()
                .invalidateSession();
        return "/index?faces-redirect=true";
    }
}
