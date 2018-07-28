package io.kang.collection

object CollectionExample {
    @JvmStatic
    fun main(args: Array<String>) {
        val mutableNumbers : MutableList<Int> = mutableListOf(10, 20, 30, 40, 50) // 수정이 가능한 리스트
        val immutableNumbers : List<Int> = mutableNumbers // 수정이 불가능한 리스트. mutableNumber 를 참조하게 되어 이 안에 있는 값을 생중계 하는 것과 같다.

        mutableNumbers.add(60)
        println(mutableNumbers)
        println(immutableNumbers) // 결과는 서로 같다.

        mutableNumbers.clear()
        println(mutableNumbers)
        println(immutableNumbers) // 결과는 서로 같다.

        val items : List<Int> = listOf(3, 5, 6, 9, 10, 12, 15, 18, 20, 21, 24, 25, 27, 30)
        println(items.first())
        println(items.last())
        println(items.filter{
            it % 3 == 0 && it % 5 == 0
        })

        var illionaire : Set<String> = setOf("Dok2", "The Quiett", "Beenzino")
        var gambleTeam : Set<String> = setOf("Dok2", "Jay Park", "The Quiett", "Chang Mo")

        println(illionaire.union(gambleTeam)) // 합집합
        println(illionaire.intersect(gambleTeam)) // 교집합
        println(illionaire.minus(gambleTeam)) // 차집합

        for(k in 1..9) // 이는 Python 에서도 잠깐 접해 본 적은 있을 것이다.
            println("$k X $k = ${k*k}")

        val a : Int = 20
        if(a in 10..30) // 근데 이를 if 문에서 쓰면 술 게임 Up Down 과 같은 효력을 낼 수 있다. 10 이상 30 이하인 경우를 뜻한다.
            println("$a 는 10 이상 30 이하의 수입니다.")
    }
}