package com.javapractice.javainterview;

class Employee {
	private Integer id;
    private String name;
    private String departmentName;
    private double salary;

    public Employee(Integer id, String name, String departmentName, double salary) {
    	this.id = id;
        this.name = name;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() { return name; }
    public String getDepartmentName() { return departmentName; }
    public double getSalary() { return salary; }

    

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", departmentName=" + departmentName + ", salary=" + salary
				+ "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}