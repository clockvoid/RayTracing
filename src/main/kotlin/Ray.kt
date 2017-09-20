
package ray

import vector.Vector

class Ray(arg0: Vector, arg1: Vector) {
	val start: Vector = arg0
	val direction: Vector = arg1
}

class IntersectionPoint(arg0: Double, arg1: Vector, arg2: Vector) {
	val distance: Double = arg0
	val position: Vector = arg1
	val normal: Vector = arg2
}
