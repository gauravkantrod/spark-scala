package stringUtils

import org.apache.commons.lang3.StringUtils

object PracticeStringUtils extends App {

//  println(StringUtils.isEmpty("ABCD"))
//  println(StringUtils.isEmpty(""))
//  println(StringUtils.isEmpty(null))
//
//  println(StringUtils.isBlank(""))
//  println(StringUtils.isBlank("ABCD"))
//  println(StringUtils.isBlank(null))
//  println(StringUtils.isBlank("    "))

//  println(StringUtils.trim("ABC"))
//  println(StringUtils.trim("  ABC  "))
//  println(StringUtils.trim(null))
//
//
//  println(StringUtils.strip("ABC"))
//  println(StringUtils.strip("  ABC  "))
//  println(StringUtils.strip(null))

//  println(StringUtils.compare("ABA", "ABA"))
//  println(StringUtils.compare("ABA", "ABC"))
//  println(StringUtils.compare("ABA", null))
//  println(StringUtils.compare(null, null))

//  println(StringUtils.equals("ABA", "ABA"))
//  println(StringUtils.equals("ABA", "ABC"))
//  println(StringUtils.equals("ABA", null))
//  println(StringUtils.equals(null, null))

//  println(StringUtils.startsWith(null, null))
//  println(StringUtils.startsWith("abc", null))
//  println(StringUtils.startsWith("abcdef", "abc"))

//  println(StringUtils.endsWith(null, null))
//  println(StringUtils.endsWith("abc", null))
//  println(StringUtils.endsWith("abcdef", "abc"))
//  println(StringUtils.endsWith("abcdef", "ef"))

//  println(StringUtils.contains("aBC", "b"))
//  println(StringUtils.contains("aBC", "BC"))
//  println(StringUtils.contains("aBC", "abc"))

//  println(StringUtils.lastIndexOfAny("ABCABC", "C"))
//  println(StringUtils.lastIndexOfAny("ABCABC", "B"))
//  println(StringUtils.lastIndexOfAny("ABCABC", null))
//  println(StringUtils.lastIndexOfAny("ABCABC", "Z"))
//  println(StringUtils.lastIndexOfAny(null, "ABC"))

//  println(StringUtils.rotate("ABC", 1))
//  println(StringUtils.rotate(null, 1))
//  println(StringUtils.rotate("ABC", -1))
//  println(StringUtils.rotate("ABC", -3))

//  println(StringUtils.reverse("ABC"))
//  println(StringUtils.reverse(null))
//  println(StringUtils.reverse("ABC"))

//  println(StringUtils.reverseDelimited(null, 'x'))
//  println(StringUtils.reverseDelimited("ABC.BCS.PQR", '.'))

//  try{
//    //println(StringUtils.getLevenshteinDistance(null, null))
//    println(StringUtils.getLevenshteinDistance("ABC", "PQR"))
//    //println(StringUtils.getLevenshteinDistance(null, "PQR")) // will throw exception
//  }
//  catch {
//    case e => println(e.getMessage)
//    case e:Exception => println(s"Hello, ${e.getMessage}")
//  }

//  println(StringUtils.difference(null, "ABC")) // what's extra in in string 2 from string 1
//  println(StringUtils.difference("ABCD", "ABC"))
//  println(StringUtils.difference("I am a bot", "I want a   I robot"))

//  println(StringUtils.defaultString(null))
//  println(StringUtils.defaultString("I am a Boies"))

//  println(StringUtils.chop("abc"))
//  println(StringUtils.chop(null))
//  println(StringUtils.chop("I am a boy."))

//  println(StringUtils.isAlpha("ABC"))
//  println(StringUtils.isAlpha("A12BC"))
//  println(StringUtils.isAlpha("Iamaboy"))
//  println(StringUtils.isAlpha("I am a boi 123"))

//  println(StringUtils.isNumeric("ABC"))
//  println(StringUtils.isNumeric("123"))
//  println(StringUtils.isNumeric("ABC 123"))
//  println(StringUtils.isNumeric("123 123"))

//  println(StringUtils.isWhitespace("   "))
//  println(StringUtils.isWhitespace("ABC"))
//  println(StringUtils.isWhitespace(""))
//  println(StringUtils.isWhitespace("123"))

//  println(StringUtils.countMatches("I am a boy", "i"))

//  println(StringUtils.upperCase("ABC"))
//  println(StringUtils.upperCase("abc"))
//  println(StringUtils.upperCase("hiij an aokk   a"))
//  println(StringUtils.upperCase(null))

//  println(StringUtils.capitalize("ABC"))
//  println(StringUtils.capitalize("abc"))
//  println(StringUtils.capitalize("hiij an aokk   a"))
//  println(StringUtils.capitalize(null))

//  println(StringUtils.uncapitalize("ABC"))
//  println(StringUtils.uncapitalize("abc"))
//  println(StringUtils.uncapitalize("hiij an aokk   a"))
//  println(StringUtils.uncapitalize(null))

//  println(StringUtils.swapCase("ABC"))
//  println(StringUtils.swapCase("abc"))
//  println(StringUtils.swapCase("hiij an aokk   a"))
//  println(StringUtils.swapCase(null))

//  StringUtils.split("Hello Gaurav").foreach(println)
//  StringUtils.split("HelloGaurav").foreach(println)

//  println(StringUtils.leftPad("ABC", 3, "*"))
//  println(StringUtils.leftPad("ABCdd", 3))
//  println(StringUtils.leftPad("ABCdd", 7, "*"))
//  println(StringUtils.leftPad("ABCdd", 2, "*"))

//  println(StringUtils.rightPad("ABC", 3, "*"))
//  println(StringUtils.rightPad("ABCdd", 3))
//  println(StringUtils.rightPad("ABCdd", 7, "*"))
//  println(StringUtils.rightPad("ABCdd", 2, "*"))

  println(StringUtils.prependIfMissing("abc", "c"))
  println(StringUtils.prependIfMissing("cabc", "c"))
  println(StringUtils.prependIfMissing("I am a boy", "Boies "))





}