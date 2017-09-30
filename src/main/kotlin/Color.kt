
package color

interface Color {
    val red: Int
    val green: Int
    val blue: Int
}

class Color3(val arg0: Int, val arg1: Int, val arg2: Int) : Color {

    override val red: Int = arg0
    override val green: Int = arg1
    override val blue: Int = arg2

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append(red.toString())
        builder.append(" ")
        builder.append(green.toString())
        builder.append(" ")
        builder.append(blue.toString())
        builder.append("\n")
        return builder.toString()
    }

}

class FColor(arg0: Double, arg1: Double, arg2: Double) {
    val red: Double = arg0
    val green: Double = arg1
    val blue: Double = arg2

    fun toColor(): Color = Color3(red.toInt(), green.toInt(), blue.toInt())
    override fun toString(): String {
        val builder = StringBuilder()
        builder.append(red.toString())
        builder.append(" ")
        builder.append(green.toString())
        builder.append(" ")
        builder.append(blue.toString())
        builder.append("\n")
        return builder.toString()
    }
}
