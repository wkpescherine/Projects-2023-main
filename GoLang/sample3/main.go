package main

import "fmt"

func main() {
	//This is all loops
	a := 0
	for a < 4 {
		fmt.Println(a)
		a += 1
	}
	for b := 0; b < 6; b++ {
		fmt.Println(b)
	}
	for c := 0; c < 10; c++ {
		//The continue allow for askip of the iteration
		if c%2 == 0 {
			continue
		}
		fmt.Println(c)
	}
}
