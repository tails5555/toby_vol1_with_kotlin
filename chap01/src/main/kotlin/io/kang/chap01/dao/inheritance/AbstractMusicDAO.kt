package io.kang.chap01.dao.inheritance

import io.kang.chap01.dto.Music
import java.sql.Connection

// Factory Method Pattern 을 이용한 JDBC Connection 분해 예제
// 책은 1.2.3번을 참고하였음
abstract class AbstractMusicDAO {
    fun findAll() : List<Music> {
        var musics : MutableList<Music> = mutableListOf()
        var connection : Connection = this.getConnection()

        // 이하는 방금 MusicDAO의 소스 코드와 유사.
        return musics
    }

    fun findById(id : Long) : Music {
        var music : Music = Music()
        var connection : Connection = this.getConnection()

        // 이하는 방금 MusicDAO의 소스 코드와 유사.
        return music
    }

    fun create(music : Music) {
        var connection : Connection = this.getConnection()

        // 이하는 방금 MusicDAO의 소스 코드와 유사.
    }

    abstract fun getConnection() : Connection
}
