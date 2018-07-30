package io.kang.control

import java.util.LinkedList
import java.util.Queue

object LoopExample {
    fun bfs(graph : List<IntArray>){
        var message : StringBuilder = StringBuilder("BFS 순회 놀이 : ")
        var visited : HashSet<Int> = hashSetOf(0)
        var queue : Queue<Int> = LinkedList<Int>()
        queue.offer(0)

        bfsIng@ // Kotlin 에서 주석 대신에 Label 를 작성하여 소스 코드의 가시성을 살린다.
        while(!queue.isEmpty()){
            val tmp : Int = queue.poll()
            bfsPrint@ message.append("$tmp ")
            for(k in graph.get(tmp)) {
                if (!visited.contains(k)) {
                    visited.add(k)
                    queue.offer(k)
                }
            }
        }
        bfsResult@ println(message)
    }

    @JvmStatic
    fun main(args : Array<String>) {
        val items : List<Int> = listOf(10, 20, 30, 35, 40)
        for(k in items)
            println("숫자 $k")

        // React.js 의 map 처럼 idx 변수를 추가하면 List 에 있는 인덱스처럼 사용할 수 있다.
        for((idx, k) in items.withIndex())
            println("$idx 번째에 있는 $k")

        // while 문, do-while 문은 이용하는 방법이 같다. 이진 탐색을 이용한 예제로 공부.
        val array : List<Int> = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        var findNum : Int = 5
        var left : Int = 0
        var right : Int = array.size - 1
        var mid : Int = -1
        while(true){
            mid = (left + right) / 2
            if(findNum < array[mid]) {
                println("$findNum 은 중앙인 값 ${array[mid]} 보다 작다.")
                right = mid - 1
                println("$findNum 은 인덱스 $left 와 $right 중에 있다.")
            } else if(findNum > array[mid]){
                println("$findNum 은 중앙인 값 ${array[mid]} 보다 크다.")
                left = mid + 1
                println("$findNum 은 인덱스 $left 와 $right 중에 있다.")
            } else {
                println("$findNum 을 이제 찾았다.")
                break
            }
        }

        val graph : List<IntArray> = listOf(
                intArrayOf(1, 3, 4),
                intArrayOf(0, 2),
                intArrayOf(1, 3),
                intArrayOf(0, 2),
                intArrayOf(0)
        )

        bfs(graph)
    }
}