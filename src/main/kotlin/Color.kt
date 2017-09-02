
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
        builder.append(this.red.toString())
        builder.append(" ")
        builder.append(this.green.toString())
        builder.append(" ")
        builder.append(this.blue.toString())
        builder.append("\n")
        return builder.toString()
    }

}
