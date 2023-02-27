package UHDBONF.service.logic;

import UHDBONF.domain.dto.LuckyDrawDto;
import UHDBONF.domain.dto.MessageDto;
import UHDBONF.domain.dto.UserDto;
import UHDBONF.service.LuckyDrawService;
import UHDBONF.service.MessageService;
import UHDBONF.service.UserProcess;
import UHDBONF.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProcessLogic implements UserProcess {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private LuckyDrawService luckyDrawService;

    @Override
    public UserDto findUserByTid(String tid) {
        UserDto userDto = userService.findUserByTid(tid);

        List<MessageDto> messageDto = messageService.findAllMessagesByTid(userDto.getTid());
        List<LuckyDrawDto> luckyDrawDto = luckyDrawService.findAllLuckyDrawByTid(userDto.getTid());

        userDto.setMessage(messageDto);
        userDto.setLuckyDraws(luckyDrawDto);

        return userDto;
    }

    @Override
    public UserDto findUserByUid(String uid) {
        UserDto userDto = userService.findUserByUid(uid);

        List<MessageDto> messageDto = messageService.findAllMessagesByUserUid(userDto.getUid());
        List<LuckyDrawDto> luckyDrawDto = luckyDrawService.findAllLuckyDrawByUserUid(userDto.getUid());

        userDto.setMessage(messageDto);
        userDto.setLuckyDraws(luckyDrawDto);

        return userDto;
    }

    @Override
    public UserDto findOpenUserByUid(String uid) {
        UserDto userDto = userService.findUserByUid(uid);

        List<MessageDto> messageDto = messageService.findAllOpenMessageByUserUid(userDto.getUid());
        List<LuckyDrawDto> luckyDrawDto = luckyDrawService.findAllOpenLuckyDrawByUserUid(userDto.getUid());

        userDto.setMessage(messageDto);
        userDto.setLuckyDraws(luckyDrawDto);

        return userDto;
    }

}
