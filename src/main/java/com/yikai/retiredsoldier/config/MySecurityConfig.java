package com.yikai.retiredsoldier.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yikai.retiredsoldier.entity.User;
import com.yikai.retiredsoldier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description springsecurity配置类
 * @Author yikai.wang
 * @Date 2019/2/18 8:40
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    //下面都是不会用的东西,日后研究
//    @Autowired
//    private CustomUserService customUserService;
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider
//                = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(customUserService);
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(11);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);

        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/druid/**").permitAll()
                .antMatchers("/soldier/**").hasRole("退役士兵")
                .antMatchers("/business/**", "/recruit/**", "/train/**").hasRole("企业")
                .antMatchers("/administrator/**").hasRole("管理员")
                //对druid关闭CSRF
        .and().csrf().ignoringAntMatchers("/druid/**");


        //开启自动配置的的登录功能`默认请求的是/login  如果没有权限就会跳到springsecurity的登录页面
        http.formLogin();
//        http.formLogin().loginPage("/login");


        //开启自动配置的注销功能   注销后回到登录页
        http.logout().logoutSuccessUrl("/").permitAll();


        //开启记住我
        http.rememberMe().rememberMeParameter("rem");
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);

        /**
         * @Date:2019/2/18 10:24 @Auth:yikai.wang @Desc(V/B):〈这里要注意 spring security新增了多重加密方式,所以密码要采用一种加密进行存储〉
         */
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("default").password(new BCryptPasswordEncoder().encode("default")).roles("退役士兵", "企业")
                .and().passwordEncoder(new BCryptPasswordEncoder()).withUser("soldier").password(new BCryptPasswordEncoder().encode("soldier")).roles("退役士兵");

//        auth.userDetailsService(new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//                EntityWrapper<User> wrapper = new EntityWrapper<>();
//                wrapper.eq("username",name);
//                return userService.selectOne(wrapper);
//            }
//        }).passwordEncoder(new BCryptPasswordEncoder());

        //auth.userDetailsService(customUserService()); //user Details Service验证
    }
}
