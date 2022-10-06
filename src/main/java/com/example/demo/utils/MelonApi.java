package com.example.demo.utils;

import com.example.demo.dto.TbSong;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MelonApi {
    public static List<TbSong> getMelonMusicList() {

        final String stockList = "https://www.melon.com/chart/index.htm";
        Connection conn = Jsoup.connect(stockList);
        List<TbSong> list = new ArrayList<>();
        try {
            Document document = conn.get();
            Elements stockTableBody = document.select("div.wrap_song_info");
            List<String> songList = new ArrayList<>();
            int rank = 1;
            for (Element element : stockTableBody.select("div.ellipsis.rank01")) {
                String songName = element.select("a").text();   // 노래 제목
                songList.add(songName);
            }
            rank = 1;
            for (Element element : stockTableBody.select("span.checkEllipsis")) {
                String singerName = element.select("a").text();
                TbSong dto = new TbSong();
                dto.setSongName(songList.get(rank-1));
                dto.setSingerName(singerName);
                dto.setRank(rank++);
                list.add(dto);
            }
        } catch (IOException ignored) {
        }
        return list;
    }
}