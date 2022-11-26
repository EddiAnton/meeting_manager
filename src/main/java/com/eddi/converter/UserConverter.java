package com.eddi.converter;

import com.eddi.model.Employee;
import com.eddi.model.Status;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDetails fromEmployee(Employee employee) {
        return new User(
                employee.getLogin(),
                employee.getPassword(),
                employee.getStatus().equals(Status.ACTIVE),
                employee.getStatus().equals(Status.ACTIVE),
                employee.getStatus().equals(Status.ACTIVE),
                employee.getStatus().equals(Status.ACTIVE),
                employee.getRole().getAuthorities()
        );
    }
}
