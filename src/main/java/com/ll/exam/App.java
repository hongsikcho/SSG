package com.ll.exam;

import java.util.*;

public class App {
    // 스캐너를 얻는다.
    // 평범한 스캐너가 아닌, 문자열을 입력으로 삼는 스캐너가 생성된다.
    private Scanner sc;

    App(Scanner sc) {
        this.sc = sc;
    }

    List<WiseSaying> wises = new ArrayList<>();
    int num = 1;

    public void run() {

        System.out.println("=== 명언 SSG ===");

        WiseSayingController WiseSayingController = new WiseSayingController(sc);


        outer:
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            rq rq = new rq(cmd);

            switch (rq.getPath()) {
                case "종료":
                    break outer;

                case "등록":
                    WiseSayingController.add(rq);
                    break;

                case "목록":
                    WiseSayingController.list(rq);
                    break;

                case "삭제":
                    WiseSayingController.remove(rq);
                    break;

                case "수정":
                    WiseSayingController.modify(rq);


            }
        }


    }
}