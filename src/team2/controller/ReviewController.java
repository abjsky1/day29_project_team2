package team2.controller;

import team2.model.dao.BaseDao;
import team2.model.dao.ReviewDao;
import team2.model.dto.ReivewDto;

public class ReviewController {
    private ReviewController() {
    }

    private static final ReviewController instance = new ReviewController();

    public static ReviewController getInstance() {
        return instance;
    }

    private ReviewDao revd = ReviewDao.getInstance();

    // [1] 리뷰 등록 Controller
    public boolean reivSave(ReivewDto reivewDto) {
        boolean result = revd.reivSave(reivewDto);
        return result;
    }
}
