package com.zac.flycloud.service;

import com.zac.flycloud.SampleAuthenticationManager;
import com.zac.flycloud.dao.UserDao;
import com.zac.flycloud.entity.tablemodel.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service("securityUserService")
public class SecurityUserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 根据用户名查询用户
        SysUser user = userDao.getUserByName(s);
        Assert.notNull(user,"用户不存在");
        // 查询用户权限
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Authentication request = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication result = new SampleAuthenticationManager().authenticate(request);
        SecurityContextHolder.getContext().setAuthentication(result);
        return new User(user.getUsername(),user.getPassword(),user.getEnableStatus(),true,true,true,authorities);
    }
}
