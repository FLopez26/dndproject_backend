package com.fls.DnDCharacterTool_Backend.service;

import com.fls.DnDCharacterTool_Backend.model.User;
import com.fls.DnDCharacterTool_Backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    updatedUser.setUserId(id);
                    return userRepository.save(updatedUser);
                })
                .orElse(null);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
