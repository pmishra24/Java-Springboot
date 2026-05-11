package com.prashant.lms;

public class BorrowRequest {
    private Long bookId;
    private Long memberId;

    public Long getbookId() {
        return bookId;
    }

    public void setbookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getmemberId() {
        return memberId;
    }

    public void setmemberId(Long memberId) {
        this.memberId = memberId;
    }
}
