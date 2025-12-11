let button= document.getElementById("btn")
button.addEventListener("click",()=>{
    alert("This will move you to the external browser.")
    document.querySelector(".box").innerHTML= "<b>Yayy you were clicked</b> Enjoy your click!"
    
})
button.addEventListener("contextmenu",()=>{
    alert("Right CLick Please.")
    
})
document.addEventListener("Keydown",(e)=>{
    console.log(e.key, e.keyCode)
})