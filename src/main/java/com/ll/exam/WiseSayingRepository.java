package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    public List<WiseSaying> wises;
    public int num;

    WiseSayingRepository(){
        this.wises = new ArrayList<>();
        this.num = 1;
    }

    public WiseSaying findById(int paramId) {
        for (WiseSaying wi : wises) {
            if (paramId == wi.id) {
                return wi;
            }
        }
        return null;
    }
}
