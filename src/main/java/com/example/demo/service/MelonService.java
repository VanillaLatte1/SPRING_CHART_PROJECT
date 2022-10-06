package com.example.demo.service;

import com.example.demo.dto.TbSong;
import com.example.demo.repo.MelonRepository;
import com.example.demo.utils.MelonApi;
import com.example.demo.vo.MelonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MelonService {
    @Autowired
    private MelonRepository melonRepository;

    // 전체 데이터 조회
    public List<MelonVo> findAll() {
        List<MelonVo> music = new ArrayList<>();
        melonRepository.findAll().forEach(e -> music.add(e));
        return music;
    }

    // 데이터 넣기(insert)
    public Long save(MelonVo music) {
        return melonRepository.save(music).getId();
    }

    // 멜론 차트를 크롤링 해서 리스트를 전달
    public List<TbSong> getMelonMusicList() {
        return MelonApi.getMelonMusicList();
    }
}
