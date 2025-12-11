
console.log("Hey Sweta you are nice!")
console.log("Hey Sweta you are amazing!")
console.log("Hey Sweta you have nice personality!")
console.log("Hey Sweta you are gorgeous too!")

//making function
function nice(name){
    console.log("Hey "+ name +" You are nice!")
    console.log("Hey "+ name +" you are amazing!")
console.log("Hey "+ name +" you have nice personality!")
console.log("Hey "+ name + " you are gorgeous too!")
}
nice("pooja")
nice("Rahul")

function sum(a,b,c=3){
    // console.log(a+b)
    return a+b+c
}
result= sum(3,5)
console.log("The Sum of these numbers is: ", result)

//arrow fxn
const func1 = (x)=> {
    console.log("I am an arrow fxn",x)
}
func1(34);
func1(66);
func1(88);
func1(100);