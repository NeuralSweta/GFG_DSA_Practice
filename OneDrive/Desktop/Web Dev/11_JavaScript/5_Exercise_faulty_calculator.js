/* Create a faulty calculator using javascript

This faulty calculator does following:
1. it takes twonumbers as input from the user.
2. It performs wrong operations as follows:
   + ---> -
   * ---> +
   - ---> /
   / ---> **

   It performs wrong operation 10% of the time. */

   
   let random= Math.random();
   let a= prompt("Enter first number");
   let b= prompt("Enter second number");
   let c= prompt("Enter operation");

   let obj={
      "+" : "-",
      "*" : "+",
      "-": "/",
      "/":"**",

   }
   if(random>0.1){
//perform correct calculation
alert(`The result is ${eval(`${a}${c}${b}`)}`)
   }
   else{
      c= obj[c]
    alert(`The result is ${eval(`${a}${c}${b}`)}`)
   }