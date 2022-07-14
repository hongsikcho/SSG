package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class AppTestRunner {
    public String run(String s) throws IOException {
        // 스캐너를 얻는다.
        // 평범한 스캐너가 아닌, 문자열을 입력으로 삼는 스캐너가 생성된다.
        Scanner sc = TestUtil.genScanner(s);

        // 평소에는 표준출력(System.out)이 모니터를 향하고 있다.
        // 그것을 특정 바이트스트림에 쌓이도록 한다.
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        // 바이트스트림이 여태까지 모아놓은 출력들을 방출한다.
        String rs = output.toString();
        // System.out 이 다시 모니터를 향하도록 한다.
        TestUtil.clearSetOutToByteArray(output);

        return rs;
    }
}