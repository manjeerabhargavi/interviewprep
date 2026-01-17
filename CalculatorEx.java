package com.javapractice.javainterview;
@FunctionalInterface
public interface CalculatorEx {
   int apply(int a,int b);
   static int zero(){
    return 0;
   } 
   default int inc(int x){
      return x = x+1;
   }
  
   
private void log(String s) { /* Java 9+ private method */ }
}
