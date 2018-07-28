package io.kang.chap01.dao.inheritance

import java.sql.Connection
import java.sql.DriverManager

// Factory Method Pattern 을 이용한 JDBC Connection 분해 예제
// 책은 1.2.3번을 참고하였음
class YourMusicDAO : AbstractMusicDAO() {
    override fun getConnection(): Connection {
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "--YourMusic DB사용자--", "--YourMusic DB비밀번호--")
    }
}