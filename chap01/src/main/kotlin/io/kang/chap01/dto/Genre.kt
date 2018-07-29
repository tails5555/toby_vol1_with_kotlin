package io.kang.chap01.dto

// 일반적으로 쓰이는 DTO 작성
// 책은 1.1.1번을 참고하였음
class Genre(){
    var id : Long = 0
    var name : String = ""

    constructor(id : Long, name : String) : this() {
        this.id = id
        this.name = name
    }
}