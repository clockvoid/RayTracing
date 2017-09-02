
import vector.Vector
import vector.Vector3

fun calc(arg0: Vector) {
	println(arg0.abs())
}

fun main(args: Array<String>) {
	println("Hello, world")
	val vec = Vector3(1.0, 2.0, 3.0)
	calc(vec)
	println(vec.toString())
	println(vec::class)
}
