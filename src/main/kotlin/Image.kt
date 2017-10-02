
package image

import java.io.File
import color.Color

interface Image {
    val file: File

    public fun save(arg0: String)
}

class Ppm(val arg1: String) : Image {
    override val file = File(arg1.replace(":", "")).absoluteFile

    override public fun save(arg0: String): Unit {
        file.writeText(arg0)
    }
}

public fun savePPM(arg0: String, arg1: List<Color>) {
    val picFile: Image = Ppm(arg0)

    val builder: StringBuilder = StringBuilder()
    builder.append("P3\n256 256\n255\n")
    for (color in arg1) {
        builder.append(color.toString())
    }

    picFile.save(builder.toString())
}
