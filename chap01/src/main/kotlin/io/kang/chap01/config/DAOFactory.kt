package io.kang.chap01.config

import io.kang.chap01.dao.connectioninterface.ConnectionMaker
import io.kang.chap01.dao.connectioninterface.MusicDAOConstruction
import io.kang.chap01.dao.connectioninterface.MyConnectionMaker
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

// Bean Factory 와 Application Context 를 이용한 예제.
// 책은 1.5.1번을 참고하였음.
@Configuration
class DAOFactory {
    @Bean
    fun musicDAO() : MusicDAOConstruction {
        return MusicDAOConstruction(this.connectionMaker())
    }

    @Bean
    fun connectionMaker() : ConnectionMaker {
        return MyConnectionMaker()
    }
}

// 이제 코틀린을 이용한 테스팅은 아래와 같이 main 함수를 맨 아래에 입력해도 상관은 없다.
// 이는 위의 DAOFactory 클래스의 메소드도 해당되지 않으니 예제 테스팅을 한결 쉽게 할 수 있다.
fun main(args : Array<String>){
    var context : ApplicationContext = AnnotationConfigApplicationContext(DAOFactory::class.java)
    var musicDAO : MusicDAOConstruction = context.getBean("musicDAO", MusicDAOConstruction::class.java)
    for(music in musicDAO.findAll()){
        println("${music.singer} - ${music.title}")
    }
}