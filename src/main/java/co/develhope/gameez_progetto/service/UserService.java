package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.entity.User;
import co.develhope.gameez_progetto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAllByStatusUserTrue();
    }

    public Optional<User> findById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            return userOptional;
        } else {
            return Optional.empty();
        }
    }

    public Optional<User> updateUser(Long id, User updateUser){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            userOptional.get().setNome(updateUser.getNome());
            userOptional.get().setCognome(updateUser.getCognome());
            userOptional.get().setNickName(updateUser.getNickName());
            userOptional.get().setEmail(updateUser.getEmail());
            userOptional.get().setPassword(updateUser.getPassword());
            userOptional.get().setDataNascita(updateUser.getDataNascita());
            userOptional.get().setCitta(updateUser.getCitta());
            userOptional.get().setIndirizzo(updateUser.getIndirizzo());
            User user = userRepository.save(userOptional.get());
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    public Optional<User> deleteLogicalUser(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setStatusUser(false);
            userRepository.save(user);
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    public Optional<User> activeStatusUser(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setStatusUser(true);
            userRepository.save(user);
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
