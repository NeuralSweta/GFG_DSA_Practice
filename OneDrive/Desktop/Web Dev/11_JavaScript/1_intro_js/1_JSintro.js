alert("Hello World");

console.log("Hey I am Console1...")
console.log("Hey I am Console2...")
console.log("Hey I am Console3...")

var a= prompt("Enter Your Number:")
var isTrue = confirm("Are you sure you want to leave this page")
if(isTrue){
    console.log("Turning back to homepage.")
}
else{console.log("Staying on the page.")}
console.log("Your number is "+a)

document.title= "Hey I am good"
document.body.style.backgroundColor= "aqua"