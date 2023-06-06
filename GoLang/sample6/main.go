package main

import "fmt"

func main() {
	//array sizes are not mutable but the array is
	//Same ass all other array handling
	a := [4]int{1, 2, 3, 4}
	b := [100]string{}
	c := []int{}
	d := []int{0}

	fmt.Println(a)
	fmt.Println(len(b))
	fmt.Println(c)
	fmt.Println(d, " with a length of ", len(d))

	a[2] = 78
	b[3] = "test"
	d[0] = 1789

	fmt.Println(a)
	fmt.Println(len(b))
	fmt.Println(c)
	fmt.Println(d, " with a length of ", len(d))
}
