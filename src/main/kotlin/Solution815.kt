class Solution815 {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if(source == target){
            return 0
        }
        val visited =  BooleanArray(routes.size)
        val graph = mutableMapOf<Int, MutableSet<Int>>()
        for(i in 0..routes.lastIndex){
            val route = routes[i]
            for(j in route){
                if(graph[j] == null){
                    graph[j] = mutableSetOf(i)
                } else {
                    graph[j]!!.add(i)
                }
            }
        }

        val queue = ArrayDeque<Pair<Int, Int>>()

        if(graph[source] == null){
            return 0
        }

        for(i in graph[source]!!){
            queue.add(Pair(i, 1))
            visited[i] = true
        }

        while(!queue.isEmpty()){
            val next = queue.removeFirst()

            for(i in routes[next.first]){
                if (i == target) {
                    return next.second
                }

                if(graph[i] == null){
                    continue
                }
                for(j in graph[i]!!){
                    if(visited[j]){
                        continue
                    }
                    visited[j] = true
                    queue.add(Pair(j, next.second + 1))
                }
            }
        }

        return -1
    }
}