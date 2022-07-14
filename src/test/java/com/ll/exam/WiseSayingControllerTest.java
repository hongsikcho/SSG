package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WiseSayingControllerTest {
    @Test
    public void 명언_수정() throws IOException {
        String rs = new AppTestRunner().run("""
                등록
                나의 죽음을 적에게 알리지 마라
                이순신
                등록
                안녕하세요
                홍식
                수정?id=1
                안녕
                세민
                목록
                종료
                """);
        System.out.println(rs);
        assertTrue(rs.contains("명언) "));
        assertTrue(rs.contains("작가) "));
        assertTrue(rs.contains("======== 명언 목록 ========"));
        assertTrue(rs.contains("기존 명언) "));
        assertTrue(rs.contains("기존 작가) "));
        assertTrue(rs.contains("성공적으로 변경되었습니다."));
    }

    @Test
    public void 명언_삭제() throws IOException {
        String rs = new AppTestRunner().run("""
                등록
                나의 죽음을 적에게 알리지 마라
                이순신
                등록
                안녕하세요
                홍식
                삭제?id=1
                목록
                종료
                """);
        System.out.println(rs);
        assertTrue(rs.contains("명언) "));
        assertTrue(rs.contains("작가) "));
        assertTrue(rs.contains("======== 명언 목록 ========"));
        assertFalse(rs.contains("id=1"));
    }

    @Test
    public void 명언_목록_출력() throws IOException {
        String rs = new AppTestRunner().run("""
                 등록
                나의 죽음을 적에게 알리지 마라
                이순신
                등록
                안녕하세요
                홍식
                목록
                종료
                """);
        System.out.println(rs);
        assertTrue(rs.contains("명언) "));
        assertTrue(rs.contains("작가) "));
        assertTrue(rs.contains("======== 명언 목록 ========"));
        assertTrue(rs.contains("2번 명언이 성공적으로 등록되었습니다."));
    }

    @Test
    public void 등록을_하면_명언과_작가를_물어보며_번호_증가() throws IOException {
        String rs = new AppTestRunner().run("""
                 등록
                나의 죽음을 적에게 알리지 마라
                이순신
                등록
                안녕하세요
                홍식
                종료
                """);
        System.out.println(rs);
        assertTrue(rs.contains("명언) "));
        assertTrue(rs.contains("작가) "));
        assertTrue(rs.contains("1번 명언이 성공적으로 등록되었습니다."));
        assertTrue(rs.contains("2번 명언이 성공적으로 등록되었습니다."));
    }
    @Test
    public void 종료() throws IOException {
        String rs = new AppTestRunner().run("종료");

        assertTrue(rs.contains("=== 명언 SSG ==="));
        assertTrue(rs.contains("명령) "));
    }

}
