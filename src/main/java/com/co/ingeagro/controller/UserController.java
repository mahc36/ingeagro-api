package com.co.ingeagro.controller;

import com.co.ingeagro.model.User;
import com.co.ingeagro.service.user.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;


// http://localhost:8383/user/save

@Data
@RestController
@RequestMapping( path = ControllerConstants.User.ROOT_REQUEST )
@CrossOrigin( origins = ControllerConstants.REQUEST_ORIGIN )
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value= ControllerConstants.User.LOGIN ,method = RequestMethod.POST)
    public User login(@RequestBody final User user){
        return userService.login(user);
    }

    @RequestMapping(value= ControllerConstants.SAVE ,method = RequestMethod.POST)
    public User save(@RequestBody final User user) {
        return userService.save(user);
    }

    @RequestMapping(value= ControllerConstants.UPDATE ,method = RequestMethod.PATCH)
    public User update(@RequestBody final User user) {
        return userService.update(user);
    }

    @RequestMapping(value= ControllerConstants.FIND_BY_ID ,method = RequestMethod.GET)
    public User findById(@Param("id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value= ControllerConstants.User.FIND_BY_USERNAME ,method = RequestMethod.GET)
    public User findByUsername(@Param("username") String username) {
        return userService.findByUsername(username);
    }

    @RequestMapping(value= ControllerConstants.FIND_ALL ,method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

}
