package org.resthub.booking.web;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.booking.model.User;
import org.resthub.booking.repository.UserRepository;
import org.resthub.web.controller.GenericControllerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Guillaume Zurbach
 */
@Controller @RequestMapping("/api/user")
public class UserController extends GenericControllerImpl<User, Long, UserRepository> {

    @Inject
    @Named("userRepository")
    @Override
    public void setRepository(UserRepository userRepository) {
        this.repository = userRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "username/{username}") @ResponseBody
    public User findByUsername(@PathVariable("username")String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Long getIdFromEntity(User user) {
        return user.getId();
    }

}
