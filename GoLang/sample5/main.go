package main

import (
	"fmt"
	"time"
)

func main() {
	a := 4
	fmt.Print("The the number ", a, " is written")
	switch a {
	case 1:
		fmt.Println(" as one")
	case 2:
		fmt.Println(" as two")
	case 3:
		fmt.Println(" as three")
	case 4:
		fmt.Println(" as four")
	}

	switch time.Now().Weekday() {
	case time.Saturday, time.Sunday:
		fmt.Println("Weekend")
	default:
		fmt.Println("Weekday")
	}

	t := time.Now()
	fmt.Println(t)
	switch {
	case t.Hour() < 12:
		fmt.Println("Morning")
	case t.Hour() > 12 && t.Hour() < 24:
		fmt.Println("Afternoon")
	default:
		fmt.Println("Midnight")
	}
}
