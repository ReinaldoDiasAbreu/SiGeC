/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sigec.auth;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author alex
 */

@Named
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:/SistemaDS",
        callerQuery = "select senha from tbl_pessoa "
        + "where email = ?",
        groupsQuery = "select grupo from tbl_pessoa "
        + "where email = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        hashAlgorithmParameters = {
            "Pbkdf2PasswordHash.Iterations=3071",
            "${securityConfig.dyna}"
        }
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/index.xhtml",
                errorPage = "",
                useForwardToLogin = false
        )
)
@FacesConfig
@ApplicationScoped
public class SecurityConfig {

    public String[] getDyna() {
        return new String[]{
            "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512", 
            "Pbkdf2PasswordHash.SaltSizeBytes=64"};
    }
}

