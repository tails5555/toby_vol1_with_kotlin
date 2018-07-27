package io.kang.chap01.dto

class Music() {
    var id : Long = 0
    var title : String = ""
    var singer : String = ""
    var genreId : Long = 0
    var year : Int = 0

    constructor(id : Long, singer : String, title : String, genreId : Long, year : Int) : this() {
        this.id = id
        this.singer = singer
        this.title = title
        this.genreId = genreId
        this.year = year
    }
}
