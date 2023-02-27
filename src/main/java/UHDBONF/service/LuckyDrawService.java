package UHDBONF.service;

import UHDBONF.domain.dto.LuckyDrawDto;

import java.util.List;

public interface LuckyDrawService {
    String registerLuckyDraw(LuckyDrawDto luckyDrawDto);
    String registerLuckyDrawByTid(String tid);
    String registerLuckyDrawByUserUid(String userUid);
    LuckyDrawDto findLuckyDrawByUid(String id);
    List<LuckyDrawDto> findAllLuckyDrawByTid(String tid);
    List<LuckyDrawDto> findAllLuckyDrawByUserUid(String uid);
    List<LuckyDrawDto> findAllOpenLuckyDrawByTid(String tid);
    List<LuckyDrawDto> findAllOpenLuckyDrawByUserUid(String userUid);
    List<LuckyDrawDto> findAllLuckyDraw();
    List<LuckyDrawDto> findAllOpenLuckyDraw();
    String modifyLuckyDrawCloseByUid(String uid);
    String modifyLuckyDrawOpenByUid(String uid);
}
