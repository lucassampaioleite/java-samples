package singleton;

public class EagerSingleton {
	
	private static EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton(){
		System.out.println("Uma instância EagerSingleton foi criada");
	}
	
	public static EagerSingleton getInstance() {
		if (instance == null)
			instance = new EagerSingleton();
		return instance;
	}

}
