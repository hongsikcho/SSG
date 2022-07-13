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
            switch(cmd){

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
            }
        }



    }
}