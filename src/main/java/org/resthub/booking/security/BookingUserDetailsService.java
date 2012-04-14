package org.resthub.booking.security;


import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.booking.model.User;
import org.resthub.booking.repository.UserRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Service allowing to store, retrive and check credential from application
 * services for a user provided by spring-security. Password check is done by
 * spring.
 * 
 * Initializing authorities
 */
@Named("bookingUserDetailsService")
public class BookingUserDetailsService implements UserDetailsService {

	@Inject
	@Named("userRepository")
	private UserRepository userRepository;

	@SuppressWarnings("unused")
	private PasswordEncoder encoder;
	
	public BookingUserDetailsService() {
		
	}

	public BookingUserDetailsService(UserRepository userRepository, PasswordEncoder encoder) {
		super();
		this.userRepository = userRepository;
		this.encoder = encoder;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException, DataAccessException {

		User user = userRepository.findByUsername(name);

		if (null == user) {
			throw new UsernameNotFoundException("user not found in database");
		}

		BookingUserDetails securedUser = new BookingUserDetails(name);
		securedUser.setPassword(user.getPassword());
		securedUser.addAuthority(new GrantedAuthorityImpl("ROLE_AUTH"));

		return securedUser;

	}
}
