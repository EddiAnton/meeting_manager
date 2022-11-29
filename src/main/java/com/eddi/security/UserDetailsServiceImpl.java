package com.eddi.security;

import com.eddi.converter.UserConverter;
import com.eddi.model.Employee;
import com.eddi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserConverter userConverter;
    private final EmployeeRepository employeeRepo;

    @Autowired
    public UserDetailsServiceImpl(EmployeeRepository employeeRepo, UserConverter userConverter) {
        this.employeeRepo = employeeRepo;
        this.userConverter = userConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employee employee = employeeRepo.findByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException("Пользователь не найден"));
        return userConverter.fromEmployee(employee);
    }
}
