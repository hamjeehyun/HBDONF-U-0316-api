package UHDBONF.service;

import UHDBONF.domain.dto.MessageDto;

import java.util.List;

public interface MessageService {
    String registerMessage(MessageDto messageDto);
    String registerMessageByTid(String tid, MessageDto messageDto);
    String registerMessageByUserUid(String userUid, MessageDto messageDto);
    MessageDto findMessageByUid(String uid);
    MessageDto findByUserId(String userId);
    List<MessageDto> findAllMessagesByTid(String tid);
    List<MessageDto> findAllMessagesByUserUid(String userUid);
    List<MessageDto> findAllMessagesOrderByCreatedAtDesc();
    List<MessageDto> findAllOpenMessagesOrderByCreatedAtDesc();
    List<MessageDto> findAllMessagesByPage(int size);
    List<MessageDto> findAllOpenMessagesByPage(int size);
    List<MessageDto> findAllOpenMessageByTid(String tid);
    List<MessageDto> findAllOpenMessageByUserUid(String userUid);
    String modifyMessageCloseByUid(String uid);
    String modifyMessageOpenByUid(String uid);
}
