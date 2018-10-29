package com.products.meli.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserUtil {

    public String getAccessToken () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();

        return accessToken;
    }

    public String getUserId () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getPrincipal().toString();

        return userId;
    }
}
