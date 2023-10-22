package singleton;

public class LazyHolderSingleton {
	
	private static class InstanceHolder{
		public static LazyHolderSingleton instance = new LazyHolderSingleton();
	}
	
	private LazyHolderSingleton() {
		System.out.println("Uma instância LazyHolderSingleton foi criada");
	}
	
	public static LazyHolderSingleton getInstance() {
		return InstanceHolder.instance;
	}

}
