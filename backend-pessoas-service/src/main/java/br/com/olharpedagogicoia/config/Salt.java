package br.com.olharpedagogicoia.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "senha")
@Getter
@Setter
public class Salt {
    public String salt;
}
