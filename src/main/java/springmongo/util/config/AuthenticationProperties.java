package springmongo.util.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix="brm.security")
public class AuthenticationProperties
{
    private List<AuthenticationConfig> apps = new ArrayList<>();

    public List<AuthenticationConfig> getApps()
    {
        return apps;
    }

    public void setApps(List<AuthenticationConfig> apps)
    {
        this.apps = apps;
    }

    public static class AuthenticationConfig
    {
        private String clientId;
        private String clientSecret;
        private String redirectUri;

        public String getClientId()
        {
            return clientId;
        }
        public void setClientId(String clientId)
        {
            this.clientId = clientId;
        }
        public String getClientSecret()
        {
            return clientSecret;
        }
        public void setClientSecret(String clientSecret)
        {
            this.clientSecret = clientSecret;
        }
        public String getRedirectUri()
        {
            return redirectUri;
        }
        public void setRedirectUri(String redirectUri)
        {
            this.redirectUri = redirectUri;
        }
    }

    public AuthenticationConfig getAuthenticationConfig(String clientId)
    {
        return apps.stream().filter(x -> x.getClientId().equals(clientId)).findFirst().get();
    }

}