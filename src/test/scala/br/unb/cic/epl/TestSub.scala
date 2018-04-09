package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestSub extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "A Subtraction expression"

  var literal100: Literal = _
  var literal200: Literal = _

  before {
    literal100 = new Literal(100) 
    literal200 = new Literal(200) 
  }

  it should "return String (100 - 200) when we call Sub(Literal(100), Literal(200).print())" in {
    val sub = new Sub(literal100, literal200)
  
    sub.print() should be ("(100 - 200)")
  }

  it should "return -100 when we call Sub(Literal(100), Literal(200)).eval()" in {
    val eval = new Eval()
    val sub = new Sub(literal100, literal200)

    sub.accept(eval)

    eval.result() should be (-100)
  }
}
