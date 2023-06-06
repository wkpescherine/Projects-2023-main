package main

import "fmt"

func main() {
	//creates a normal emoty string
	a := []string{}
	fmt.Println(a, " with a length of ", len(a))

	//make90 allows you to slice the array
	//and create a new mutable array
	a = make([]string, 10)
	fmt.Println(a, " with a length of ", len(a))

	a[2] = "test"
	a[7] = "A new word"

	fmt.Println(a, " with a length of ", len(a))
}
