package com.residencia.ecommerce.config;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Arrays;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable();
//    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(""));
        configuration.setAllowedMethods(Arrays.asList(""));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    private static final String USUARIO_POR_LOGIN = "SELECT username, senha, 'true' as enable FROM cliente WHERE username=?";

    private static final String USUARIO_AUTHORITY = "SELECT username, 'ROLE_USER' as authority FROM cliente WHERE username=?";

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery(USUARIO_POR_LOGIN)
                .authoritiesByUsernameQuery(USUARIO_AUTHORITY)
                .rolePrefix("ROLE_USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/cliente/save").permitAll()
                .antMatchers(HttpMethod.GET, "/cliente/retornaconta/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/categoria/{categoria}").permitAll()
                .antMatchers(HttpMethod.GET,"/categoria").permitAll()
                .antMatchers(HttpMethod.POST, "/categoria/save").permitAll()
                .antMatchers(HttpMethod.PUT,"/categoria/update").permitAll()
                .antMatchers(HttpMethod.DELETE,"/categoria/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/produto/{produto}").permitAll()
                .antMatchers(HttpMethod.GET,"/produto/vizualizar-produtos").permitAll()
                .antMatchers(HttpMethod.POST,"/produto/save-produto").permitAll()
                .antMatchers(HttpMethod.PUT,"/produto/editar-produto").permitAll()
                .antMatchers(HttpMethod.DELETE,"/produto/delete-produto/{produtoId}").permitAll()
                .antMatchers(HttpMethod.GET,"/pedido/vizualizar-pedidos").permitAll()
                .antMatchers(HttpMethod.DELETE,"/pedido/delete-pedido/{id}").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }




}