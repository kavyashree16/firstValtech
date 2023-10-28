package DepartmentandEmployees;

public class Department {
	private int deptId;
	private String deptName;
	private String deptLoc;
	private int empList;
	
	public Department() {}

	public Department(int deptId, String deptName, String deptLoc) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public Department(int deptId, String deptName, String deptLoc, int empList) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "DepartmentD [deptId=" + deptId + ", deptName=" + deptName + ", deptLoc=" + deptLoc + ", empList="
				+ empList + "]";
	}

	//Constructor without deptId
	public Department(String deptName, String deptLoc, int empList) {
		super();
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.empList = empList;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	public int getEmpList() {
		return empList;
	}

	public void setEmpList(int empList) {
		this.empList = empList;
	}
	
	
	
	
}
