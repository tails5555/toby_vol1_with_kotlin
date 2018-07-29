package io.kang.chap01.dao.ioc

import io.kang.chap01.dao.connectioninterface.ConnectionMaker
import io.kang.chap01.dao.connectioninterface.GenreDAOConstruction
import io.kang.chap01.dao.connectioninterface.MusicDAOConstruction
import io.kang.chap01.dao.connectioninterface.MyConnectionMaker

// 이번에는 Factory 개념(Abstract Factory, Factory Method 패턴과 전혀 연관 없다.)을 이용해서 생성하는 연습을 진행함.
// 책은 1.4.2번을 참고하였음.
class DAOFactory2 {
    fun genreDAO() : GenreDAOConstruction {
        return GenreDAOConstruction(this.connectionMaker())
    }
    fun musicDAO() : MusicDAOConstruction {
        return MusicDAOConstruction(this.connectionMaker())
    }
    private fun connectionMaker() : ConnectionMaker {
        return MyConnectionMaker()
    }
}

fun main(args : Array<String>) {
    var musicDAO : MusicDAOConstruction = DAOFactory2().musicDAO()
    var genreDAO : GenreDAOConstruction = DAOFactory2().genreDAO()
    for(music in musicDAO.findAll()){
        println("${music.singer} - ${music.title}")
    }
    for(genre in genreDAO.findAll()){
        println("${genre.id} : ${genre.name}")
    }
}