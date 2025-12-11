let arr=[1,2,5,7,9]

arr[0]= 5666;
console.log(arr)
console.log(arr.length)
console.log(arr[0])
console.log(arr[2])
console.log(arr[4])

console.log(arr.toString())
console.log(arr.join(" and "))
console.log(arr.pop()) //9
console.log(arr.push(100)) // push returns length=5, [5666 , 2,5,7,100]
console.log(arr.shift()) // remove first element
console.log(arr.unshift("Sweta")) // l=5 ,add to first element
console.log(delete arr[5]);

let numbers= [1,2,3,4,5]
numbers.splice(1,3,222,333)
//numbers.splice(index to add,no.of elements to remove,add,add)

console.log(numbers)

//
let num=[1,13,5,7,11];
// let newArr= []
// for(let index=0; index< num.length; index++){
//     const element= num[index];
//     newArr.push(element**2)
// }
//console.log(newArr) //[ 1, 169, 25, 49, 121 ]

//other method
let newArr= num.map((e)=>{
    return e**2
})
console.log(newArr) //[ 1, 169, 25, 49, 121 ]
//filter
const greaterThanHundred=(e)=>{
    if(e>100){
        return true
    }
    return false
}
console.log(newArr.filter(greaterThanHundred)) //[ 169, 121 ]

let arr2= [1,2,3,4,5,6]
const red= (a,b)=>{
    return a*b
}
console.log(arr2.reduce(red)) //720

console.log(Array.from("Sweta"))