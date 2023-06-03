import java.util.Comparator;

public class ArbolBinarioDeBusqueda extends ArbolBinario{
  public final Comparator comp; 

  public ArbolBinarioDeBusqueda() {
    super();
    comp=new ComparaEnteros();
    
  }

  public Nodo buscar(Object buscado) {
    if (raiz == null) {
      return null;
    } else {
      return localizar(getRaiz(), buscado);
    }
  }

  protected Nodo localizar(Nodo raizSub, Object buscado) {
    if (raizSub == null) {
      return null;
    } else if (comp.compare(buscado, raizSub.valorNodo()) < 0) {
      return localizar(raizSub.subarbolIzdo(), buscado);
    } else if (comp.compare(buscado, raizSub.valorNodo()) > 0) {
      return localizar(raizSub.subarbolDcho(), buscado);
    } else {
      System.out.println("el valor se encuentra en el arbol binario");
    }
    
    return raiz;
  }

  public void insertar(Object valor) throws Exception {
    raiz = insertar(raiz, valor);
  }

  protected Nodo insertar(Nodo raizSub, Object dato) throws Exception {
    if (raizSub == null) {
      raizSub = new Nodo(dato);
    } else if (comp.compare(dato, raizSub.valorNodo()) < 0) {
      Nodo iz;
      iz = insertar(raizSub.subarbolIzdo(), dato);
      raizSub.ramaIzdo(iz);
    } else if (comp.compare(dato, raizSub.valorNodo()) > 0) {
      Nodo dr;
      dr = insertar(raizSub.subarbolDcho(), dato);
      raizSub.ramaDcho(dr);
    } else
      throw new Exception("Nodo duplicado");
    return raizSub;
  }

  public void eliminar(Object valor) throws Exception {
    raiz = eliminar(raiz, valor);
  }

  
  protected Nodo eliminar (Nodo raizSub, Object dato) throws Exception
{
  if (raizSub == null) 
    throw new Exception ("No encontrado el nodo con la clave");
  else if (comp.compare(dato,raizSub.valorNodo())<0){
    Nodo iz;
    iz = eliminar(raizSub.subarbolIzdo(), dato);
    raizSub.ramaIzdo(iz);
  	}
  else if (comp.compare(dato,raizSub.valorNodo())>0){
    Nodo dr;
     dr = eliminar(raizSub.subarbolDcho(), dato);
    raizSub.ramaDcho(dr);
	 }
else 
	 {
  Nodo q;
  q = raizSub;
  if (q.subarbolIzdo() == null)
  raizSub = q.subarbolDcho();
  else if (q.subarbolDcho() == null)
  raizSub = q.subarbolIzdo();
  else { 
  q = reemplazar(q);
  }
  q = null;
   }
return raizSub;
}

 
  private Nodo reemplazar(Nodo act) {
    Nodo a, p;
    p = act;
    a = act.subarbolIzdo(); 
    while (a.subarbolDcho() != null) {
      p = a;
      a = a.subarbolDcho();
    }
    act.nuevoValor(a.valorNodo());
    if (p == act)
      p.ramaIzdo(a.subarbolIzdo());
    else
      p.ramaDcho(a.subarbolIzdo());
    return a;
  }
  
 
  private class ComparaEnteros implements Comparator {
	  public int compare(Object o1, Object o2) {
	    return ((Integer)o1).intValue() - ((Integer)o2).intValue();
    }}
}
