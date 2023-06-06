package main

import "fmt"

func main() {
	//2different ways to handle  variables
	someString := "This should be ok"
	var num = 7
	var num2 int = 78
	// can more then 1 var in same row with different casting
	var a, b = 2, .4

	fmt.Println(someString)
	fmt.Println(num)
	fmt.Println(num2)
	fmt.Println(a)
	fmt.Println(b)
	//can also do some calculation or response  within the function
	fmt.Println("Can do math in this function, 2+2 = ", 2+2)
}
