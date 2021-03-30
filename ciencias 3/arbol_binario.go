package main

import (
	"fmt"
	"math/rand"
)
// arbol binario con valores enteros.
type Arbol struct {
	Izquierda  *Arbol
	Valor int
	Derecha *Arbol
}

func New(n, k int) *Arbol {
	var t *Arbol
	for _, v := range rand.Perm(n) {
		t = insertar(t, (1+v)*k)
	}
	return t
}

func insertar(t *Arbol, v int) *Arbol {
	if t == nil {
		return &Arbol{nil, v, nil}
	}
	if v < t.Valor {
		t.Izquierda = insertar(t.Izquierda, v)
		return t
	}
	t.Derecha = insertar(t.Derecha, v)
	return t
}

func RecorrerInorden(t *Arbol) {
	if t == nil {
		return
	}
	RecorrerInorden(t.Izquierda)
	fmt.Print(t.Valor)
  fmt.Print(" - ")
	RecorrerInorden(t.Derecha)
}

func RecorrerPreorden(t *Arbol) {
	if t == nil {
		return
	}
  fmt.Print(t.Valor)
  fmt.Print(" - ")
	RecorrerPreorden(t.Izquierda)
	RecorrerPreorden(t.Derecha)
}

func RecorrerPosorden(t *Arbol) {
	if t == nil {
		return
	}
	RecorrerPosorden(t.Izquierda)
	RecorrerPosorden(t.Derecha)
  fmt.Print(t.Valor)
  fmt.Print(" - ")
}

func main() {
	t1 := New(10, 3)
  fmt.Println("\nInorden:")
  RecorrerInorden(t1)
  fmt.Println("\nPreorden:")
  RecorrerPreorden(t1)
  fmt.Println("\nPosorden:")
  RecorrerPosorden(t1)
  fmt.Println("")
}
