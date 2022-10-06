package com.example.demo;

import com.example.demo.dto.TbSong;
import com.example.demo.service.MelonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@____ = 어노테이션
@RestController        //String을 반환 (return)
public class ChartAPIController {
    @Autowired
    private MelonService melonService;

    @GetMapping("/api/v1/melon")
    public ResponseEntity<List<TbSong>> getMelonList() {
        List<TbSong> list = melonService.getMelonMusicList();
        return new ResponseEntity<List<TbSong>>(list, HttpStatus.OK);
    }
}