/* Write a program to calculate factorial of a number using for loops 
*/
let a=6
function factorial(number){
    let arr= Array.from(Array(number+1).keys())
    console.log(arr.slice(1,))
    let c= arr.slice(1,).reduce((a,b)=>{
        return a*b
    })
    console.log(c)
}
factorial(a)

//other method
let b=5
function facFor(number){
    let fac=1;
    for(let index=1; index<=number;index++){
        fac= fac* index
    }
    return fac
}
console.log(facFor(b))