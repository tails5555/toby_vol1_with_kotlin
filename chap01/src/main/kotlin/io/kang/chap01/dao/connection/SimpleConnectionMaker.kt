package io.kang.chap01.dao.connection

import java.sql.Connection
import java.sql.DriverManager

// 아예 독립된 클래스로 분리를 하는 예제. 기능 변화는 없음
// 상속이란 개념을 1도 안 쓰고 아예 독립된 클래스 자체로 분리를 함
// 책은 1.3.1번을 참고하였음
class SimpleConnectionMaker {
    fun makeNewConnection() : Connection {
        Class.forName("com.mysql.jdbc.Driver")
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "--Maker DB사용자--", "--Maker DB비밀번호--")
    }
}