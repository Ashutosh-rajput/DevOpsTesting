package com.traning.testing.Controller;

import com.traning.testing.DTO.UserDTO;
import com.traning.testing.Entity.UserInfo;
import com.traning.testing.Service.ServiceImpl.UserInfoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoImpl userInfoImpl;

    @GetMapping("/welcome")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String welcome(Model model){
        model.addAttribute("message","Welcome this endpoint is freeeee.... and checkinh ");
        return "welcome checking some more changes added webhooks 3";
    }



    @GetMapping("/get-users")
    public List<UserInfo> getAllUsers(){
        List<UserInfo> users=userInfoImpl.getAllUsers();
        return users;
    }

    @GetMapping("/get-user/{id}")
    public UserInfo getuser(@PathVariable Long id ){
        return userInfoImpl.getUserById(id);

    }

    @PostMapping("/add-user")
    public UserDTO createuser(@RequestBody UserDTO userDTO){
        return userInfoImpl.createUser( userDTO);

    }
    @PutMapping("/update")
    public UserDTO updateUser(@RequestBody UserDTO userDTO,Long Id){
        return userInfoImpl.updateUser(userDTO,Id);
    }

    @DeleteMapping("/delete")
    public UserDTO deleteUser(@RequestBody UserDTO userDTO){
        return userInfoImpl.deleteUser(userDTO);
    }

    @DeleteMapping("/deletebyid/{id}")
    public UserDTO deleteUserbyid(@RequestBody Long Id){
        return userInfoImpl.deleteUserById(Id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteUser(){
        return userInfoImpl.deleteAllUsers();
    }



}
