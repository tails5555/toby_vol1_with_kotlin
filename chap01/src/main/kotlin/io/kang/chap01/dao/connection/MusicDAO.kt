package io.kang.chap01.dao.connection

import io.kang.chap01.dto.Music
import java.sql.Connection

// 아예 독립된 클래스로 분리를 하는 예제. 기능 변화는 없음
// 상속이란 개념을 1도 안 쓰고 아예 독립된 클래스 자체로 분리를 함
// 책은 1.3.1번을 참고하였음
class MusicDAO constructor(var simpleConnectionMaker : SimpleConnectionMaker) {
    fun findAll() : List<Music> {
        var musics : MutableList<Music> = mutableListOf()
        var connection : Connection = simpleConnectionMaker.makeNewConnection()

        // 이하는 방금 MusicDAO의 소스 코드와 유사.
        return musics
    }

    fun findById(id : Long) : Music {
        var music : Music = Music()
        var connection : Connection = simpleConnectionMaker.makeNewConnection()

        // 이하는 방금 MusicDAO의 소스 코드와 유사.
        return music
    }

    fun create(music : Music) {
        var connection : Connection = simpleConnectionMaker.makeNewConnection()

        // 이하는 방금 MusicDAO의 소스 코드와 유사.
    }
}