package org.jetbrains.kotlin.demo

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import javax.servlet.http.HttpServletRequest

class GreetingFilter: AbstractPreAuthenticatedProcessingFilter() {
    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest?): Any = ""

    override fun getPreAuthenticatedCredentials(request: HttpServletRequest?): Any =
            request?.getHeader("X-Authorization").orEmpty()
}