package ro.utcn.sd.cata.dailyFit.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.cata.dailyFit.exception.UserNotFoundException;
import ro.utcn.sd.cata.dailyFit.repository.UserRepository;

import java.util.Collections;

public class UserDetailService
       // implements UserDetailsService
{
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserDetailService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        ro.utcn.sd.cata.dailyFit.entity.User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
//        return new User(user.getName(), user.getPassword(),
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
//    }
//
//    @Transactional
//    public ro.utcn.sd.cata.dailyFit.entity.User loadCurrentUser() {
//        String name = SecurityContextHolder.getContext().getAuthentication().getName();
//        return userRepository.findByUsername(name).orElseThrow(UserNotFoundException::new);
//    }
}