package io.kang.chap01.dao.connectioninterface

import io.kang.chap01.dto.Genre
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

// 1.4.2에서 여러 DAO 객체를 주입하여 테스팅하는 것을 실험하기 위해 만든 임시 DAO.
class GenreDAOConstruction constructor(var connectionMaker : ConnectionMaker?) {

    fun findAll() : List<Genre> {
        var genres : MutableList<Genre> = mutableListOf()
        var connection : Connection? = connectionMaker?.makeConnection()

        var preparedStatement : PreparedStatement = connection?.prepareStatement("SELECT * FROM genre")!!
        var resultSet : ResultSet = preparedStatement.executeQuery()

        while(resultSet.next()){
            var genre = Genre()
            genre.id = resultSet.getLong("id")
            genre.name = resultSet.getString("genreName")
            genres.add(genre)
        }

        resultSet.close()
        preparedStatement.close()

        return genres
    }

    fun findById(id : Long) : Genre {
        var genre : Genre = Genre()
        var connection : Connection? = connectionMaker?.makeConnection()

        // 상세한 구현은 생략.
        return genre
    }

    fun create(genre : Genre) {
        var connection : Connection? = connectionMaker?.makeConnection()

        // 상세한 구현은 생략.
    }
}