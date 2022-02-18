package com.example.configuration;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {


@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    UserRepository urep;
//
@Autowired
private DataSource dataSource;
//
//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//
private UserDetailsService userDetailsService;

@Autowired
private UserService userService;
Authentication auth = SecurityContextHolder.getContext().getAuthentication();


@Bean
public BCryptPasswordEncoder passwordEncoder() {
BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
return bCryptPasswordEncoder;
}
private static final String SQL_ROLE
="select name, role from users where name=?";

private static final String SQL_LOGIN
= "select name, password, active from users where name=?";




@Override
protected void configure(AuthenticationManagerBuilder auth)
throws Exception
{
auth.
jdbcAuthentication()
.dataSource(dataSource)
.usersByUsernameQuery(SQL_LOGIN)
.authoritiesByUsernameQuery(SQL_ROLE)
.dataSource(dataSource)
.passwordEncoder(bCryptPasswordEncoder)
;
}

@Override
protected void configure(HttpSecurity http) throws Exception {

http.csrf().disable();


http.authorizeRequests()
.antMatchers("/plugins/**","/css/**","/bootstrap/**","/js/**","/css/**","/fonts/**","/actuator").permitAll()
.antMatchers("/dashboard/index","/index/index","/spare_part","/PM","/Departemen","/jadwal","/asset","/histori","/work_orders","/t_biaya","/work_order","/moveout","/header_moveout","/report","/failur","/MtbfMttr","/takeover","/breakdown_header","/OnhandInventory","/dashboard","/Location","/Account","/vendor","/Inventory","/pekerja","/cost_doc","/registration","/Items","/Formula","/header_bom","/Tr_asset","/journal").hasRole("ADMIN")
.antMatchers("/service_request","/purc_req").hasRole("USER")
.antMatchers("/").hasRole("ENDPOINT_ADMIN")
.anyRequest().authenticated()
.and()
.formLogin()
.loginPage("/login")
.permitAll()
.usernameParameter("name")
.passwordParameter("password")
.defaultSuccessUrl("/index").successHandler(successHandler())
.permitAll()
.and()
.logout()
.permitAll();
}
@Bean
public AuthenticationSuccessHandler successHandler()
{
return new MySimpleUrlAuthenticationSuccessHandler();
}
}
