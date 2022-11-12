package com.kotlin.shophoschallenge01

fun main(){
  val textType: String
  var numSequence = ""
  var dataValue = 0
  var validInput = false

  while(!validInput){
    println("Which kind of number sequence do you want? " +
            "\n1. TypeA = \"54********\" " +
            "\n2. TypeB = \"08********\"" )
    dataValue = readln().toInt()
    if(dataValue == 1 || dataValue == 2) validInput = true else continue
  }

  when(dataValue){
    1 -> {
      textType = "TypeA"
      numSequence = numSequenceGenerator(textType)
    }
    2 -> {
      textType = "TypeB"
      numSequence = numSequenceGenerator(textType)
    }
  }

  println("\nGreat ! Now let's sort this numeric sequence. " +
          "\nType one of the following commands: \"Asc\" or \"Desc\"."  +
          "\n* Asc = Ascending order * Desc = Descending order")
  val sortingCommand : String = readln()

  numSorting(numSequence, sortingCommand)

}

fun numSequenceGenerator(textType: String): String{
  var sequenceValue = ""
  val randomSequence = ((Math.random()*10).toString())
    .split(".")
    .joinToString("")
    .take(8)

  when(textType){
    "TypeA" -> {
      sequenceValue = "54$randomSequence"
      println("TypeA sequence: $sequenceValue")
    }
    "TypeB" -> {
      sequenceValue = "08$randomSequence"
      println("TypeB sequence: $sequenceValue")
    }
  }
  return sequenceValue
}

fun numSorting(numSequence : String, sortingCommand: String) {
  val numArray : CharArray = numSequence.toCharArray()
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
       println("Ascending Order:")
     }
     "Desc" -> {
       for(x in numArray.indices){
         for(y in numArray.indices){
           if(numArray[x] < numArray[y]){
             tmp = numArray[y]
             numArray[y] = numArray[x]
             numArray[x] = tmp
           }
         }
       }
       println("Descending Order:")
     }  else -> return println("Invalid Command")
  }
  return println(numArray.contentToString())
}