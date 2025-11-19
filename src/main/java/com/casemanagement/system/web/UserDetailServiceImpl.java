package com.casemanagement.system.web;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Service;

import com.casemanagement.system.model.AppUser;
import com.casemanagement.system.model.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  private final AppUserRepository appuserrepo;

  public UserDetailServiceImpl(AppUserRepository appuserrepo) {
    this.appuserrepo = appuserrepo;
  }

  public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{

    AppUser curuser =appuserrepo.findByUsername(username);
    UserDetails user = new org.springframework.security.core.userdetails.User(username,curuser.getPasswordHash(),AuthorityUtils.createAuthorityList(curuser.getRole()));

    return user;
   }
  

}
