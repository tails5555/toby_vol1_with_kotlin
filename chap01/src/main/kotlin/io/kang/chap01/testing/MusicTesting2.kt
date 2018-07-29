package io.kang.chap01.testing

import io.kang.chap01.dao.connectioninterface.ConnectionMaker
import io.kang.chap01.dao.connectioninterface.MusicDAOConstruction
import io.kang.chap01.dao.connectioninterface.MyConnectionMaker

// 이번에는 ConnectionMaker를 상속 하는 클래스의 객체 인스턴스를 받는 생성자로 수정하여 실제 테스트에 반영함.
// 책은 1.3.4 내용 참고
class MusicTesting2

fun main(args : Array<String>) {
    var connectionMaker : ConnectionMaker = MyConnectionMaker()
    var musicDAO : MusicDAOConstruction = MusicDAOConstruction(connectionMaker)
    // ConnectionMaker 타입의 오브젝트를 제공하여 두 오브젝트 사이의 의존관계 설정의 효과가 증대된다.

    for(music in musicDAO.findAll()){
        println("${music.singer} - ${music.title}")
    }
}