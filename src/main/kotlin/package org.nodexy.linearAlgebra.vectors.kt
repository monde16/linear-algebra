/**
 * Created by phoenix on 6/9/17.
 */

data class Vector(val values: Array<Double>) {
    val dim: Int
        get() = values.size

    constructor(values: Array<Int>): this(values.map(Int::toDouble).toTypedArray())
    constructor(vararg values: Double): this(values.toTypedArray())
    constructor(vararg values: Int): this(values.toTypedArray())

    infix fun plus(v: Vector): Vector {
        val u = this
        assert(u.dim == v.dim)
        val args = u.values.copyOf()
        for (i in 0  until  u.dim) {
            args[i] = u.values[i] + v.values[i]
        }
        return Vector(args)
    }

    infix fun minus(v: Vector): Vector {
        val u = this
        assert(u.dim == v.dim)
        val args = u.values.copyOf()
        for (i in 0  until  u.dim) {
            args[i] = u.values[i] - v.values[i]
        }
        return Vector(args)
    }

    infix fun times(x: Double): Vector {
        val u = this
        val args = u.values.copyOf()
        for (i in 0  until  u.dim) {
            args[i] = u.values[i] * x
        }
        return Vector(args)
    }
    infix fun times(x: Int) = times(x.toDouble())

    infix fun dot (other: Vector): Double {
        val u = this
        assert(u.dim == other.dim)
        val args = u.values.copyOf()
        for (i in 0  until  u.dim) {
            args[i] = u.values[i] * other.values[i]
        }
        return args.reduce(Double::plus)
    }

    fun len(): Double = Math.sqrt(values.map { it*it }.reduce { x, y-> x+y})
    fun theta(): Double {
        TODO()
    }

    fun normalize(): Vector = this times (1.0 / len())
}

fun main(args: Array<String>) {
    var u: Vector
    var v: Vector
    val pairs = mutableListOf<Pair<Vector,Vector>>()
    val singles = mutableListOf<Vector>()

//    u = Vector(8.218,-9.341)
//    v = Vector(-1.129,2.111)
//    println("$u + $v = ${u plus v}")
//
//    u = Vector(7.119,8.215)
//    v = Vector(-8.223,0.878)
//    println("$u - $v = ${u minus v}")
//
//    u = Vector(1,1,1)
//    v = Vector(1,2,3)
//    println("$u . $v = ${u dot v}")
//
//    val x = 7.41
//    v = Vector(1.671,-1.012,-0.318)
//    println("$x * $v = ${v times x}")
//
//    assert(Vector(-1,1,1).normalize().len() == 1.0)

    /*singles.addAll(listOf(
            Vector(-0.221,7.437),
            Vector(8.813,-1.331,-6.247)
    ))
    singles.forEach { println(it.len()) }
    singles.clear()

    println()
    singles.addAll(listOf(
            Vector(5.581,-2.136),
            Vector(1.996,3.108,-4.554)
    ))
    singles.forEach { println(it.normalize()) }*/
}
