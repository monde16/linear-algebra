package org.nodexy.linearAlgebra

import org.junit.Test

/**
 * Created by phoenix on 3/27/17.
 */
class VectorTest {
    @Test
    void testCtor() {
        def vlist = [1d, 2d, 3d]
        def wlist = [-2d, 0d, 7d]
        def v = new Vector(vlist)
        def w = new Vector(3)
        wlist.size().times {i-> w.set(i, (Double) wlist[i])}
        assert v.dim == 3 && w.dim == 3

        v.dim.times {i->
            assert v.get(i) == vlist[i]
        }
        w.dim.times {i->
            assert w.get(i) == wlist[i]
        }

        assert v.add(w) == new Vector([-1,2,10])
        assert v.dot(w) == 19d
        println "v = $v"
        println "w = $w"
    }
}
