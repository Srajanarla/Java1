package config;
////
////import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.example.parctical3.entity.User;
//
////import com.example.parctical3.entity.User;
//
////import org.springframework.beans.factory.annotation.Value;
////
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
////        http
////                .oauth2Client()
////                    .and()
////                .oauth2Login()
////                .tokenEndpoint()
////                    .and()
////                .userInfoEndpoint();
////
////        http
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
////
////        http
////                .authorizeHttpRequests()
////                           .requestMatchers("/unauthenticated", "/oauth2/**", "/login/**").permitAll()
////                            .anyRequest()
////                            .fullyAuthenticated()
////              .and()
////                    .logout()
////                    .logoutSuccessUrl("http://localhost:8080/realms/external/protocol/openid-connect/logout?redirect_uri=http://localhost:8081/");
////
////       return http.build();
////    }
////}
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.oauth2.jwt.Jwt;
////import org.springframework.security.oauth2.jwt.JwtDecoder;
////import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
////import java.time.Instant;
////
////
////@Configuration
////@EnableGlobalMethodSecurity(jsr250Enabled=true)
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
////        return httpSecurity.cors(Customizer.withDefaults())
////                .csrf(CsrfConfigurer::disable)
////                .authorizeHttpRequests(httpRequests -> httpRequests.anyRequest().authenticated())
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////                .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults()))
////                .build();
////    }
////    @Value("${http://localhost:8080/auth/realms/myrealm}")
////    private String issuerUri; // Replace with your Keycloak issuer URI
////
////    @Bean
////    public JwtDecoder jwtDecoder() {
////        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(issuerUri + "/protocol/openid-connect/certs")
////                .build();
////
////        jwtDecoder.setJwtValidator(token -> {
////            Instant expirationTime = token.getExpiresAt();
////            Instant currentTime = Instant.now();
////            if (expirationTime != null && currentTime.isAfter(expirationTime)) {
////                // Token is expired
////                throw new RuntimeException("Access token has expired");
////            }
////            return null;
////        });
////
////        return jwtDecoder;
////    }
////}
//
//
////import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
////import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
////import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Import;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.core.session.SessionRegistry;
////import org.springframework.security.core.session.SessionRegistryImpl;
////import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
////import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
////
////@KeycloakConfiguration
////@Import(KeycloakSpringBootConfigResolver.class)
////public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter
////{
////    /**
////     * Registers the KeycloakAuthenticationProvider with the authentication manager.
////     */
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(keycloakAuthenticationProvider());
////    }
////
////    /**
////     * Defines the session authentication strategy.
////     */
////    @Bean
////    @Override
////    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
////        return new RegisterSessionAuthenticationStrategy(buildSessionRegistry());
////    }
////
////    @Bean
////    protected SessionRegistry buildSessionRegistry() {
////        return new SessionRegistryImpl();
////    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception
////    {
////        super.configure(http);
////        http.csrf()
////                .disable()
////                .authorizeRequests()
////                .requestMatchers("/error").permitAll()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////    }
////}
//
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////	
////	@Bean
////	public UserDetailsService userDetailsService() {
////		UserDetails admin=User.builder().username("user1")
////				.password(passwordEncoder().encode("user1"));
////				.roles("user")
////				.build();
////		UserDetails user=User.withUsername("user1")
////				.password(encoder.encode("user1"))
////				.roles("user")
////				.build();
////		return new InMemoryUserDetailsManager(admin);
////	}
////	
////	@Bean
////	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////		return http.csrf((csrf) -> csrf.disable())
////				.authorizeHttpRequests((authorize) -> authorize 
////				.requestMatchers("/allbook").permitAll())
////				
////				.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/**").authenticated())
////				.formLogin()
////				.build();
////	}
////	@Bean
//// 	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//// 		http
//// 			.authorizeHttpRequests((authorizeHttpRequests) ->
//// 				authorizeHttpRequests
//// 					.requestMatchers("/**").hasRole("USER")
//// 			)
//// 			.formLogin(withDefaults());
//// 		return http.build();
//// 	}
////
////
////	private Customizer<FormLoginConfigurer<HttpSecurity>> withDefaults() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//	
////	@Bean
////	public PasswordEncoder passwordEncoder() {
////		return new BCryptPasswordEncoder();
////		
////	}
////}
////
//
////import com.javatechie.filter.JwtAuthFilter;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.AuthenticationProvider;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
////import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
////import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
////
////@Configuration
////@EnableWebSecurity
////@EnableMethodSecurity
////public class SecurityConfig {
////    @Autowired
////    private JwtAuthFilter authFilter;
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return new UserInfoUserDetailsService();
////    }
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////                 http.csrf((csrf) -> csrf.disable())
////                .authorizeHttpRequests((authorize) -> authorize
////                .requestMatchers("/products/signUp","/products/login","/products/refreshToken").permitAll())
////                .and()
////                .authorizeHttpRequests((authorize) -> authorize.requestMatchers("/products/**")
////                .authenticated()).and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .authenticationProvider(authenticationProvider())
////                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
////                return http.build();
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    public AuthenticationProvider authenticationProvider(){
////        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//////        authenticationProvider.setUserDetailsService(userDetailsService());
////        authenticationProvider.setPasswordEncoder(passwordEncoder());
////        return authenticationProvider;
////    }
////    @Bean
////    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
////        return config.getAuthenticationManager();
////    }
////
////}