package io.kang.chap01.dao.connectioninterface

import java.sql.Connection

// 이번에는 interface 를 이용하여 추상적이고 느슨한 연결고리를 적용했음.
// 책은 1.3.2번을 참고하였음
interface ConnectionMaker {
    fun makeConnection() : Connection?
}