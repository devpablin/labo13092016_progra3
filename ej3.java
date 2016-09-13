package lab139;

import java.util.Scanner;

import lab139.ej2.nodo;

public class ej3 {
	public static class nodo{
		int dato;
		nodo sgte;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nodo cab= null;
		int opcion;
		do{
			System.out.println("1. añadir nodo cabecera \n2.añadir cola\n3.listado \n"
					+ "4. borrar duplicados \n5. Salir");
			opcion=leer("su opcion");
			switch(opcion){
			case 1:
				cab=addcab(cab);
				break;
			case 2:
				cab=addcola(cab);
				break;
			case 3:
				listado(cab);
				break;	
			case 4:
				borrarduplis(cab);
				break;	
			}
		}while(opcion!=5);
		
			
	}
	public static int leer (String msg){
		Scanner lee = new Scanner(System.in);
		System.out.println(msg);
		return lee.nextInt();
	}
	public static void listado (nodo z){
		while(z!=null){
			System.out.println("Direccion: "+z+" Dato: "+z.dato+" Dir sgte: "+z.sgte);
			z=z.sgte;
		}
	}
	public static int contar (nodo z){
		int c=0;
		while(z!=null){
			c++;
			z=z.sgte;
		}
		return c;
	}
	public static nodo addcab (nodo x){
		nodo aux= new nodo();
		aux.sgte=x;
		aux.dato=leer("dato?");
		x=aux;
		return aux;
	}
	public static nodo addcola (nodo x){
		nodo c;
		nodo nuevo=new nodo();
		nuevo.dato=leer("dato?");
		nuevo.sgte=null;
		if (x==null) {
			x=nuevo;
		}else{
			c=x;
			while(c.sgte!=null){
				c=c.sgte;
			}
			c.sgte=nuevo;
		}
		return x;
	}
	public static void borrarduplis(nodo cab){
		if(cab!=null&&cab.sgte!=null){
			nodo a=cab,b,c;
			while(a!=null){
				b=a.sgte;
				c=a;
				
				while(b!=null){
					
					if(a.dato==b.dato){
						c.sgte=b.sgte;
						b=c;
					}
					c=b;
					b=b.sgte;
				}
				a=a.sgte;
				
			}
		}
	}

}
