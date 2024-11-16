package org.mass.Doctor_service.sec;





import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = Stream.concat(
                jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                extractResourceRoles(jwt).stream()
        ).collect(Collectors.toSet());
        return new JwtAuthenticationToken(jwt, authorities, jwt.getClaim("preferred_username"));
    }

    private Collection<GrantedAuthority> extractResourceRoles(Jwt jwt) {
        Map<String, Object> resourceAccess;
        Collection<String> roles;
        if (jwt.getClaim("resource_access") == null) {
            return Set.of();
        }

        // Récupérer l'objet "doctor-client" dans "resource_access"
        resourceAccess = (Map<String, Object>) jwt.getClaim("resource_access");

        // Vérifier si "doctor-client" existe et extraire les rôles
        if (resourceAccess.containsKey("doctor-client")) {
            Map<String, Object> doctorClientAccess = (Map<String, Object>) resourceAccess.get("doctor-client");
            roles = (Collection<String>) doctorClientAccess.get("roles");
            return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
        }

        return Set.of();
    }
}
