package UHDBONF.service;

import UHDBONF.domain.entity.User;
import UHDBONF.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    String registerUser(UserDto userDto);
    UserDto findUserByTid(String tid);
    UserDto findUserByUid(String uid);
    List<User> findAllUsers();
    Boolean existsByUid(String uid);
}
