package UHDBONF.controller;

import UHDBONF.domain.dto.UserDto;
import UHDBONF.domain.entity.User;
import UHDBONF.service.UserProcess;
import UHDBONF.service.UserService;
import UHDBONF.service.logic.UserServiceLogic;
import UHDBONF.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("u/users")
public class UserController {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserProcess userProcess;

    @PostMapping
    public String registerUser(@RequestBody UserDto userDto) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return userService.registerUser(userDto);
    }

     @GetMapping("itd/{tid}")
     public UserDto findUserByTid(@PathVariable(name="tid") String tid){
        return userProcess.findUserByTid(tid);
     }

     @GetMapping("uid/{uid}")
     public UserDto findUserByUid(@PathVariable(name="uid") String uid){
        return userProcess.findUserByUid(uid);
     }

     @GetMapping("uid/{uid}/open")
     public UserDto findOpenUserByUid(@PathVariable(name="uid") String uid){
        return userProcess.findOpenUserByUid(uid);
     }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

}
