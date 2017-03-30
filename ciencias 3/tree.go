package main

import (
	"fmt"
	"math/rand"
)

// arbol binario con valores enteros.
type Tree struct {
	Left  *Tree
	Value int
	Right *Tree
}

func New(n, k int) *Tree {
	var t *Tree
	for _, v := range rand.Perm(n) {
		t = insert(t, (1+v)*k)
	}
	return t
}

func insert(t *Tree, v int) *Tree {
	if t == nil {
		return &Tree{nil, v, nil}
	}
	if v < t.Value {
		t.Left = insert(t.Left, v)
		return t
	}
	t.Right = insert(t.Right, v)
	return t
}

func Walk(t *Tree, ch chan int) {
	if t == nil {
		return
	}
	Walk(t.Left, ch)
	ch <- t.Value
	Walk(t.Right, ch)
}

func Walker(t *Tree) <-chan int {
	ch := make(chan int)
	go func() {
		Walk(t, ch)
		close(ch)
	}()
	return ch
}

func Compare(t1, t2 *Tree) bool {
	c1, c2 := Walker(t1), Walker(t2)
	for {
		v1, ok1 := <-c1
		v2, ok2 := <-c2
		if !ok1 || !ok2 {
			return ok1 == ok2
		}
		if v1 != v2 {
			break
		}
	}
	return false
}

func main() {
	t1 := New(100, 1)
	fmt.Println(Compare(t1, New(100, 1)), "Same Contents")
	fmt.Println(Compare(t1, New(99, 1)), "Differing Sizes")
	fmt.Println(Compare(t1, New(100, 2)), "Differing Values")
	fmt.Println(Compare(t1, New(101, 2)), "Dissimilar")
}
