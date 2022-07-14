package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App{
    // 스캐너를 얻는다.
    // 평범한 스캐너가 아닌, 문자열을 입력으로 삼는 스캐너가 생성된다.
        private Scanner sc;

        App(Scanner sc){
            this.sc = sc;
        }

    public void run(){
        System.out.println("=== 명언 SSG ===");
        int num = 1;

        List<WiseSaying> wises = new ArrayList<>();
        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            rq rq = new rq(cmd);

            switch(rq.getPath()){
                case"종료":
                    break outer;

                case"등록":
                    System.out.println("명언) ");
                    String content = sc.nextLine().trim();
                    System.out.println("작가) ");
                    String author = sc.nextLine().trim();
                    System.out.println(num+"번 명언이 성공적으로 등록되었습니다.");
                    WiseSaying w = new WiseSaying(num , content, author);
                    wises.add(w);
                    num ++;
                    break;

                case"목록":
                    System.out.println("======== 명언 목록 ========");
                    for(int i = wises.size() - 1 ; i >= 0 ; i --){
                        System.out.println(wises.get(i));
                    }
                    break;

                case"삭제":
                    int paramId = rq.getIntParam("id" , 0);

                    if (paramId == 0){
                        System.out.println("번호를 입력해주세요.");
                        continue ;
                    }


                    WiseSaying wise_ = null;

                    for(WiseSaying wi : wises){
                        if(paramId == wi.id){
                            wise_ = wi;
                        }
                    }
                    if(wise_ == null){
                        System.out.println(paramId+"번 글은 존재하지 않습니다.");
                        continue;
                    }
                    wises.remove(wise_);

                    System.out.println(paramId+"번 명언이 삭제되었습니다.");
                    break;

            }
        }



    }
}