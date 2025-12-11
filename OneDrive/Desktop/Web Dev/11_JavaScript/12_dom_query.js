console.log("Sweta")
//selecting by class...
// let boxes= document.getElementsByClassName("box")
// console.log(boxes)

// boxes[2].style.backgroundColor="red"


//selecting by id...
// document.getElementById("red").style.backgroundColor="pink"

//selecting  by query...
// document.querySelector(".box").style.backgroundColor="aqua";
document.querySelectorAll(".box").forEach(e=>{
    e.style.backgroundColor="aqua";
})
//for query selector on multiple elements use loop.

// document.getElementsByTagName("div")

e= document.getElementsByTagName("div")
e[4].matches("#redbox") //false
e[3].closest("#red")
e[3].closest(".container")

document.querySelector(".container").contains(e[2])
document.querySelector(".container").contains(e[0])
document.querySelector(".container").contains(document.querySelector("body")) //false
document.querySelector("body").contains(document.querySelector(".container")) //true
