public class Instrumentos{
    public static void main(String[] args){
        Instrumento i;

        int opc = 2;

        switch(opc){
            case 0:
                i = new Guitarra();
                break;
            case 1:
                i = new Guitarra();
                break;
            default:
                i = new Arpa();
                break;
        }

        i.afinar();

    }

}

interface Instrumento{
    void afinar();
}

class Guitarra implements Instrumento{
    public void afinar(){
        System.out.println("afinando guitarra");
    }
}


class Arpa implements Instrumento{
    public void afinar(){
        System.out.println("afinando arpa");
    }
}

class Flauta implements Instrumento{
    public void afinar(){
        System.out.println("afinando arpa");
    }
}