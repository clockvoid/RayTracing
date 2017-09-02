
import vector.Vector
import vector.Vector3
import color.Color
import color.Color3
import java.io.File

val Rx: Double = 256.0
val Ry: Double = 256.0

val size: Double = 5.0

fun main(args: Array<String>) {
    val cord: Array<Array<Vector3>> = Array(Rx.toInt(), { l -> Array(Ry.toInt(), { t -> Vector3(size / Rx * (0.5 + l) - size / 2 , size / Ry * (0.5 + t) - size / 2, 10.0) }) })

    val colorCord = cord.map({ xs -> xs.map({ vec -> if ((Math.pow(((Vector3(0.0, 0.0, 4.0) - vec) / ((Vector3(0.0, 0.0, 4.0) - vec).abs())) dot vec, 2.0) - (Math.pow(vec.abs(), 2.0) - 1.0)) >= 0.0) Color3(255, 0, 0) else Color3(255, 255, 255) }) })

    val picFile = File("pic.ppm").absoluteFile

    val builder = StringBuilder()
    builder.append("P3\n256 256\n255\n")
    for (colors in colorCord) {
        for (col in colors) {
            //picFile.appendText(col.toString())
            builder.append(col.toString())
        }
    }

    picFile.writeText(builder.toString())

}
