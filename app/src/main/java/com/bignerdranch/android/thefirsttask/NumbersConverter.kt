package com.bignerdranch.android.thefirsttask

public class NumbersConverter(){
    var Numbers:MutableMap<Int, String> = mutableMapOf(Pair(0,"ноль"))
    init {
        Numbers.put(1,"один")
        Numbers.put(2,"два")
        Numbers.put(3,"три")
        Numbers.put(4,"четыре")
        Numbers.put(5,"пять")
        Numbers.put(6,"шесть")
        Numbers.put(7,"семь")
        Numbers.put(8,"восемь")
        Numbers.put(9,"девять")
        Numbers.put(10,"десять")
        Numbers.put(11,"одиннадцать")
        Numbers.put(12,"двенадцать")
        Numbers.put(13,"тринадцать")
        Numbers.put(14,"четырнадцать")
        Numbers.put(15,"пятнадцать")
        Numbers.put(16,"шестнадцать")
        Numbers.put(17,"семнадцать")
        Numbers.put(18,"восемнадцать")
        Numbers.put(19,"девятнадцать")
        Numbers.put(20,"двадцать")
        Numbers.put(30,"тридцать")
        Numbers.put(40,"сорок")
        Numbers.put(50,"пятьдесят")
        Numbers.put(60,"шестьдесят")
        Numbers.put(70,"семьдесят")
        Numbers.put(80,"восемьдесят")
        Numbers.put(90,"девяносто")
        Numbers.put(100,"сто")
        Numbers.put(200,"двести")
        Numbers.put(300,"тристо")
        Numbers.put(400,"четыресто")
        Numbers.put(500,"пятьот")
        Numbers.put(600,"шестьсот")
        Numbers.put(700,"семьсот")
        Numbers.put(800,"восемьсот")
        Numbers.put(900,"девятьсот")
    }
    public fun convert(number: Int): String?{
        var result: String? = null
        var hundreds: Int = number/100
        var tens: Int = (number-100*hundreds)/10
        var units: Int = number - 100*hundreds - 10*tens
     if(number<=20){return Numbers[number]}
     if(number%100 == 0 ){return Numbers[number] }
        else{
         if((Numbers[hundreds*100] != null) && (Numbers[hundreds*100] != "ноль") ){
             result = Numbers[hundreds*100]
             if(number%100 <= 20){
                result += " "
                result += Numbers[number%100]
                return (result)}
         }
         else{result = ""}
         if((Numbers[tens*10] != null) && (Numbers[tens*10] != "ноль") ){
             result += " "
             result += Numbers[tens*10] }
         else{result += ""}
         if((Numbers[units] != null) && (Numbers[units] != "ноль") ){
             result += " "
             result += Numbers[units] }
         else{result += ""}
     return result
     }
    }

}