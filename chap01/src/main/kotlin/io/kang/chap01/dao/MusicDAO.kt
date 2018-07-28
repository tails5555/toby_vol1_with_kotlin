package io.kang.chap01.dao

import io.kang.chap01.dto.Music
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

// 일반적으로 쓰이는 DAO 작성.
// 책은 1.1.2번을 참고하였음.
class MusicDAO {
    fun findAll() : List<Music> {
        var musics : MutableList<Music> = mutableListOf()

        Class.forName("com.mysql.jdbc.Driver").newInstance()
        var connection : Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "--DB 사용자--", "--DB 비밀번호--")
        var preparedStatement : PreparedStatement = connection.prepareStatement("SELECT * FROM music")
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
        connection.close()

        return musics
    }

    fun findById(id : Long) : Music {
        var music : Music = Music()

        Class.forName("com.mysql.jdbc.Driver").newInstance()
        var connection : Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "--DB 사용자--", "--DB 비밀번호--")
        var preparedStatement : PreparedStatement = connection.prepareStatement("SELECT * FROM music WHERE id = ?")
        preparedStatement.setLong(1, id)
        var resultSet : ResultSet = preparedStatement.executeQuery()

        if(resultSet.next()){
            music.id = resultSet.getLong("id")
            music.singer = resultSet.getString("singer")
            music.title = resultSet.getString("title")
            music.year = resultSet.getInt("year")
        }

        resultSet.close()
        preparedStatement.close()
        connection.close()

        return music
    }

    fun create(music : Music) {
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        var connection : Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "--DB 사용자--", "--DB 비밀번호--")
        var preparedStatement : PreparedStatement = connection.prepareStatement("INSERT INTO music(title, singer, genreId, year) VALUES(?, ?, ?, ?)")

        preparedStatement.setString(1, music.title)
        preparedStatement.setString(2, music.singer)
        preparedStatement.setLong(3, music.genreId)
        preparedStatement.setInt(4, music.year)

        preparedStatement.executeUpdate()

        preparedStatement.close()
        connection.close()
    }
}