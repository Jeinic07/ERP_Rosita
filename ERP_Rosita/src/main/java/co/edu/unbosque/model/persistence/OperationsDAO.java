package co.edu.unbosque.model.persistence;

public interface OperationsDAO {
	
	public void create(Object o);

	public int create(String... args);

	public String readAll();

	public String readByName(String name);

	public int updateById(int id, String... args);

	public int deleteById(int id);
}
