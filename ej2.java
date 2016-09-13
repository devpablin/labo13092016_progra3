package lab139;

import java.util.Scanner;





public class ej2 {
	public static class nodo{
		int dato;
		nodo sgte;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nodo cab=null;
		for(int i=0;i<10;i++){
			cab=addcola(cab);
		}
		int opcion;
		do{
			System.out.println("1. listado \n2.borrar primera mitad\n3.borrar segunda mitad \n"
					+ "4. Salir ");
			opcion=leer("su opcion");
			switch(opcion){
			case 1:
				listado(cab);
				break;
			case 2:
				cab=borrarmitad1(cab);
				break;
			case 3:
				borrarmitad2(cab);
				break;	
			}
		}while(opcion!=4);
		
			
		
	}
	public static nodo addcola (nodo x){
		nodo c;
		nodo nuevo=new nodo();
		nuevo.dato=(int) (Math.random()*(99)+1);
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
	public static nodo borrarmitad1(nodo cab){
		if(cab!=null){
			if(contar(cab)==2){
				cab=cab.sgte;
			}
			else if(contar(cab)>2){
				for(int i=0;i<=contar(cab)/2+1;i++){
					cab=cab.sgte;
				}
			}
		}
		return cab;
	}
	public static void borrarmitad2(nodo cab){
		if(cab!=null){
			if(contar(cab)==2){
				cab.sgte=null;
			}else if(contar(cab)>2){
				nodo c=cab;
				for(int i=1;i<contar(cab)/2;i++){
					c=c.sgte;
				}
				c.sgte=null;
			}
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

}
