
package shape

import color.Color
import vector.Vector
import ray.Ray
import ray.IntersectionPoint

infix fun Double.pow(arg0: Double) = Math.pow(this, arg0)

interface Shape {
	val color: Color
	val kd: Double
	val center: Vector
	val material: Material

	fun testIntersection(arg0: Ray): IntersectionPoint?
}

class Sphere(arg0: Color, arg1: Vector, arg2: Double, arg3: Double, arg4: Material): Shape {
	override val color: Color = arg0
	override val center = arg1
	override val kd = arg2
	override val material: Material = arg4
	val radius = arg3

	override fun testIntersection(arg0: Ray): IntersectionPoint? { // test intersection between arg0 and shape
		val D: Double = (arg0.direction dot arg0.start).pow(2.0) - (arg0.start.abs().pow(2.0) - 1.0)
		if (D < 0) {
			return null
		} else {
			val t = (-1.0) * (arg0.direction dot arg0.start) - Math.sqrt(D)
			return IntersectionPoint(t, arg0.start + arg0.direction * t, (arg0.start + arg0.direction * t).normalize())
		}
	}
}

class Material(arg0: Color, arg1: Color, arg2: Color, arg3: Double) {
	val ambientFactor: Color = arg0
	val diffuseFactor: Color = arg1
	val specularFactor: Color= arg2
	val shininess: Double = arg3
}
