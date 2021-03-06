package com.knoldus.palindromeAndFactorialTrait

class palindromeAndFactorial extends palindromeAndFactorialTrait {
  override def palindrome(number: Int): Boolean = {
    var reverse: Int = 0
    var remainder: Int = 0
    var temp: Int = number

    while(temp>0){
      remainder = temp % 10
      reverse = reverse * 10 + remainder
      temp /= 10
    }

    if(reverse == number)
      true
    else
      false
  }

  override def factorial(number: Int): Int = {
    var result:Int = 1

    for(i <- 2 to number){
      result *= i
    }
    result
  }
}
