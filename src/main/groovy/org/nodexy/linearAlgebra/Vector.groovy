package org.nodexy.linearAlgebra

/**
 * Created by phoenix on 3/27/17.
 */
class Vector {
    private List<Double> list

    Vector(int dim) {
        list = new ArrayList<>(dim)
        dim.times {list += null}
    }

    Vector(List<Double> values) {
        list = new ArrayList<>(values.size())
        list.addAll(values)
    }

    Vector add(Vector other) {
        assert dim == other.dim
        def v = new Vector(dim)
        dim.times {i->
            v.set(i, get(i)+other.get(i))
        }
        return v
    }

    double dot(Vector other) {
        assert dim == other.dim
        def sum = 0.0
        dim.times {i-> sum += (get(i)*other.get(i))}
        return sum
    }

    Vector crossProduct(Vector other) {
        assert (dim == 3) && (other.dim == 3)
        def v = new Vector(3)
        v.set(0, get(1) * other.get(2) - get(2) * other.get(1))
        v.set(1, get(2) * other.get(0) - get(0) * other.get(2))
        v.set(2, get(0) * other.get(1) - get(1) * other.get(0))
        return v
    }

    Double get(int i) {
        return list[i]
    }

    def set(int i, Double value) {
        list[i] = value
    }

    int getDim() { list.size() }

    String toString() {
        return list.toString()
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Vector vector = (Vector) o

        if (list != vector.list) return false

        return true
    }

    int hashCode() {
        return (list != null ? list.hashCode() : 0)
    }
}
