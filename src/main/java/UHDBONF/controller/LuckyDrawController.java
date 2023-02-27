package UHDBONF.controller;

import UHDBONF.domain.dto.LuckyDrawDto;
import UHDBONF.service.LuckyDrawService;
import UHDBONF.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("u/lucky-draws")
public class LuckyDrawController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LuckyDrawController.class);
    @Autowired
    private LuckyDrawService luckyDrawService;

    /**
     * 럭드 등록
     * @param luckyDrawDto
     * @return
     */
    @PostMapping
    public String registerLuckyDraw(@RequestBody LuckyDrawDto luckyDrawDto) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return luckyDrawService.registerLuckyDraw(luckyDrawDto);
    }

    /**
     * 럭드 등록 by tid
     * @param tid
     * @return
     */
    @PostMapping("tid/{tid}")
    public String registerLuckyDrawByTid(@PathVariable(name = "tid") String tid) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return luckyDrawService.registerLuckyDrawByTid(tid);
    }

    /**
     * 럭드 등록 by user-uid
     * @param userUid
     * @return
     */
    @PostMapping("user-uid/{user-uid}")
    public String registerLuckyDrawByUserUid(@PathVariable(name = "user-uid") String userUid) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return luckyDrawService.registerLuckyDrawByUserUid(userUid);
    }

    /**
     * 럭드 상세 조회 by uid
     * @param uid
     * @return
     */
    @GetMapping("uid/{uid}")
    public LuckyDrawDto findLuckyDrawByUid(@PathVariable(name = "uid") String uid) {
        return luckyDrawService.findLuckyDrawByUid(uid);
    }

    /**
     * 사용자가 응모한 럭드 목록 조회 by tid
     * @param itd
     * @return
     */
    @GetMapping("itd/{itd}")
    public List<LuckyDrawDto> findAllLuckyDrawByTid(@PathVariable(name = "itd") String itd) {
        return luckyDrawService.findAllLuckyDrawByTid(itd);
    }

    /**
     * 사용자가 응모한 럭드 목록 조회 by userUid
     * @param userUid
     * @return
     */
    @GetMapping("user-uid/{user-uid}")
    public List<LuckyDrawDto> findAllLuckyDrawByUserUid(@PathVariable(name = "user-uid") String userUid) {
        return luckyDrawService.findAllLuckyDrawByUserUid(userUid);
    }

    /**
     * 사용자가 응모한 럭드 중 공개 상태인 목록 조회 by tid
     * @param itd
     * @return
     */
    @GetMapping("itd/{itd}/open")
    public List<LuckyDrawDto> findAllOpenLuckyDrawByTid(@PathVariable(name = "itd") String itd) {
        return luckyDrawService.findAllOpenLuckyDrawByTid(itd);
    }

    /**
     * 사용자가 응모한 럭드 중 공개 상태인 목록 조회 by userUid
     * @param userUid
     * @return
     */
    @GetMapping("user-uid/{user-uid}/open")
    public List<LuckyDrawDto> findAllOpenLuckyDrawByUserUid(@PathVariable(name = "user-uid") String userUid) {
        return luckyDrawService.findAllOpenLuckyDrawByUserUid(userUid);
    }

    /**
     * 전체 럭드 목록 조회
     * @return
     */
    @GetMapping
    public List<LuckyDrawDto> findAllLuckyDraw() {
        return luckyDrawService.findAllLuckyDraw();
    }

    /**
     * 공개된 럭드 목록 조회
     * @return
     */
    @GetMapping("open")
    public List<LuckyDrawDto> findAllOpenLuckyDraw() {
        return luckyDrawService.findAllOpenLuckyDraw();
    }

    /**
     * 럭드 비공개 설정
     * @param uid
     * @return
     */
    @PutMapping("uid/{uid}/close")
    public String modifyLuckyDrawCloseByUid(@PathVariable(name = "uid") String uid){
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return luckyDrawService.modifyLuckyDrawCloseByUid(uid);

    }

    /**
     * 럭드 공개 설정
     * @param uid
     * @return
     */
    @PutMapping("{uid}/open")
    public String modifyLuckyDrawOpenByUid(@PathVariable(name = "uid") String uid){
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("유토의 빵공장 영업시간이 아닙니다.");
        }
        throw ExceptionUtil.createOnfBizException("유토의 빵공장 영업시간이 아닙니다.");
//        return luckyDrawService.modifyLuckyDrawOpenByUid(uid);

    }
}
