package com.tuyano.springboot.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tuyano.springboot.data.UserData;
import com.tuyano.springboot.repositories.AccountRepository;
@Service
public class AccountService implements UserDetailsService {
  @Autowired
  private AccountRepository accRepo;
  @Override
  public UserDetails loadUserByUsername(String username)
          throws UsernameNotFoundException {
      if ( username == null || username.isEmpty() ){
          throw new UsernameNotFoundException("username is empty");
      }

      UserData foundUser = accRepo.findById(username);
      if( foundUser != null ){
          return foundUser.toMyUserDetail();
      }
      throw new UsernameNotFoundException( username + "is not found");
  }
}