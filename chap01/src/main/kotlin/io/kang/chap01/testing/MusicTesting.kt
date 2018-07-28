package io.kang.chap01.testing

import io.kang.chap01.dao.MusicDAO
import io.kang.chap01.dto.Music

// 일반적으로 쓰이는 DAO 테스트 코드 작성
// 책은 1.1.3번을 참고하였음.
class MusicTesting
    fun main(args: Array<String>) {
        var musicDAO : MusicDAO = MusicDAO()

        var musics : List<Music> = musicDAO.findAll()

        for(m in musics) {
            println("--${m.id}번째 노래입니다.--")
            println("${m.title} - ${m.singer} (${m.year})")
        }

        var music1 = musicDAO.findById(1)
        println("--${music1.id}번째 노래입니다.--")
        println("${music1.title} - ${music1.singer} (${music1.year})")

        var createMusic : Music = Music()

        createMusic.title = "음악_제목"
        createMusic.singer = "음악_가수"
        createMusic.genreId = 1L
        createMusic.year = 2000

        musicDAO.create(createMusic)
    }
