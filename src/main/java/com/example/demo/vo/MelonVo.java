package com.example.demo.vo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="tb_song")
public class MelonVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rank;
    private String songName;
    private String singerName;

    @Builder
    public MelonVo(int rank, String songName,  String singerName) {
        this.rank = rank;
        this.songName = songName;
        this.singerName = singerName;
    }

}