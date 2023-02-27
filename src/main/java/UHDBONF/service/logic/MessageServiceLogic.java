package UHDBONF.service.logic;

import UHDBONF.domain.dto.MessageDto;
import UHDBONF.domain.dto.UserDto;
import UHDBONF.service.MessageService;
import UHDBONF.store.MessageStore;
import UHDBONF.store.UserStore;
import UHDBONF.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceLogic implements MessageService {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageServiceLogic.class);
    @Autowired
    private MessageStore messageStore;
    @Autowired
    private UserStore userStore;

    @Override
    public String registerMessage(MessageDto messageDto) {
        // 글자 수 제한 - 140자
        if (messageDto.getContent().length() > 140) {
            if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("140자 이상의 메세지는 작성 할 수 없습니다.");
        }
            throw ExceptionUtil.createOnfBizException("140자 이상의 메세지는 작성 할 수 없습니다.");
        }

        // 사용자가 작성한 것 중에 공개 상태 메세지가 있으면 작성 불가
        if (this.findAllOpenMessageByTid(messageDto.getUser().getTid()).size() > 0) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("이미 작성한 메세지가 있습니다.");
            }
            throw ExceptionUtil.createOnfBizException("이미 작성한 메세지가 있습니다.");
        }
        // 사용자 셋팅
        UserDto userDto = userStore.readByTid(messageDto.getUser().getTid());
        if (userDto==null) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("등록되지 않은 사용자입니다.");
            }
            throw ExceptionUtil.createOnfBizException("등록되지 않은 사용자입니다.");
        }
        messageDto.setUser(userDto);

        // 현재시간 셋팅
        LocalDateTime now = LocalDateTime.now();
        messageDto.setCreated(now);
        messageDto.setUpdated(now);

        // 공개
        messageDto.setExpose(true);

        return messageStore.create(messageDto);
    }

    @Override
    public String registerMessageByTid(String tid, MessageDto messageDto) {
        // 글자 수 제한- 140자
        if (messageDto.getContent().length() > 140) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("140자 이상의 메세지는 작성 할 수 없습니다.");
            }
            throw ExceptionUtil.createOnfBizException("140자 이상의 메세지는 작성 할 수 없습니다.");
        }

        // 사용자가 작성한 것 중에 공개 상태 메세지가 있으면 작성 불가
        if (this.findAllOpenMessageByTid(tid).size() > 0) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("이미 작성한 메세지가 있습니다.");
            }
            throw ExceptionUtil.createOnfBizException("이미 작성한 메세지가 있습니다.");
        }

        // 사용자 셋팅
        UserDto userDto = userStore.readByTid(tid);
        if (userDto==null) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("등록되지 않은 사용자입니다.");
            }
            throw ExceptionUtil.createOnfBizException("등록되지 않은 사용자입니다.");
        }
        messageDto.setUser(userDto);

        // 현재시간 셋팅
        LocalDateTime now = LocalDateTime.now();
        messageDto.setCreated(now);
        messageDto.setUpdated(now);

        // 공개
        messageDto.setExpose(true);

        return messageStore.create(messageDto);
    }

    @Override
    public String registerMessageByUserUid(String userUid, MessageDto messageDto) {

        // 글자 수 제한- 140자
        if (messageDto.getContent().length() > 140) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("140자 이상의 메세지는 작성 할 수 없습니다.");
            }
            throw ExceptionUtil.createOnfBizException("140자 이상의 메세지는 작성 할 수 없습니다.");
        }

        // 사용자가 작성한 것 중에 공개 상태 메세지가 있으면 작성 불가
        if (this.findAllOpenMessageByUserUid(userUid).size() > 0) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("이미 작성한 메세지가 있습니다.");
            }
            throw ExceptionUtil.createOnfBizException("이미 작성한 메세지가 있습니다.");
        }

        // 사용자 셋팅
        UserDto userDto = userStore.readByUid(userUid);
        if (userDto==null) {
            if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("등록되지 않은 사용자입니다.");
        }
            throw ExceptionUtil.createOnfBizException("등록되지 않은 사용자입니다.");
        }
        messageDto.setUser(userDto);

        // 현재시간 셋팅
        LocalDateTime now = LocalDateTime.now();
        messageDto.setCreated(now);
        messageDto.setUpdated(now);

        // 공개
        messageDto.setExpose(true);

        return messageStore.create(messageDto);
    }

    @Override
    public MessageDto findMessageByUid(String uid) {
        return messageStore.readByMessageUid(uid);
    }

    @Override
    public MessageDto findByUserId(String userId) {
        return messageStore.readByUserId(userId);
    }

    @Override
    public List<MessageDto> findAllMessagesByTid(String tid) {
        return messageStore.readAllByTid(tid);
    }

    @Override
    public List<MessageDto> findAllMessagesByUserUid(String userUid) {
        return messageStore.readAllByUserUid(userUid);
    }

    @Override
    public List<MessageDto> findAllMessagesOrderByCreatedAtDesc() {
        return messageStore.readAllMessagesOrderByCreatedAtDesc();
    }

    @Override
    public List<MessageDto> findAllOpenMessagesOrderByCreatedAtDesc() {
        return messageStore.readAllOpenMessagesOrderByCreatedAtDesc();
    }

    @Override
    public List<MessageDto> findAllMessagesByPage(int size) {
        return messageStore.readAllMessagesBySize(size);
    }

    @Override
    public List<MessageDto> findAllOpenMessagesByPage(int size) {
        return messageStore.readAllOpenMessagesBySize(size);
    }

    @Override
    public List<MessageDto> findAllOpenMessageByTid(String tid) {
        return messageStore.readAllOpenMessageByTid(tid);
    }

    @Override
    public List<MessageDto> findAllOpenMessageByUserUid(String userUid) {
        return messageStore.readAllOpenMessageByUserUid(userUid);
    }

    @Override
    public String modifyMessageCloseByUid(String uid) {
        MessageDto messageDto = messageStore.readByMessageUid(uid);

        LocalDateTime now = LocalDateTime.now();
        messageDto.setUpdated(now);
        messageDto.setExpose(false);
        return messageStore.create(messageDto);
    }

    @Override
    public String modifyMessageOpenByUid(String uid) {
        MessageDto messageDto = messageStore.readByMessageUid(uid);

        // 사용자가 작성한 메세지 중에 이미 공개 된 것이 있으면 예외
        if (this.findAllOpenMessageByTid(messageDto.getUser().getTid()).size() > 0) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("이미 작성한 메세지가 있습니다.");
            }
            throw ExceptionUtil.createOnfBizException("이미 작성한 메세지가 있습니다.");
        }

        LocalDateTime now = LocalDateTime.now();
        messageDto.setUpdated(now);
        messageDto.setExpose(true);
        return messageStore.create(messageDto);
    }
}
