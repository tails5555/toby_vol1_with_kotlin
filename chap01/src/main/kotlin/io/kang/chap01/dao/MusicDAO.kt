package io.kang.chap01.dao

import io.kang.chap01.dto.Music
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class MusicDAO {
        fun findAll() : List<Music> {
            var musics : MutableList<Music> = mutableListOf()

            Class.forName("com.mysql.jdbc.Driver").newInstance()
            var connection : Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "kang", "nz973g!!")
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

            return musics
        }
}