package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		// test sellerDAO.findById
		System.out.println(sellerDao.findById(2));
		System.out.println();

		// test sellerDao.findByDepartment
		Department dep = new Department(2, null);
		List<Seller> listDepartment = sellerDao.findByDepartment(dep);
		listDepartment.forEach(System.out::println);
		System.out.println();

		// test sellerDao.findAll
		List<Seller> listSellers = sellerDao.findAll();
		listSellers.forEach(System.out::println);
		System.out.println();

		// test sellerDao.insert
		Seller seller = new Seller(null, "Zeca", "zeca@gmail.com", new Date(), 2900.00, dep);
		sellerDao.insert(seller);
		System.out.println(seller.getId());

		// test sellerDao.update
		Seller sellerUpdate = sellerDao.findById(2);
		sellerUpdate.setName("João Carlos");
		sellerDao.update(sellerUpdate);

		// test sellerDao.delete
		sellerDao.deleteById(1);

		// test departmentDao.insert
		Department department = new Department(null, "Human resources");
		departmentDao.insert(department);
		System.out.println(department.getId());

		// test departmentDao.update and departmentDao.findById
		Department departmentUpdate = departmentDao.findById(2);
		departmentUpdate.setName("Accounting");
		departmentDao.update(departmentUpdate);

		// test departmentDao.findAll
		List<Department> listDepartments = departmentDao.findAll();
		listDepartments.forEach(System.out::println);
		System.out.println();

		// test departmentDao.delete
		departmentDao.deleteById(10);
	}
}
