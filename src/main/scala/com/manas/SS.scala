package com.manas
import SS._
import scala.annotation.tailrec

case class SS(pn: String, cn: String) {
  val productName = pn.replaceAll("[^\\p{L}\\p{Nd}]+", "").toLowerCase()
  val customerName = cn.replaceAll("[^\\p{L}\\p{Nd}]+", "").toLowerCase()
  /**
   * This function takes a product name and customer name and calculates the
   * suitability score based on the following condition.
   *
   * 1) If the number of letters in the product's name is even
   * then the SS is the number of vowels (a, e, i, o, u, y)
   * in the customer's name multiplied by 1.5.
   *
   * 2)If the number of letters in the product's
   * name is odd then the SS is the number of consonants in the customer's name.
   *
   * If the number of letters in the product's
   * name shares any common factors (besides 1)
   * with the number of letters in the customer's name then the SS is multiplied by 1.5.
   *
   */
  def Score: Double = {
    //Find subScore based on if product name is even or odd.
    val subScore = (productName, customerName) match {
      case (pn, cn) if (pn.length % 2 == 0) => NumOfVowels(cn) * 1.5
      case (pn, cn) if (pn.length % 2 != 0) => NumOfConsonants(cn)
    }
    //Multiply the subScore with 1.5 if the LCM is greater than 1.
    if (HasGCDGreaterThanOne(productName, customerName)) subScore * 1.5 else subScore
  }

  /**@param customerName: A lower case String @returns the number of vowels in the string **/
  def NumOfVowels(customerName: String): Int = customerName.count { vowels.contains(_) }

  /**@param customerName: A lower case String @returns the number of consonants in the string **/
  def NumOfConsonants(customerName: String): Int = customerName.count { consonants.contains(_) }

  /**
   * @param productName:String lower cased product name.
   * @param customerName:String lower cased customer name.
   * @returns Boolean if the GCD of productName length and customerName length is greater than 1.*
   */
  def HasGCDGreaterThanOne(productName: String, customerName: String) = gcd(productName.length, customerName.length) > 1

  /**
   * @param a:Int.
   * @param:b:Int.
   * @returns:Int GCD of two Integer.*
   */
  @tailrec private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

object SS {
  val vowels = List('a', 'e', 'i', 'o', 'u')
  val consonants = ('a' to 'z').diff(vowels)

}