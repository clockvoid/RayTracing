
package cord

import ray.Ray
import vector.Vector
import vector.Vector3

class Cord(arg0: Screen, arg1: PinHole) {

	val screen: Screen = arg0
	val hole: PinHole = arg1
	val cord: List<Ray> = screen.cord.map {
		o -> Ray(o, (hole.center - o).normalize())
	}

}

class Screen(arg0: Vector, arg1: Double, arg2: Double, arg3: Double) {

	val center: Vector = arg0
	val Rx: Double = arg1
	val Ry: Double = arg2
	val size: Double = arg3
	val cord: List<Vector> = List(Ry.toInt(), {
		t -> List(Rx.toInt(), {
			l -> Vector3(size / Rx * (0.5 + (Rx - 1 - l)) - size / 2 , (-1.0) * size / Ry * (0.5 + (Ry - 1 - t)) + size / 2, center.z)
		})
	}).flatMap({ n -> n })

}

class PinHole(arg0: Vector) {
	val center: Vector = arg0
}
