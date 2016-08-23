package com.manas
import org.scalatest._

class suitability_scoreSpec extends Matchers with FlatSpecLike {
  "suitability score" should
    " be equal to count of vowels in customer name X 1.5 for even numbered product name" in {
      val customerName = List("Jack Abraham", "John Evans", "Ted Dziuba")
      val productName = List("iPad 2 - 4-pack", "Girl Scouts Thin Mints", "Nerf Crossbow")
      val pairs = productName.flatMap(x => customerName.map(y => (x, y)))

      val scores_by_product = productName.flatMap(x => customerName.map(y => (x, y))).
        map { case (pn, cn) => (pn, cn, SS(pn, cn).Score) }.
        foreach { println }
      //groupBy { case (cn, score) => cn }.mapValues(k => k.map { _._2 }.sum)
      //scores_by_product.foreach { println }
    }
  
  it should "do it" in {
    val cn = List("Jareau Wade", "Rob Eroh", "Mahmoud Abdelkader", "Wenyi Cai", "Justin Van Winkle",
      "Gabriel Sinkin", "Aaron Adelson")
    val pn = List("Batman No. 1", "Football - Official Size", "Bass Amplifying Headphones",
      "Elephant food - 1024 lbs", "Three Wolf One Moon T-shirt", "Dom Perignon 2000 Vintage")
    //val scores = pn.flatMap(x => cn.map(y => (x, y))).
    //  map { case (pn, cn) => (pn, cn, suitability_score(pn, cn).Score) }.foreach { println }
    //val scores_by_product = scores.groupBy { case (product, score) => product }.mapValues(k => k.map { _._2 }.sum)
    //scores_by_product.foreach { println }
  }
  it should "do this too" in {
    val customerName = List("Jeffery Lebowski", "Walter Sobchak", "Theodore Donald Kerabatsos",
      "Peter Gibbons", "Michael Bolton", "Samir Nagheenanajar")
    val productName = List("Half & Half", "Colt M1911A1", "16lb bowling ball", "Red Swingline Stapler",
      "Printer paper", "Vibe Magazine Subscriptions - 40 pack")
    val scores = productName.flatMap(x => customerName.map(y => (x, y))).
      map { case (pn, cn) => (pn, cn, SS(pn, cn).Score) }.foreach { println }

  }
  
}