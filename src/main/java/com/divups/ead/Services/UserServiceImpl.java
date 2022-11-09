package com.divups.ead.Services;

import com.divups.ead.Entity.UserEntity;
import com.divups.ead.Model.User;
import com.divups.ead.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){this.userRepository = userRepository;}

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> usersEntities = userRepository.findAll();
        List<User> users = usersEntities.stream().map(usr -> new User(usr.getUser_id(),
                           usr.getUsername(),
                           usr.getFirstname(),
                           usr.getLastname(),
                           usr.getUser_role(),
                           usr.getEmail(),usr.getPassword(),usr.getUser_createdat())).collect(Collectors.toList());
        return users;
    }

    @Override
    public User getUserById(Integer id) {
        UserEntity userEntity = userRepository.findById(id).get();
        User user = new User();
        BeanUtils.copyProperties(userEntity,user);

        return user;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user , userEntity);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public User updateUsers(Integer id, User user) {
        UserEntity userEntity =  userRepository.findById(id).get();
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());
        userEntity.setUser_role(user.getUser_role());
        userRepository.save(userEntity);


        return user;
    }

    @Override
    public boolean userDeleted(Integer id) {
        try {
            UserEntity userEntity = userRepository.findById(id).get();
            userRepository.delete(userEntity);
            return true;
        }catch (Exception x){
            return false;
        }
    }
}
