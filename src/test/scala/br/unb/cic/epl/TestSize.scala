package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestSize extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Size count"

  var literal100: Literal = _
  var literal200: Literal = _

  before {
    literal100 = new Literal(100)
    literal200 = new Literal(200)
  }

  it should "return 3 when we call Add(Literal(100), Literal(200)).size()" in {
    val size = new Size()
    val add = new Add(literal100, literal200)

    add.accept(size)
    size.result() should be (3)
  }

  it should "return 5 when we call Add(Add(Literal(100), Literal(200)), Literal(200)).size()" in {
    val size = new Size()
    val add = new Add(new Add(literal100, literal200), literal200)

    add.accept(size)
    size.result() should be (5)
  }

  it should "return 3 when we call Sub(Literal(100), Literal(200)).size()" in {
    val size = new Size()
    val sub = new Sub(literal100, literal200)

    sub.accept(size)
    size.result() should be (3)
  }

  it should "return 5 when we call Sub(Sub(Literal(100), Literal(200)), Literal(200)).size()" in {
    val size = new Size()
    val sub = new Sub(new Sub(literal100, literal200), literal200)

    sub.accept(size)
    size.result() should be (5)
  }

  it should "return 3 when we call Mult(Literal(100), Literal(200)).size()" in {
    val size = new Size()
    val mult = new Mult(literal100, literal200)

    mult.accept(size)
    size.result() should be (3)
  }

  it should "return 5 when we call Mult(Mult(Literal(100), Literal(200)), Literal(200)).size()" in {
    val size = new Size()
    val mult = new Mult(new Mult(literal100, literal200), literal200)

    mult.accept(size)
    size.result() should be (5)
  }
}
