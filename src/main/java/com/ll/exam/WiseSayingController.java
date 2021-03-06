package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private  Scanner sc;
    private WiseSayingRepository wiseSayingRepository;

    WiseSayingController(Scanner sc){
        this.sc = sc;
        this.wiseSayingRepository = new WiseSayingRepository();

    }

    public void add(rq rq) {
        System.out.println("명언) ");
        String content = sc.nextLine().trim();
        System.out.println("작가) ");
        String author = sc.nextLine().trim();

        WiseSaying wise = wiseSayingRepository.add(content, author);
        System.out.println(wise.id + "번 명언이 성공적으로 등록되었습니다.");

    }

    public void list(rq rq) {
        System.out.println("======== 명언 목록 ========");

        List<WiseSaying> wises = wiseSayingRepository.findAll();

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

        wise_ = wiseSayingRepository.findById(paramId);

        if (wise_ == null) {
            System.out.println(paramId + "번 글은 존재하지 않습니다.");
            return;
        }
       wiseSayingRepository.remove(paramId);

        System.out.println(paramId + "번 명언이 삭제되었습니다.");
    }

    public void modify(rq rq) {
        int Id = rq.getIntParam("id", 0);

        if (Id == 0) {
            System.out.println("번호를 입력해주세요");
            return;
        }

        WiseSaying wise__ = null;

        wise__ = wiseSayingRepository.findById(Id);

        if (wise__ == null) {
            System.out.println(Id + "번 글은 존재하지 않습니다.");
            return;
        }

        System.out.println("기존 명언) " + wise__.content);
        System.out.println("기존 작가) " + wise__.author);
        String content = sc.nextLine();
        String author = sc.nextLine();

        wiseSayingRepository.modify(Id,content,author);

        System.out.println("성공적으로 변경되었습니다.");
    }

}
