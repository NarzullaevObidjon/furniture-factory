package com.company.furniturefactory.config.security;


import com.company.furniturefactory.dao.AuthUserDAO;
import com.company.furniturefactory.domain.AuthUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthUserDAO authUserDao;

    public CustomUserDetailsService(AuthUserDAO authUserDao) {
        this.authUserDao = authUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found by username '%s'".formatted(username)));
        System.out.println(authUser.getUsername());
        return new CustomUserDetails(authUser);
    }
}
