package ro.utcn.sd.cata.dailyFit.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.utcn.sd.cata.dailyFit.service.UserDetailService;

//@Configuration
//@RequiredArgsConstructor
public class SecurityConfiguration
       // extends WebSecurityConfigurerAdapter
{
//    private final UserDetailService userDetailService;
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/test/*");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated().and()
//                .httpBasic().and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .cors().and()
//                .csrf().disable();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}