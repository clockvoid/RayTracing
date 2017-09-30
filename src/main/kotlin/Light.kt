
package light 

import vector.Vector
import color.Color

interface LightSource {
    val intensity: Double
}

class PointLightSource(arg0: Vector, arg1: Double): LightSource {
    val position: Vector = arg0
    override val intensity = arg1
}

class Lighting(arg0: Double, arg1: Color, arg2: Vector) {
    val distance: Double = arg0
    val intensity: Color = arg1
    val direction: Vector = arg2
}
