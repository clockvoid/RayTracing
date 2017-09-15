
package vector

interface Vector {

	val x: Double
	val y: Double
	val z: Double

	public infix fun dot(arg0: Vector): Double
	public infix fun cross(arg0: Vector): Vector
	public operator fun plus(arg0: Vector): Vector
	public operator fun minus(arg0: Vector): Vector
	public fun abs(): Double
	public operator fun times(arg0: Double): Vector
	public operator fun div(arg0: Double): Vector
	public fun normalize(): Vector

}

class Vector3(val arg0: Double, val arg1: Double, val arg2: Double) : Vector{

	override val x: Double = arg0
	override val y: Double = arg1
	override val z: Double = arg2

	override public infix fun dot(arg0: Vector): Double = arg0.x * this.x + arg0.y * this.y + arg0.z * this.z
	override public infix fun cross(arg0: Vector): Vector = Vector3(this.y * arg0.z - this.z * arg0.y, this.z * arg0.x - this.x * arg0.z, this.x * arg0.y - this.y * arg0.x)
	override public operator fun plus(arg0: Vector): Vector = Vector3(arg0.x + this.x, arg0.y + this.y, arg0.z + this.z)
	override public operator fun minus(arg0: Vector): Vector = Vector3(this.x - arg0.x, this.y - arg0.y, this.z - arg0.z)
	override public fun abs(): Double = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z)
	override public operator fun times(arg0: Double): Vector = Vector3(this.x * arg0, this.y * arg0, this.z * arg0)
	override public operator fun div(arg0: Double): Vector = Vector3(this.x / arg0, this.y / arg0, this.z / arg0)
	override public fun toString(): String = "(" + this.x.toString() + "," + this.y.toString() + "," + this.z.toString() + ")"
	override public fun normalize(): Vector = this / (this.abs())

}

