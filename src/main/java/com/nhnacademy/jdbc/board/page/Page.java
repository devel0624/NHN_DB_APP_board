package com.nhnacademy.jdbc.board.page;

import java.util.List;

public class Page<T> {
    private final List<T> content;
    private final long pageCount;

    public Page(List<T> content, long pageCount) {
        this.content = content;
        this.pageCount = pageCount;
    }

    public List<T> getContent() {
        return content;
    }

    public long getPageCount() {
        return pageCount;
    }
}
