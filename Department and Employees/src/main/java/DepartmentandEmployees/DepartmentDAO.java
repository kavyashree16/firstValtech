package DepartmentandEmployees;
import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {

	int firstDept() throws SQLException;

	int lastDept() throws SQLException;

	int nextDept(int deptId) throws SQLException;

	int previousDept(int deptId) throws SQLException;
	
	void createDepartment(Department dept) throws SQLException;

	List<Department> getDepartments() throws SQLException;

	void updateDepartment(Department dept) throws SQLException;

	void deleteDepartment(int id) throws SQLException;

	Department getDepartment(int id) throws SQLException;

}