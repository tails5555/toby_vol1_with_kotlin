package io.kang.chap01.dao.method

import io.kang.chap01.dto.Music
import java.sql.Connection
import java.sql.DriverManager

// 디자인 패턴 없이 일부 중복되는 소스 코드를 추출하여 private 메소드로 만드는 예제
// 책은 1.2.2번을 참고하였음
class MusicDAOMethodExtract {
    private fun getConnection() : Connection {
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "--DB사용자--", "--DB비밀번호--")
    }

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
}