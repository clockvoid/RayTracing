
interface Vector {
	fun innerProduct(): Double
	operator fun plus(arg0: Vector): Vector
	operator fun minus(arg0: Vector): Vector
}

class Vector3(val x: Double, val y: Double, val z: Double) {

}
