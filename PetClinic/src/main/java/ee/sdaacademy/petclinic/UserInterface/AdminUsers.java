package ee.sdaacademy.petclinic.UserInterface;

import ee.sdaacademy.petclinic.models.*;
import ee.sdaacademy.petclinic.repositories.AdminRepository;
import java.util.Scanner;

public class AdminUsers {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to Admin Repository!");
            System.out.println("Select 0 to exit ");
            System.out.println("Select 1 to add a new admin ");
            System.out.println("Select 2 to view all admins ");
            System.out.println("Select 3 to view admin by Id ");
            System.out.println("Select 4 to update admin ");
            System.out.println("Select 5 to delete admin ");
            System.out.println("Select 6 to delete admin by Id ");


            Admin admin = new Admin();
            int selectedOption = sc.nextInt();
            switch (selectedOption) {
                case 0:
                    System.out.println("Thank you and Good bye!");
                    return;
                case 1:
                    System.out.println("Enter admin first name: ");
                    String firstName = sc.next();
                    admin.setFirstName(firstName);
                    System.out.println("Enter admin last name: ");
                    String lastName = sc.next();
                    admin.setLastName(lastName);
                    System.out.println("Enter the phone number: ");
                    String telephoneNumber = sc.nextLine();
                    admin.setTelephoneNumber(telephoneNumber);
                    sc.nextLine(); //Read empty line
                    System.out.println("Enter the email address: ");
                    String email = sc.nextLine();
                    admin.setEmail(email);
                    AdminRepository.save(admin);
                    break;
                case 2:
                    AdminRepository.findAll().stream().forEach(admin1 -> {
                        System.out.println(admin1.getAdminId() + " " + admin1.getFirstName() + " " + admin1.getLastName()
                                + " " + admin1.getTelephoneNumber() + " " + admin1.getEmail());
                    });
                    break;
                case 3:
                    System.out.println("please enter the admin Id: ");
                    int adminId3 = sc.nextInt();
                    AdminRepository.findById(adminId3).getFirstName();
                    AdminRepository.findById(adminId3).getLastName();
                    System.out.println(AdminRepository.findById(adminId3).getFirstName() + " "
                            + AdminRepository.findById(adminId3).getLastName());
                    break;

                case 4:
                    //PetType petType5 = new PetType();
                    System.out.println("Enter the admin Id: ");
                    int adminId4 = sc.nextInt();
                    AdminRepository.findById(adminId4);
                    System.out.println(AdminRepository.findById(adminId4).getFirstName() +" "
                            + AdminRepository.findById(adminId4).getLastName());
                    Admin admin4 = AdminRepository.findById(adminId4);
                    sc.nextLine(); //Read empty line
                    System.out.println("Enter the first name: ");
                    String firstName5 = sc.nextLine();
                    admin4.setFirstName(firstName5);
                    System.out.println("Enter the last name: ");
                    String lastName5 = sc.nextLine();
                    admin4.setLastName(lastName5);
                    System.out.println("Enter the phone number: ");
                    String phoneNumber4 = sc.nextLine();
                    admin4.setTelephoneNumber(phoneNumber4);
                    System.out.println("Enter the email: ");
                    //sc.nextLine(); //Read empty line
                    String email4 = sc.nextLine();
                    admin4.setEmail(email4);
                    AdminRepository.update(admin4);
                    break;
                case 5:
                    AdminRepository.findAll().forEach(admin5 -> {
                        System.out.println(admin5.getAdminId() + " " + admin5.getFirstName()
                                + " " + admin5.getLastName());
                    });
                    System.out.print("Enter the Id of the admin to delete: ");
                    int adminId5 = sc.nextInt();
                    Admin admin5 = AdminRepository.findById(adminId5);
                    AdminRepository.delete(admin5);
                    break;
                case 6:
                    System.out.println("Enter the admin Id: ");
                    int adminId6 = sc.nextInt();
                    Admin admin6 = AdminRepository.findById(adminId6);
                    AdminRepository.deleteById(admin6);
                    break;
                default:
                    System.out.println("Invalid option.");
            }

    }
}
