public class Nodo {
  protected Object dato;
  protected Nodo izquierdo;
  protected Nodo derecho;

  public Nodo(Object valor) {
    this.dato = valor;
    this.izquierdo = null;
    this.derecho = null;
  }

  public Nodo(Nodo izdo, Object valor, Nodo dcho) {
    this.dato=valor; 
    this.izquierdo=izdo; 
    this.derecho=dcho; 
    
  }
  public Nodo subarbolIzdo(){
    return izquierdo; 
  }
  public Nodo subarbolDcho(){
    return derecho;
  }
  public Object valorNodo(){
    return dato;
  }

  public void nuevoValor(Object a){
    dato=a;
  }
  
  public Object getDato() {
    return dato;
  }
  public void ramaIzdo(Nodo n){
    izquierdo=n;
  }

  public void ramaDcho(Nodo n){
    derecho=n;
  }
  public Nodo getIzquierdo() {
    return izquierdo;
  }

  public Nodo getDerecho() {
    return derecho;
  }

  public void setDato(Object dato) {
    this.dato = dato;
  }

  public void setIzquierdo(Nodo dato) {
    this.izquierdo = dato;
  }

  public void setDerecho(Nodo dato) {
    this.derecho = dato;
  }


  void visitar() {
    System.out.print(dato + " ");
  }
}
