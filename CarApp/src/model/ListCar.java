package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cars")
public class ListCar {
@Id
@GeneratedValue
@Column(name="ID")
	private int id;
@Column(name="MODEL")
	private String model;
@Column(name="BRAND")
	private String brand;
@Column(name="YEAR")
	private int year;
@Column(name="ENGINE")
	private String engine;


	public ListCar() {
		super();
	}
	public ListCar(String model, String brand, int year, String engine) {
		super();
		this.model = model;
		this.brand = brand;
		this.year = year;
		this.engine = engine;
	}
	public ListCar(String model, String brand) {
		super();
		this.model = model;
		this.brand = brand;
		
	}
	public int getId() {
		return id;

		}
	public void setId(int id) {
		this.id = id;
		}
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	public String getEngine() {
	return engine;
}
	public void setEngine(String engine) {
	this.engine = engine;
}
	
	public String returnCarDetails() {
		return this.brand + ", " + this.model + " with " + this.engine + " engine and " + this.year;
	}
	
}
