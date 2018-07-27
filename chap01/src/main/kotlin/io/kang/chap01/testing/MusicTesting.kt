package io.kang.chap01.testing

import io.kang.chap01.dao.MusicDAO
import io.kang.chap01.dto.Music

class MusicTesting
    fun main(args: Array<String>) {
        var musicDAO : MusicDAO = MusicDAO()

        var musics : List<Music> = musicDAO.findAll()

        for(m in musics) {
            println("--${m.id}번째 노래입니다.--")
            println("${m.title} - ${m.singer} (${m.year})")
        }
    }

