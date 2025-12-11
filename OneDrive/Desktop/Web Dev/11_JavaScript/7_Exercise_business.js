/* Create a business name generator by combining list of adjective and shop name and another word.

adjective list:
Crazy
Amazing
Fire

Shop name:
Engine
Food
Garments

Another Word:
Bros
Limited
Hub
*/

let rand1= Math.random()
let first,second,third;
//0 , 0.33, 0.66, 1
if(rand<0.33){
    first="Crazy"
}
else if(rand<0.66 && rand>=0.33){
    first="Amazing"
}
else{
    first= "Fire"
}
//
let rand2= Math.random();
if(rand<0.33){
    second="Engine"
}
else if(rand<0.66 && rand>=0.33){
    second="Garments"
}
else{
    second= "Foods"
}
//
let rand3= Math.random()
if(rand<0.33){
    third="Bros"
}
else if(rand<0.66 && rand>=0.33){
    third="Limited"
}
else{
    third= "Hub"
}
console.log(`${first} ${second} ${third}`)


