package lab139;

import java.util.Scanner;

public class ej1 {
	public static class nodo{
		int dato;
		nodo sgte;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nodo cab = null;
		for(int i=0;i<10;i++){
			cab=addcab(cab);
		}
		int opcion;
		do{
			System.out.println("1. listado \n2.borrar cabecera\n3.borrar cola \n"
					+ "4. borrar pos x\n5. Salir ");
			opcion=leer("su opcion");
			switch(opcion){
			case 1:
				listado(cab);
				break;
			case 2:
				cab=borrarcab(cab);
				break;
			case 3:
				borrarcola(cab);
				break;
			case 4:
				cab=borrarposx(cab,leer("posicion?"));
				break;
			
				
			}
		}while(opcion!=5);
		
			
	}
	public static nodo addcab (nodo x){
		nodo aux= new nodo();
		aux.sgte=x;
		aux.dato=(int) (Math.random()*(99)+1);
		x=aux;
		return aux;
	}

	public static nodo borrarcab(nodo x){
		if(x!=null){
			x=x.sgte;
		}
		return x;
	}
	public static void borrarcola(nodo x){
		if(contar(x)>=2){
			nodo z=x,y=x;
			while(y.sgte!=null){
				z=y;
				y=y.sgte;
			}
			z.sgte=null;
		}
		else{
			System.out.println("No se puede");
		}
	}
	public static nodo borrarposx (nodo cab,int x){
		if(cab!=null){
			if(x==0){
				cab=borrarcab(cab);
			}else if(contar(cab)-1==x){
				borrarcola(cab);
			}else if(x<contar(cab)-1){
				nodo c=cab;
				for(int i=1;i<x;i++){
					c=c.sgte;
				}
				c.sgte=c.sgte.sgte;
			}
			else{
				System.out.println("no existe la posicion en la lista");
			}
		}
		else{
			System.out.println("no existe lista");
		}
		return cab;
	}
	public static void listado (nodo z){
		while(z!=null){
			System.out.println("Direccion: "+z+" Dato: "+z.dato+" Dir sgte: "+z.sgte);
			z=z.sgte;
		}
	}
	public static int leer (String msg){
		Scanner lee = new Scanner(System.in);
		System.out.println(msg);
		return lee.nextInt();
	}
	public static int contar (nodo z){
		int c=0;
		while(z!=null){
			c++;
			z=z.sgte;
		}
		return c;
	}
}
