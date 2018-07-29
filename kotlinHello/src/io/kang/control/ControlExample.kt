package io.kang.control

object ControlExample{
    @JvmStatic
    fun main(args: Array<String>) {
        val num1 : Int = 20
        val num2 : Int = 25

        // Kotlin 은 조건문(if-else)을 표현식으로 나타낼 수 있다. 그러나 삼항 연산자는 안 된다.
        val max : Int = if(num1 > num2) num1 else num2
        println(max)

        if(num1 % 5 == 0 && num2 % 5 == 0)
            println("$num1, $num2 는 5의 배수입니다.")

        if(num1 % 4 == 0 && num2 % 4 == 0)
            println("$num1, $num2 는 4의 배수입니다.")
        else if(num1 % 4 == 0 || num2 % 4 == 0)
            println("$num1, $num2 둘 중 하나는 4의 배수입니다.")
        else
            println("$num1, $num2 는 둘 다 4의 배수가 아닙니다.")

        val num : Int = 3

        // Kotlin 에서는 switch 문을 when 으로 대체한다. in 문으로 range 에 해당되는 값을 추출할 수도 있다!
        // range 는 SQL 의 Between 1 AND 4 와 같은 맥락이다.
        // switch case 에는 break 문으로 끊어줬지만, 여기서는 각 Lambda 식 별로 자동으로 끊어주기 때문에 한 Lambda 식만 실행하고 나온다. 마음에 든다 :)
        when(num){
            1 -> println("일")
            2 -> println("이")
            in (1..4) -> println("1에서 4의 값 중에 하나 아니면 이 녀석.")
            !in (1..4) -> println("1에서 4의 값 이외인 녀석.")
            else -> println("이거는 숫자가 아닌 녀석.")
        }
    }
}