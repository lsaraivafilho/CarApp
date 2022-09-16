import java.util.Scanner;
import java.util.List;
import java.util.Scanner;
import controller.CarHelper;
import model.ListCar;


public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static CarHelper ch = new CarHelper();
	private static void addAModel() {
		// TODO Auto-generated method stub
		
		System.out.print("Enter a brand: ");
		String brand = in.nextLine();
		System.out.print("Enter an Car: ");
		String model = in.nextLine();
		System.out.print("Enter a engine: ");
		String engine = in.nextLine();
		System.out.print("Enter a year: ");
		int year = in.nextInt();
		
		ListCar toAdd = new ListCar(brand, model, year, engine);
		ch.insertCar(toAdd);
		System.out.print("Brand " + brand + " " + model +  " " + year + " "+ engine+  " inserted");
	}

	private static void deleteAModel() {		
		System.out.print("Enter the brand to delete: ");
		String brand = in.nextLine();
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();		
		ListCar	toDelete	=	new ListCar(brand, model);
		ch.deleteCar(toDelete);
		System.out.print("Option Deleted.");

	}

	private static void editAModel() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Model");
		System.out.println("2 : Search by Brand");
		int searchBy = in.nextInt();
		in.nextLine();
	
		List<ListCar> foundCars;
		if (searchBy == 1) {
			System.out.print("Enter	the	Model:	");
			String	brand	=	in.nextLine();
			foundCars	=	ch.searchForCarByBrand(brand);
		} else if(searchBy == 2){
			System.out.print("Enter	the	Brand: ");
			String	model	=	in.nextLine();
			foundCars	=	ch.searchForCarByModel(model);
			}else {
				System.out.print("This isn't an Option\n");
				return;
			}


		if (!foundCars.isEmpty()) {
			System.out.println("Found Results.");
			for (ListCar l : foundCars) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ListCar toEdit = ch.searchForCarById(idToEdit);
			System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getBrand());
			System.out.println("1 : Update Model");
			System.out.println("2 : Update Brand");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Model: ");
				String newBrand = in.nextLine();
				toEdit.setBrand(newBrand);
			} else if (update == 2) {
				System.out.print("New Brand: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			}

			ch.updateCar(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our List Car! ---");
		while (goAgain) {
			System.out.println("*  Select an Option:");
			System.out.println("*  1 -- Add a Car");
			System.out.println("*  2 -- Edit a Car");
			System.out.println("*  3 -- Delete a Car");
			System.out.println("*  4 -- View All Cars");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAModel();
			} else if (selection == 2) {
				editAModel();
			} else if (selection == 3) {
				deleteAModel();
			} else if (selection == 4) {
				viewTheList();
			} else {
				ch.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<ListCar>	allCars	=	ch.showAllCars();			
		for(ListCar singleCar :	allCars){
		System.out.println(singleCar.returnCarDetails());
		}
	}
	
}