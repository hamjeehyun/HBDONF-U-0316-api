package UHDBONF.store;

import UHDBONF.domain.dto.LuckyDrawDto;

import java.util.List;

public interface LuckyDrawStore {
    String create(LuckyDrawDto luckyDrawDto);
    LuckyDrawDto readByUid(String uid);
    LuckyDrawDto readByTid(String tid);
    int readMaxSequence();
    List<LuckyDrawDto> readAllByTid(String tid);
    List<LuckyDrawDto> readAllByUserUid(String userUid);
    List<LuckyDrawDto> realAllOpenLuckyDrawByTid(String tid);
    List<LuckyDrawDto> realAllOpenLuckyDrawByUserUid(String userUid);
    List<LuckyDrawDto> realAllOpenLuckyDrawByUid(String uid);
    List<LuckyDrawDto> readAllLuckyDraw();
    List<LuckyDrawDto> readAllOpenLuckyDraw();
}
