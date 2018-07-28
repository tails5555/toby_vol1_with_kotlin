package io.kang.chap01.dao.connectioninterface

import io.kang.chap01.dto.Music
import java.sql.Connection

// 이번에는 interface 를 이용하여 추상적이고 느슨한 연결고리를 적용했음.
// 책은 1.3.2번을 참고하였음
class MusicDAO {
    private var connectionMaker : ConnectionMaker? = null

    constructor() {
        this.connectionMaker = MyConnectionMaker()
    }

    fun findAll() : List<Music> {
        var musics : MutableList<Music> = mutableListOf()
        var connection : Connection? = connectionMaker?.makeConnection()

        // 이하는 방금 MusicDAO의 소스 코드와 유사.
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