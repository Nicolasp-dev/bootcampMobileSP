package com.kotlin.shophoschallenge01

fun main(){
  println("Type an output case: TypeA or TypeB")
  var textType= readln()
  var numSequence: String = numSequenceGenerator(textType)

  println("Sort by Asc or Des order")
  var sortingCommand= readln()
  numSorting(numSequence, sortingCommand)
}

fun numSequenceGenerator(textType: String): String{
  var sequenceValue: String = ""
  var randomSequence = ((Math.random()*10).toString())
    .split(".")
    .joinToString("")
    .take(8)

  when(textType){
    "TypeA" -> {
      sequenceValue = "54$randomSequence"
      println(sequenceValue)
    }
    "TypeB" -> {
      sequenceValue = "08$randomSequence"
      println(sequenceValue)
    }
    else -> println("Invalid type")
  }
  return sequenceValue
}

fun numSorting(numSequence : String, sortingCommand: String){
  var numArray : CharArray = numSequence.toCharArray()
  var tmp: Char


  when(sortingCommand){
     "Asc" -> {
       for (x in numArray.indices) {
         for (y in numArray.indices) {
           if (numArray[x] > numArray[y]) {
             tmp = numArray[x]
             numArray[x] = numArray[y]
             numArray[y] = tmp
           }
         }
       }
     }
     "Des" -> {
       for(x in numArray.indices){
         for(y in numArray.indices){
           if(numArray[x] < numArray[y]){
             tmp = numArray[y]
             numArray[y] = numArray[x]
             numArray[x] = tmp
           }
         }
       }
     }
     else -> "Invalid Command"
  }
  return println(numArray)
}