package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {


    @Test
    public void 등록을_하면_명언과_작가를_물어본다() throws IOException {
        Scanner sc = TestUtil.genScanner("""
                등록
                나의 죽음을 적에게 알리지 마라
                이순신
                종료
                """);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        System.out.println(rs); // 궁금하면 까보기

        assertTrue(rs.contains("명언) "));
        assertTrue(rs.contains("작가) "));
        assertTrue(rs.contains("명언이 성공적으로 등록되었습니다."));
    }
    @Test
    public void 종료() throws IOException {
        Scanner sc = TestUtil.genScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertTrue(rs.contains("=== 명언 SSG ==="));
        assertTrue(rs.contains("명령) "));
    }
    @Test
    public void 테스트(){
        assertTrue(1 == 1);
        assertEquals(1,1);
    }

    @Test
    public void 스캐너에_키보드가_아닌_문자열로_입력_테스트(){
        Scanner sc = TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        assertEquals(cmd,"안녕");
    }

    @Test
    public void 출력을_모니터가_아닌_문자열로() throws IOException {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);


        assertEquals("안녕", rs);

    }

    @Test
    public void 문자열을_파일에_저장() {
        Util.file.mkdir("test_data");
        Util.file.saveToFile("test_data/1.txt", "안녕");

        String body = Util.file.readFromFile("test_data/1.txt");

        assertEquals("안녕", body);
    }

}
