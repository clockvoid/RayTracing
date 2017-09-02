
package image

import java.io.File

interface Image {
    val file: File

    public fun save(arg0: String)
}

class Ppm(val arg1: String) : Image {
    override val file = File(arg1).absoluteFile
    
    override public fun save(arg0: String): Unit {
        file.writeText(arg0)
    }
}
