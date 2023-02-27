package UHDBONF.service;

import UHDBONF.domain.dto.UserDto;

public interface UserProcess {
    UserDto findUserByTid(String tid);
    UserDto findUserByUid(String uid);
    UserDto findOpenUserByUid(String uid);
}
