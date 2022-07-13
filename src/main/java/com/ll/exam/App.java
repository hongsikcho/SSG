package com.ll.exam;

import java.util.Scanner;

public class App{
        private Scanner sc;

        App(Scanner sc){
            this.sc = sc;
        }

    public void run(){
        System.out.println("=== 명언 SSG ===");

        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            switch(cmd){

                case"종료":
                    break outer;

                case"등록":
                    System.out.print("명언) ");
                    String content = sc.nextLine().trim();
                    System.out.print("작가) ");
                    String author = sc.nextLine().trim();
                    System.out.print("명언이 성공적으로 등록되었습니다.");
            }
        }



    }
}