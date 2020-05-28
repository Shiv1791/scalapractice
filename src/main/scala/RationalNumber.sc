

class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)

  def +(that: Rational): Rational =
    new Rational(that.denominator * numerator + that.denominator * numerator, denominator * that.denominator)

  def + (n: Int):Rational = new Rational(denominator*n + numerator, denominator)

  def - (that: Rational): Rational =
    new Rational( numerator+that.denominator - that.numerator*denominator, that.denominator*denominator)

  def - (i: Int): Rational = new Rational(numerator - denominator*i, denominator)

  def *(that: Rational): Rational =
    new Rational(that.numerator*numerator, that.denominator*denominator)

  def *(n: Int):Rational = new Rational(numerator*n, denominator)

  def /(that: Rational): Rational =
    new Rational(that.denominator*numerator, that.numerator* denominator)

  def /(n: Int): Rational = new Rational(numerator, denominator*n)

  override def toString: String =  numerator+ "/"+ denominator

  def numerator: Int = n / g

  def denominator: Int = d / g

  def this(n: Int) = this(n, 1)
  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}
val a = List()

println(new Rational(1,9))