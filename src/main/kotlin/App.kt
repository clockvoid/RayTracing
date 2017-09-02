
import vector.Vector
import vector.Vector3
import color.Color
import color.Color3
import image.Image
import image.Ppm

infix fun Double.pow(arg0: Double) = Math.pow(this, arg0)

val Rx: Double = 256.0
val Ry: Double = 256.0

val size: Double = 5.0

val a: Vector = Vector3(0.0, 0.0, 4.0)

fun calc(arg0: Vector) {
	println(arg0.abs())
}

fun main(args: Array<String>) {

    val cord: List<List<Vector>> = List(Rx.toInt(), {
        l -> List(Ry.toInt(), {
            t -> Vector3(size / Rx * (0.5 + l) - size / 2 , size / Ry * (0.5 + t) - size / 2, 10.0)
        })
    })

    val colorCord: List<List<Color>> = cord.map {
        xs -> xs.map {
            vec -> if (((((a - vec) / (a - vec).abs()) dot vec).pow(2.0) - (vec.abs().pow(2.0) - 1.0)) >= 0.0) {
                Color3(255, 0, 0)
            } else {
                Color3(255, 255, 255)
            }
        }
    }

    val picFile: Image = Ppm("pic.ppm")

    val builder: StringBuilder = StringBuilder()
    builder.append("P3\n256 256\n255\n")
    for (colors in colorCord) {
        for (col in colors) {
            builder.append(col.toString())
        }
    }

    // val str = colorCord.flatMap({ n -> n }).fold("P3\n256 256\n255\n", { c1, c2 -> c1.toString() + c2.toString() }) // this solution is too late!!! because Java's plus operator with String is too late.

    picFile.save(builder.toString())

}
