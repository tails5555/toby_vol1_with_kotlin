package io.kang.basictype

object TypeExample {
    @JvmStatic
    fun main(args: Array<String>) {
        val i : Int = 10
        val d : Double = 10.0
        val f : Float = 10.0F
        val l : Long = 10L
        val s : Short = 10
        val b : Byte = 10

        println("Int i : $i")
        println("Double d : $d")
        println("Float f : $f")
        println("Long l : $l")
        println("Short s : $s")
        println("Byte b : $b")

        val bool : Boolean // val 형은 처음에 값을 따로 설정하지 않아도 상관은 없지만
        bool = false // 선언 이후에 최초로 값을 대입하면 이 값은 계속 false로 유지된다.

        println("Boolean bool : $bool")

        var string1 : String = "abcdefg" // string1은 Java에서 썼던 함수를 그대로 이용해도 되지만
        val string2 : String = "high" // string2은 읽기 전용이기 때문에 읽기만 할 수 있는 함수 이외에 이용이 불가능하다.
        // Kotlin 에서도 String 은 immutable 하다.

        val nums : IntArray = intArrayOf(10, 20, 30)
        val strings : Array<String> = arrayOf("노구", "노주현", "노홍렬", "노영삼", "노인삼")
        val anythings : Array<Any> = arrayOf(10, "가나다", 30.2, 'a', false) // Java와 달리 아무거나 넣을 수 있는 배열을 형성할 수 있다.

        for(i in nums)
            println("숫자 $i")
        for(s in strings)
            println("웬그막 $s")
        for(a in anythings)
            println("아무거나 $a")
    }
}

