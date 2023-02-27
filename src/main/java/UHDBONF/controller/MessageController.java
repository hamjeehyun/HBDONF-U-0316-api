package UHDBONF.controller;

import UHDBONF.domain.dto.MessageDto;
import UHDBONF.service.MessageProcess;
import UHDBONF.service.MessageService;
import UHDBONF.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("u/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageProcess messageProcess;

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    /**
     * 메세지 등록
     * @param messageDto
     * @return
     */
    @PostMapping
    public String registerMessage( @RequestBody MessageDto messageDto) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return messageService.registerMessage(messageDto);
    }

    /**
     * 메세지 등록 by tid
     * @param tid
     * @param messageDto
     * @return
     */
    @PostMapping("tid/{tid}")
    public String registerMessageByTid(@PathVariable(name="tid") String tid,
                                       @RequestBody MessageDto messageDto) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return messageService.registerMessageByTid(tid, messageDto);
    }

    /**
     * 메세지 등록 by user-uid
     * @param userUid
     * @param messageDto
     * @return
     */
    @PostMapping("user-uid/{user-uid}")
    public String registerMessageByUserUid(@PathVariable(name = "user-uid") String userUid,
                                       @RequestBody MessageDto messageDto) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return messageService.registerMessageByUserUid(userUid, messageDto);
    }

    /**
     * 메세지 조회 by uid
     * @param uid
     * @return
     */
    @GetMapping("uid/{uid}")
    public MessageDto findMessageByUid(@PathVariable(name = "uid") String uid) {
        return messageService.findMessageByUid(uid);
    }

    /**
     * 사용자가 등록한 모든 메세지 조회 by tid
     * @param tid
     * @return
     */
    @GetMapping("tid/{tid}")
    public List<MessageDto> findAllMessageByTid(@PathVariable(name = "tid") String tid) {
        return messageService.findAllMessagesByTid(tid);
    }

    /**
     * 사용자가 등록한 모든 메세지 조회 by 사용자 uid
     * @param userUid
     * @return
     */
    @GetMapping("user-uid/{user-uid}")
    public List<MessageDto> findAllMessageByUserUid(@PathVariable(name = "user-uid") String userUid) {
        return messageService.findAllMessagesByUserUid(userUid);
    }

    /**
     * 메세지 목록 조회 - 등록 내림차순
     * @return
     */
    @GetMapping
    public List<MessageDto> findAllMessagesOrderByCreatedAtDesc() {
        return messageService.findAllMessagesOrderByCreatedAtDesc();
    }

    /**
     * 공개 메세지 목록 조회 - 등록 내림차순
     * @return
     */
    @GetMapping("open")
    public List<MessageDto> findAllOpenMessagesOrderByCreatedAtDesc() {
        return messageService.findAllOpenMessagesOrderByCreatedAtDesc();
    }

    /**
     * 메세지 목록 조회 - 원하는 갯수만큼 - 등록 내림차순
     * @param size
     * @return
     */
    @GetMapping("page/{size}")
    public List<MessageDto> findAllMessagesByPage(@PathVariable(name = "size") int size) {
        return messageService.findAllMessagesByPage(size);
    }

    /**
     * 공개된 메세지 목록 조회 - 원하는 갯수만큼 - 등록 내림차순
     * @param size
     * @return
     */
    @GetMapping("page/{size}/open")
    public List<MessageDto> findAllOpenMessagesByPage(@PathVariable(name = "size") int size) {
        return messageService.findAllOpenMessagesByPage(size);
    }

    /**
     * 메세지 목록 조회 - 사용자가 작성한 메세지 중 공개 상태인 메세지 조회 by tid
     * @return
     */
    @GetMapping("tid/{tid}/open")
    public List<MessageDto> findAllOpenMessageByTid(@PathVariable(name="tid") String tid) {
        return messageService.findAllOpenMessageByTid(tid);
    }
    /**
     * 메세지 목록 조회 - 사용자가 작성한 메세지 중 공개 상태인 메세지 조회 by 사용자의 uid
     * @return
     */
    @GetMapping("user-uid/{user-uid}/open")
    public List<MessageDto> findAllOpenMessageByUserUid(@PathVariable(name="user-uid") String userUid) {
        return messageProcess.findAllOpenMessageByUserUid(userUid);
    }

    /**
     * 메세지 비공개 설정
     * @param uid
     * @return
     */
    @PutMapping("uid/{uid}/close")
    public String modifyMessageCloseByUid(@PathVariable(name = "uid") String uid){
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return messageService.modifyMessageCloseByUid(uid);

    }

    /**
     * 메세지 공개 설정
     * @param uid
     * @return
     */
    @PutMapping("uid/{uid}/open")
    public String modifyMessageOpenByUid(@PathVariable(name = "uid") String uid){
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return messageService.modifyMessageOpenByUid(uid);

    }
}
