
package body

import color.Color
import vector.Vector

interface Body {

	val color: Color
	val kd: Double
	val center: Vector

}
