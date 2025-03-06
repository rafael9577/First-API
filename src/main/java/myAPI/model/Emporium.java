package myAPI.model;

import java.util.List;

import jakarta.persistence.*;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

@Entity(name = "tb_estabelecimentos")
public class Emporium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "emporium", fetch = EAGER)
	private List<Employee> employee;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "emporium", fetch = EAGER)
	private List<Product> product;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	

}
