package org.jetbrains.kotlin.demo

import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken

class GreetingService: AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
    override fun loadUserDetails(token: PreAuthenticatedAuthenticationToken?): UserDetails {
        var credential = token?.credentials.toString()
        if (credential.isEmpty()) {
           throw UsernameNotFoundException("Authorization header must not be empty")
        }

        return User("user", "", AuthorityUtils.createAuthorityList("GREET"))
    }
}