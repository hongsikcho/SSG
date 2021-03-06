package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
//기본 테스트
public class AppTest {

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

}
