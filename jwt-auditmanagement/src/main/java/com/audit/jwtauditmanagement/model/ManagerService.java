package com.audit.jwtauditmanagement.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.audit.jwtauditmanagement.model.AuditManager;
import com.audit.jwtauditmanagement.repository.ManagerRepo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ManagerService implements UserDetailsService {
	
	@Autowired
	ManagerRepo managerRepo;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AuditManager manager = managerRepo.findById(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with username " + username));
		 log.debug("End : {}", "loadUserByUsername");
		return new User(manager.getUserId(), manager.getPassword(), new ArrayList<>());
	}

	public void saveUser(AuditManager auditManager) {

		managerRepo.save(auditManager);
	}

}

