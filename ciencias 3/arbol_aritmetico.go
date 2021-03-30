package main

import (
	"bufio"
	"fmt"
  "strconv"
	"os"
	"strings"
)


// arbol binario
type Arbol struct {
	Izquierda  *Arbol
	Valor string
	Derecha *Arbol
}
// pila de arboles
type Pila struct {
	arboles []*Arbol
	contador int
}
// crea una nueva pila
func NewPila() *Pila {
	return &Pila{}
}
// agrega un elemento a una pila
func (s *Pila) Push(a *Arbol) {
	s.arboles = append(s.arboles[:s.contador], a)
	s.contador++
}
// extrae un elemento de la pila
func (s *Pila) Pop() *Arbol {
	if s.contador == 0 {
		return nil
	}
	s.contador--
	return s.arboles[s.contador]
}
// muestra el contenido del arbol
func Mostrar(t *Arbol) {
	if t == nil {
		return
	}
	Mostrar(t.Izquierda)
	fmt.Print(t.Valor)
	Mostrar(t.Derecha)
}
//evalua un arbol
func Evaluar(t *Arbol) int {
  if(t.Valor == "+"){
	  return (Evaluar(t.Izquierda) + Evaluar(t.Derecha))
  } else if(t.Valor == "-"){
 	  return (Evaluar(t.Izquierda) - Evaluar(t.Derecha))
  } else if(t.Valor == "*"){
 	  return (Evaluar(t.Izquierda) * Evaluar(t.Derecha))
  } else if(t.Valor == "/"){
 	  return (Evaluar(t.Izquierda) / Evaluar(t.Derecha))
  } else {
    i, _ := strconv.Atoi(t.Valor)
    return i
  }
}
//construlle el arbol desde la notacion posfija
func Construir(s []string) *Arbol{
	p := NewPila()
	var t1 *Arbol
	var t2 *Arbol
	var t *Arbol

	for i := range s {

		if (s[i] != "+") && (s[i] != "-") && (s[i] != "/") && (s[i] != "*"){
			p.Push(&Arbol{nil, s[i], nil})
		}else {
			if p.contador < 2 {
				fmt.Println("Error de expresión")
				return nil
			} else {
				t2 = p.Pop()
				t1 = p.Pop()
				t = &Arbol{t1, s[i], t2}//insertar(t, s[i])
				p.Push(t)
			}
		}
	}
	return t
}

func main(){
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	op := scanner.Text()
	lista := strings.Split(op, " ")
  t1 := Construir(lista)
	if t1 != nil{
		Mostrar(t1)
	  fmt.Print(" = ")
	  fmt.Println(Evaluar(t1))
	}


}
