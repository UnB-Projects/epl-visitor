package br.unb.cic.epl

class Size extends Visitor {
  var res : Int = 0
  override def visit(exp: Literal) { res = res + 1 }
  override def visit(exp: Add) {
    exp.lhs.accept(this)
    exp.rhs.accept(this)
    res = res + 1
  }
  override def visit(exp: Sub) {
    exp.lhs.accept(this)
    exp.rhs.accept(this)
    res = res + 1
  }
  override def visit(exp: Mult) {
    exp.lhs.accept(this)
    exp.rhs.accept(this)
    res = res + 1
  }
  def result() : Int = res
}
