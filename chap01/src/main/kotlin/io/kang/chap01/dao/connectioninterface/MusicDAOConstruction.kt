package io.kang.chap01.dao.connectioninterface

import io.kang.chap01.dto.Music
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

// 이번에는 ConnectionMaker를 상속 하는 클래스의 객체 인스턴스를 받는 생성자로 수정하여 실제 테스트에 반영함.
// 책은 1.3.3번, 1.4.2번을 참고하였음.
class MusicDAOConstruction constructor(var connectionMaker : ConnectionMaker?) {

    fun findAll() : List<Music> {
        var musics : MutableList<Music> = mutableListOf()
        var connection : Connection? = connectionMaker?.makeConnection()

        var preparedStatement : PreparedStatement = connection?.prepareStatement("SELECT * FROM music")!!
        var resultSet : ResultSet = preparedStatement.executeQuery()

        while(resultSet.next()){
            var music = Music()
            music.id = resultSet.getLong("id")
            music.singer = resultSet.getString("singer")
            music.title = resultSet.getString("title")
            music.year = resultSet.getInt("year")
            musics.add(music)
        }

        resultSet.close()
        preparedStatement.close()

        return musics
    }

    fun findById(id : Long) : Music {
        var music : Music = Music()
        var connection : Connection? = connectionMaker?.makeConnection()

        // 이하는 방금 MusicDAO의 소스 코드와 유사.
        return music
    }

    fun create(music : Music) {
        var connection : Connection? = connectionMaker?.makeConnection()

        // 이하는 방금 MusicDAO의 소스 코드와 유사.
    }
}