package main

import "fmt"

func main() {
	if 7%2 == 0 {
		fmt.Println("even")
	} else {
		fmt.Println("odd")
	}

	if 8/4 == 2 {
		fmt.Println("8 divided by 4 is 2")
	}

	if num := 100 / 10; num == 0 {
		fmt.Println("shouldnt see this")
	} else if num == 10 {
		fmt.Println("Should see this")
	} else {
		fmt.Println("Error")
	}
}
