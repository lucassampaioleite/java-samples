package application;

import singleton.EagerSingleton;
import singleton.LazyHolderSingleton;
import singleton.LazySingleton;

public class Application {
	
	public static void main(String[] args) {
		
		
		System.out.println("Testando LazySinpleton...");
		LazySingleton lazy = LazySingleton.getInstance(); 
		System.out.println("Referência do objeto: "+ lazy);
		lazy = LazySingleton.getInstance();
		System.out.println("Referência do objeto: "+ lazy);
		System.out.println();
		
		System.out.println("Testando EagerSinpleton...");
		EagerSingleton eager = EagerSingleton.getInstance(); 
		System.out.println("Referência do objeto: "+ eager);
		eager = EagerSingleton.getInstance();
		System.out.println("Referência do objeto: "+ eager);
		System.out.println();
				
		System.out.println("Testando LazyHolderSinpleton...");
		LazyHolderSingleton lazyHolder = LazyHolderSingleton.getInstance(); 
		System.out.println("Referência do objeto: "+ lazyHolder);
		lazyHolder = LazyHolderSingleton.getInstance();
		System.out.println("Referência do objeto: "+ lazyHolder);
	}
	
	

}
