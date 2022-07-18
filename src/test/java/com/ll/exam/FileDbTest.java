package com.ll.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileDbTest {

    @BeforeEach
    void before(){
        Util.deleteDir("test_data");
    }

    @Test
    void 파일에_숫자를_저장() {
        Util.mkdir("test_data");
        Util.numberSaveToFile("test_data/last_id.txt", 1);

        int rs = Util.numberReadFromFile("test_data/last_id.txt",0);

        assertEquals(1, rs);

    }
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
    void 특정_폴더에_존재하는_모든_파일의_이름들을_가져온다() {
        Util.numberSaveToFile("test_data/1.txt", 1);
        Util.numberSaveToFile("test_data/2.txt", 1);
        Util.numberSaveToFile("test_data/3.txt", 1);

        List<String> fileNames = Util.getFileNamesFromDir("test_data");

        assertEquals(fileNames.get(0), "1.txt");
        assertEquals(fileNames.get(1), "2.txt");
        assertEquals(fileNames.get(2), "3.txt");
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
}
