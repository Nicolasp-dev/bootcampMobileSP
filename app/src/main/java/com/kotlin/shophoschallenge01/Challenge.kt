package com.kotlin.shophoschallenge01

fun main(){
  val typeA = "TypeA"
  val typeB = "TypeB"
  val numSequence: String
  val sortingCommand: String
  var dataValue = 0
  var validInput = false
  val dataText = "Which kind of number sequence do you want? \n1. TypeA = \"54********\"\n2. TypeB = \"08********\""
  val sortingText = "\n:::Great ! Now let's sort this numeric sequence:::\nType one of the following commands: \"Asc\" or \"Desc\"."  +
             "\n* Asc = Ascending order * Desc = Descending order"

  // Input data validation.
  while(!validInput){
    println(dataText)
    dataValue = readln().toInt()
    if(dataValue == 1 || dataValue == 2) validInput = true else continue
  }

  // Conditional initialization of "textType" variable & functions execution.
  when(dataValue){
    1 -> {
      numSequence = numSequenceGenerator(typeA)
      println(sortingText)
      sortingCommand = readln()
      numSorting(numSequence, sortingCommand)
    }
    2 -> {
      numSequence = numSequenceGenerator(typeB)
      println(sortingText)
      sortingCommand = readln()
      numSorting(numSequence, sortingCommand)
    }
  }
}


fun numSequenceGenerator(textType: String): String{
  var sequenceValue = ""
  // ** Numeric Sequence Creation **
  // 1. Generate a Random #, then multiply by 10 and set it into a String type.
  val randomSequence = ((Math.random()*10).toString())
    // 2. The numeric String is separated by it's dot, this return an array with 2 values.
    .split(".")
    // 3. Put together both values into a single value as a String.
    .joinToString("")
    // 4. Take the first eight values of the string.
    .take(8)

  // Conditional sequence generation
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
  // Convert the first parameter into a character array.
  val numArray : CharArray = numSequence.toCharArray()
  // Auxiliary variable: this will holds temporary values to sort the array.
  var tmp: Char

  when(sortingCommand){
     "Asc" -> {
       // Main loop: Iterate for each array element.
       for (x in numArray.indices) {
         // Secondary loop: Iterate over the iterate element.
         for (y in numArray.indices) {
           // Conditional sorting => Greater than.
           if (numArray[x] > numArray[y]) {
             // Sorting values
             tmp = numArray[x]
             numArray[x] = numArray[y]
             numArray[y] = tmp
           }
         }
       }
       println("Ascending Order:")
     }
     "Desc" -> {
       // Main loop: Iterate for each array element.
       for(x in numArray.indices){
         // Secondary loop: Iterate over the iterate element.
         for(y in numArray.indices){
           // Conditional sorting => Smaller than.
           if(numArray[x] < numArray[y]){
             // Sorting values
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