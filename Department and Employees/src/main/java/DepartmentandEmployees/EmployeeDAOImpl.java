package DepartmentandEmployees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Override
	public List<Employee> getEmployeeByDeptId(int deptId) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID FROM EMPLOYEE WHERE DEPTID = ?");
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while(rs.next()) {
			emps.add(mapRowToEmployee(rs));
		}
		conn.close();
//		System.out.println(emps.size());
		return emps;
	}
	
	@Override
	public void getListOfEmployeeinEachDepartment() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE DEPARTMENT D SET EMPLIST=(SELECT COUNT(*) FROM EMPLOYEE E WHERE E.DEPTID=D.DEPTID)");
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows update:"+rowsUpdated);
		con.close();
	}
	
	@Override
	public List<Employee> getEmployeeByDeptLocation(String name) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE DEPTID IN (SELECT DEPTID FROM DEPARTMENT WHERE DEPTLOC=?)");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		List<Employee> emps1=new ArrayList<>();
		while(rs.next()) {
			emps1.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		System.out.println(emps1.size());
		return emps1;
	}
	
	@Override
	public List<Employee> getEmployeeByDeptName(String name) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE DEPTID IN (SELECT DEPTID FROM DEPARTMENT WHERE DEPTNAME=?)");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		List<Employee> emps1=new ArrayList<>();
		while(rs.next()) {
			emps1.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		System.out.println(emps1.size());
		return emps1;
	}
	
	@Override
	public List<Employee> getEmployeeAgeBetween(int min, int max) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE AGE BETWEEN ? AND ?");
		ps.setInt(1, min);
		ps.setInt(2, max);
		ResultSet rs=ps.executeQuery();
		List<Employee> emps1=new ArrayList<>();
		while(rs.next()) {
			emps1.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		return emps1;
	}
	
	@Override
	public List<Employee> getEmployeeBySeniority(int limitVal) throws SQLException{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE ORDER BY SENIORITY DESC LIMIT ?");
		ps.setInt(1, limitVal);
		ResultSet rs=ps.executeQuery();
		List<Employee> emps1=new ArrayList<>();
		while(rs.next()) {
			emps1.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		return emps1;
	}
	
	@Override
	public List<Employee> getEmployeeSalaryLesser(int amount) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY<?");
		ps.setInt(1, amount);
		ResultSet rs=ps.executeQuery();
		List<Employee> emps1=new ArrayList<>();
		while(rs.next()) {
			emps1.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		return emps1;
	}
	
	@Override
	public List<Employee> getEmployeeSalaryGreater(int amount) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY>=?");
		ps.setInt(1, amount);
		ResultSet rs=ps.executeQuery();
		List<Employee> emps1=new ArrayList<>();
		while(rs.next()) {
			emps1.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		return emps1;
	}
	
	@Override
	public long countEmployee() throws SQLException {
		Connection con=getConnection();
		long answer = 0;
		PreparedStatement ps=con.prepareStatement("SELECT COUNT(ID) FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		if(rs.next()) 
			answer=rs.getLong(1);
		return answer;
	}
	
	//Create operation (C)
	@Override
	public void createEmployee(Employee emp) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID) VALUES(?,?,?,?,?,?)");
		populatePreparedStatmentFromEmployee(emp, ps);
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows update:"+rowsUpdated);
		con.close();
	}
	
	//Read Operation (R)
	@Override
	public List<Employee> getAllEmployees() throws SQLException{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		List<Employee> emps=new ArrayList<>();
		while(rs.next()) {
			emps.add(mapRowToEmployee(rs));
		}
		con.close();
		return emps;
	}
	
	//Update operation (U)
	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE EMPLOYEE SET NAME=?,AGE=?,EXPERIENCE=?,SENIORITY=?,SALARY=?,DEPTID=? WHERE ID=?");
		populatePreparedStatmentFromEmployee(emp, ps);
		ps.setInt(7, emp.getId());
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows update:"+rowsUpdated);
		con.close();
	}
	
	//Delete operation (D)
	@Override
	public void deleteEmployee(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows update:"+rowsUpdated);
		con.close();
}
	
	//Read operation
	@Override
	public Employee getEmployee(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			Employee e = mapRowToEmployee(rs);
			con.close();
			return e;
		}else {
			System.out.println("No row with Id "+id+" found.");
			return null;
		}
	}

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e=new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperience(rs.getInt(4));
		e.setSeniority(rs.getInt(5));
		e.setSalary(rs.getInt(6));
		e.setDeptId(rs.getInt(7));
		return e;
	}
	
	private Employee mapRowToEmployeeWithoutID(ResultSet rs) throws SQLException {
		Employee e=new Employee();
		e.setId(rs.getInt(6));
		e.setName(rs.getString(1));
		e.setAge(rs.getInt(2));
		e.setExperience(rs.getInt(3));
		e.setSeniority(rs.getInt(4));
		e.setSalary(rs.getInt(5));
		e.setDeptId(rs.getInt(7));
		return e;
	}
	
	private void populatePreparedStatmentFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3,emp.getExperience());
		ps.setInt(4, emp.getSeniority());
		ps.setInt(5, emp.getSalary());
		ps.setInt(6, emp.getDeptId());	
	}

	//Calling the jdbc driver as soon as the object is created
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Creating a connection statement which is reusable
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtechnew?useSSL=false&allowPublicKeyRetrieval=true","root","root");
	}
	
	public static void displayMenu() {
		System.out.println("----------------------------------------------");
		System.out.println("Menu :");
		System.out.println("1. Create Employee");
		System.out.println("2. Read/Get Employee");
		System.out.println("3. Get All Employees");
		System.out.println("4. Update Employee");
		System.out.println("5. Delete Employee");
		System.out.println("6. Count Total Number of Employees");
		System.out.println("7. Get Employees Salary Less Than");
		System.out.println("8. Get Employees Salary Greater Than");
		System.out.println("9. Get Employees By Seniority");
		System.out.println("10. Get Employees Age Between");
		System.out.println("11. Get Employees By Deptartment Name");
		System.out.println("12. Get Employees By Department Location");
		System.out.println("13. Exit the Program");
		System.out.println("----------------------------------------------");
	}
	
	public static void main(String[] args) throws SQLException {
		EmployeeDAO dao=new EmployeeDAOImpl();
		DepartmentDAO dao1=new DepartmentDAOImpl();
		
		Scanner scanner=new Scanner(System.in);
		int choice;
		do {
			displayMenu();
			choice=scanner.nextInt();
			System.out.println("Choice is : "+choice);
			switch(choice) {
				case 1:
					Scanner scan1=new Scanner(System.in);
					System.out.println("Enter Employee's Name : ");
					String name=scan1.nextLine();
					System.out.println("Enter Employee's Age : ");
					int age=scan1.nextInt();
					System.out.println("Enter Employee's Experience : ");
					int expe=scan1.nextInt();
					System.out.println("Enter Employee's Seniority : ");
					int senior=scan1.nextInt();
					System.out.println("Enter Employee's Salary : ");
					int salary=scan1.nextInt();
					System.out.println("Enter Employee's DepartmentId : ");
					int deptid=scan1.nextInt();
					dao.createEmployee(new Employee(name,age,expe,senior,salary,deptid));
					break;
				case 2:
					Scanner scan2=new Scanner(System.in);
					System.out.println("Enter Employee ID to Get the Details : ");
					int id=scan2.nextInt();
					System.out.println(dao.getEmployee(id));
					break;
				case 3:
					System.out.println(dao.getAllEmployees());
					break;
				case 4:
					System.out.println("Can be implemented using another switch case on what to update in a employee");
					break;
				case 5:
					Scanner scan3=new Scanner(System.in);
					System.out.println("Enter Employee ID to Delete the Details : ");
					int id1=scan3.nextInt();
					dao.deleteEmployee(id1);
					break;
				case 6:
					long count= dao.countEmployee();
					System.out.println("Total Employee Count is : "+count);
					break;
				case 7:
					Scanner scan4=new Scanner(System.in);
					System.out.println("Enter Salary to Get Employee's Salary Less Than it : ");
					int lSalary=scan4.nextInt();
					dao.getEmployeeSalaryLesser(lSalary);
					break;
				case 8:
					Scanner scan5=new Scanner(System.in);
					System.out.println("Enter Salary to Get Employee's Salary Greater Than it : ");
					int gSalary=scan5.nextInt();
					dao.getEmployeeSalaryGreater(gSalary);
					break;
				case 9:
					Scanner scan6=new Scanner(System.in);
					System.out.println("Enter Limit to retrieve Employee's on Their Seniority : ");
					int limit1=scan6.nextInt();
					System.out.println(dao.getEmployeeBySeniority(limit1));
					break;
				case 10:
					Scanner scan7=new Scanner(System.in);
					System.out.println("Enter Min and Max Age to Get Employee's: ");
					System.out.println("Enter Min Age : ");
					int min=scan7.nextInt();
					System.out.println("Enter Max Age : ");
					int max=scan7.nextInt();
					System.out.println(dao.getEmployeeAgeBetween(min, max));
					break;
				case 11:
					Scanner scan8=new Scanner(System.in);
					System.out.println("Enter Department Name to Retrieve Employee's who Work Under it : ");
					String deptName=scan8.next();
					System.out.println(dao.getEmployeeByDeptName(deptName));
					break;
				case 12:
					Scanner scan9=new Scanner(System.in);
					System.out.println("Enter Department Location to Retrieve Employee's who Work There : ");
					String deptLoc=scan9.next();
					System.out.println(dao.getEmployeeByDeptLocation(deptLoc));
					break;
				case 13:
					System.out.println("Exiting the program");
					break;
				default:
					System.out.println("Invalid choice. Please select a valid option (1-13).");
			}
		}
		while(choice!=13);
		scanner.close();
		
		System.out.println(dao.getEmployeeByDeptId(1));
		//Update employee
//		System.out.println("Update Employee commands");
//		EmployeeD e=dao.getEmployee(3);
//		e.setSeniority(11);
//		dao.updateEmployee(e);
//		e.setSalary(50000);
//		dao.updateEmployee(e);
		
		//List Of Employee's In Each Department
//		System.out.println("---------------------");
//		dao.getListOfEmployeeinEachDepartment();
//		dao1.getDepartments();
	}
}
