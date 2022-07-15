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
    void 맵을_객체로_변경() {
        Util.mkdir("test_data");
        WiseSaying wiseSaying = new WiseSaying(1, "내 사전에 불가능은 없다.", "나폴레옹");
        Util.saveToFile("test_data/1.json", wiseSaying.toJson());

        String rs = Util.readFromFile("test_data/1.json");
        Map<String, Object> map = Util.jsonToMap(rs);

        WiseSaying wiseSaying1 = new WiseSaying(map);

        assertEquals(1, map.get("id"));
        assertEquals("내 사전에 불가능은 없다.", map.get("content"));
        assertEquals(wiseSaying, wiseSaying1);

    }
    @Test
    void 파일에_있는_JSON을_맵으로_변환() {
        Util.mkdir("test_data");
        WiseSaying wiseSaying = new WiseSaying(1, "내 사전에 불가능은 없다.", "나폴레옹");
        Util.saveToFile("test_data/1.json", wiseSaying.toJson());

        String rs = Util.readFromFile("test_data/1.json");
        Map<String, Object> map = Util.jsonToMap(rs);

        assertEquals(1, map.get("id"));
        assertEquals("내 사전에 불가능은 없다.", map.get("content"));
        assertEquals("나폴레옹", map.get("author"));
    }

    @Test
    void 파일에_내용쓰기() {
        Util.mkdir("test_data");
        WiseSaying wiseSaying = new WiseSaying(1,"나의 죽음을 적에게 알리지 마라", "이순신");
        Util.saveToFile("test_data/1.json", wiseSaying.toJson());
        String rs = Util.readFromFile("test_data/1.json");

        assertEquals(wiseSaying.toJson(), rs);
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

}
