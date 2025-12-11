console.log("Hello I am good")

let age=5;
let grace=3;
console.log(age + grace);
console.log(age - grace);
console.log(age * grace);
console.log(age / grace);
console.log(age ** grace); //exponential (ans=125)
console.log(age % grace);
age+=grace
console.log(age);

if((age-grace)>18){
    console.log("You can drive");
}
else{
    console.log("You cannot drive");
}


console.log("3"==3) //true
console.log("3"===3) //false
let a=5;
let b=3;
console.log(a!=b && b==a) //false
//ternary operator
let c= a>b ? (a-b):(b-a)
console.log(c)

//for loop
let p=0;
for(let i=0; i<10;i++){
    console.log(p+i);
}

let obj={
    name: "Sweta",
    role:"programmer",
    company:"wipro"
}
// for-in loop
for (const key in obj) {
    
    const element = obj[key];
    console.log(key,element)
}
// for-of loop
for (const c of "Sweta") {
    console.log(c) // S w e t a
}
//for-each loop
a.forEach((value, index,arr)=>{
    console.log(value, index,arr)
})
//while loop
let i= 5;
while(i<10){
    console.log(i)
    i++;
}
//do-while loop
let j=3;
do{
console.log(j)
j++
}while(j<7);