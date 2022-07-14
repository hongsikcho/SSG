package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private  Scanner sc;
    List<WiseSaying> wises;
    int num;

    WiseSayingController(Scanner sc){
        this.sc = sc;
        wises = new ArrayList<>();
        num = 1;
    }

    public void add(rq rq) {
        System.out.println("명언) ");
        String content = sc.nextLine().trim();
        System.out.println("작가) ");
        String author = sc.nextLine().trim();
        System.out.println(num + "번 명언이 성공적으로 등록되었습니다.");
        WiseSaying w = new WiseSaying(num, content, author);
        wises.add(w);
        num++;
    }

    public void list(rq rq) {
        System.out.println("======== 명언 목록 ========");
        for (int i = wises.size() - 1; i >= 0; i--) {
            System.out.println(wises.get(i));
        }
    }

    public void remove(rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }


        WiseSaying wise_ = null;

        wise_ = findById(paramId);

        if (wise_ == null) {
            System.out.println(paramId + "번 글은 존재하지 않습니다.");
            return;
        }
        wises.remove(wise_);

        System.out.println(paramId + "번 명언이 삭제되었습니다.");
    }

    public void modify(rq rq) {
        int Id = rq.getIntParam("id", 0);

        if (Id == 0) {
            System.out.println("번호를 입력해주세요");
            return;
        }

        WiseSaying wise__ = null;

        wise__ = findById(Id);

        if (wise__ == null) {
            System.out.println(Id + "번 글은 존재하지 않습니다.");
            return;
        }

        System.out.println("기존 명언) " + wise__.content);
        System.out.println("기존 작가) " + wise__.author);
        wise__.content = sc.nextLine();
        wise__.author = sc.nextLine();

        System.out.println("성공적으로 변경되었습니다.");
    }

    private WiseSaying findById(int paramId) {
        for (WiseSaying wi : wises) {
            if (paramId == wi.id) {
                return wi;
            }
        }
        return null;
    }
}
