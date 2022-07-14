package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private static List<WiseSaying> wises;
    private int num;

    WiseSayingRepository() {
        this.wises = new ArrayList<>();
        this.num = 1;
    }

    public void remove(int paramId) {
        WiseSaying w = findById(paramId);
        wises.remove(w);
    }

    public WiseSaying findById(int paramId) {
        for (WiseSaying wi : wises) {
            if (paramId == wi.id) {
                return wi;
            }
        }
        return null;
    }

    public void modify(int id, String content, String author) {
        WiseSaying w = findById(id);
        w.content = content;
        w.author = author;
    }

    public List<WiseSaying> findAll() {
        return wises;
    }

    public WiseSaying add(String content, String author) {
        int id = num;
        WiseSaying wise = new WiseSaying(id, content, author);
        wises.add(wise);
        num ++;

        return wise;
    }
}
