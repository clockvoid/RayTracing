
import vector.Vector
import vector.Vector3
import color.Color
import color.Color3
import image.savePPM
import ray.Ray
import ray.IntersectionPoint
import cord.Cord
import cord.Screen
import cord.PinHole
import shape.Shape
import shape.Sphere
import light.LightSource
import light.PointLightSource
import java.time.LocalDateTime

infix fun Double.pow(arg0: Double) = Math.pow(this, arg0)

val Rx: Double = 256.0
val Ry: Double = 256.0

val size: Double = 5.0

val a: Vector = Vector3(0.0, 0.0, 4.0)
val L: Vector = Vector3(-10.0, 10.0, 15.0)
val lp: Double = 1.0
val kd: Double = 0.69
val ka: Double = 0.01
val ks: Double = 0.3
val alpha: Double = 5.0
val la: Double = 0.1

fun D(arg0: Vector): Double = ((a - arg0).normalize() dot arg0).pow(2.0) - (arg0.abs().pow(2.0) - 1.0)

fun t(arg0: Vector): Double = (-1.0) * ((a - arg0).normalize() dot arg0) - Math.sqrt(D(arg0))

//fun <X, Y, Z> Function1<X, Y>.plus(f: (Z) -> X) = (z: Z) -> this(f(z))

fun main(args: Array<String>) {
    //TODO: calc lighting and color
    val ball: Shape = Sphere(Color3(255, 0, 0), Vector3(0.0, 0.0, 0.0), kd, 1.0, null)
    val light: LightSource = PointLightSource(Vector3(-10.0, 10.0, 15.0), 1.0)
    val cord: Cord = Cord(Screen(Vector3(0.0, 0.0, 10.0), Rx, Ry, size), PinHole(a))
    val points: List<IntersectionPoint?> = cord.rays.map {
        ray -> ball.testIntersection(ray)
    }
    val colorCord: List<Color> = points.map {
        point -> if (point == null) {
            Color3(100, 149, 237)
        } else {
            ball.color
        }
    }
    savePPM("pic" + LocalDateTime.now().toString() + ".ppm", colorCord)
}

/*fun main(args: Array<String>) {

    val cord: List<Vector> = List(Ry.toInt(), {
        t -> List(Rx.toInt(), {
            l -> Vector3(size / Rx * (0.5 + (Rx - 1 - l)) - size / 2 , (-1.0) * size / Ry * (0.5 + (Ry - 1 - t)) + size / 2, 10.0)
        })
    }).flatMap({ n -> n })

    /*
    val rayCord: List<Ray> = cord.map {
        o -> Ray(o, (a - o).normalize())
    }*/

    val colorCord: List<Color> = cord.map {
        vec -> if (D(vec) >= 0.0 && t(vec) >= 0.0) {
            val d: Vector = (a - vec).normalize() // ray
            val td: Vector = (a - vec).normalize() * t(vec) // the point of collision
            val n: Vector = (vec + td).normalize() // the normal vector
            // val nColor: Vector = (n + Vector3(1.0, 1.0, 1.0)) / 2.0 //for display vector by color
            val tmpCos: Double = ((L - (vec + td)).normalize()) dot n // cos, it can be less than zero
            val cos: Double = if (tmpCos <= 0) 0.0 else tmpCos // check if cos value is more than zero
            val Rs: Double = if (tmpCos <= 0) {
                ((n * cos * 2.0 - (L - (vec + td)).normalize()) dot d).pow(alpha) * ks * lp
            } else {
                0.0
            }
            val gray: Double = (ka * la + lp * kd * cos + Rs) * 255 // shading
            //Color3((nColor.x * 255.0).toInt(), (nColor.y * 255.0).toInt(), (nColor.z * 255.0).toInt())
            Color3(gray.toInt(), gray.toInt(), gray.toInt())
            //Color3((t(vec) * 255).toInt(), (t(vec) * 255).toInt(), (t(vec) * 255).toInt())
        } else {
            Color3(100, 149, 237) // background color is black
        }
    }

    // val str = colorCord.flatMap({ n -> n }).fold("P3\n256 256\n255\n", { c1, c2 -> c1.toString() + c2.toString() }) // this solution is too late!!! because Java's plus operator with String is too late.

    savePPM("pic" + LocalDateTime.now().toString() + ".ppm", colorCord)

}*/
