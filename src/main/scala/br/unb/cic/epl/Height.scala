package br.unb.cic.epl
import scala.math.max

class Height extends Visitor{
  var res : Int = 0 
  var l   : Int = 0
  var r   : Int = 0
  override def visit(exp: Literal) { res = res + 1 } 
  override def visit(exp: Add) {
    l = 0
    r = 0
    exp.lhs.accept(this)
    l = l + 1
    exp.rhs.accept(this)
    r = r + 1
    res = max(l,r) + 1
  }
  override def visit(exp: Sub) {
    l = 0
    r = 0
    exp.lhs.accept(this)
    l = l + 1
    exp.rhs.accept(this)
    r = r + 1
    res = max(l,r) + 1
  }
  override def visit(exp: Mult) {
    l = 0
    r = 0
    exp.lhs.accept(this)
    l = l + 1
    exp.rhs.accept(this)
    r = r + 1
    res = max(l,r) + 1
  }
  def result() : Int = res
}