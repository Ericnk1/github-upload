package ee.sdaacademy.petclinic.UserInterface;

import ee.sdaacademy.petclinic.models.Owner;

import ee.sdaacademy.petclinic.repositories.OwnerRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OwnerUsers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to owner Repository!");
        System.out.println("Select 0 to exit ");
        System.out.println("Select 1 to add a new owner ");
        System.out.println("Select 2 to view all owners ");
        System.out.println("Select 3 to view owner by Id ");
        System.out.println("Select 4 to update owner ");
        System.out.println("Select 5 to delete owner ");
        System.out.println("Select 6 to delete owner by Id ");


        Owner owner1 = new Owner();
        int selectedOption = sc.nextInt();
        switch (selectedOption) {
            case 0:
                System.out.println("Thank you and Good bye!");
                return;
            case 1:
                System.out.println("Enter owner first name: ");
                String firstName1 = sc.next();
                owner1.setFirstName(firstName1);
                System.out.println("Enter owner last name: ");
                String lastName1 = sc.next();
                owner1.setLastName(lastName1);
                System.out.println("Enter date of birth as yyyy-MM-dd:");
                String date = sc.next();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dateOfBirth1=null;
                try {
                    //Parsing the String
                    dateOfBirth1 = dateFormat.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                owner1.setDateOfBirth(dateOfBirth1);
                System.out.println("Enter the address: ");
                sc.nextLine(); //Read empty line
                String address1 = sc.nextLine();
                owner1.setAddress(address1);
                System.out.println("Enter the phone number: ");
                String telephoneNumber = sc.nextLine();
                sc.nextLine(); //Read empty line
                owner1.setTelephoneNumber(telephoneNumber);
                System.out.println("Enter the email address: ");
                String email = sc.nextLine();
                sc.nextLine(); //Read empty line
                owner1.setEmail(email);
                OwnerRepository.save(owner1);
                break;
            case 2:
                OwnerRepository.findAll().stream().forEach(owner2 -> {
                    System.out.println(owner2.getOwnerId() + " " + owner2.getFirstName() + " " + owner2.getLastName()
                            + " " + owner2.getTelephoneNumber() + " " + owner2.getEmail());
                });
                break;
            case 3:
                System.out.println("please enter the owner Id: ");
                int ownerId3 = sc.nextInt();
                OwnerRepository.findById(ownerId3).getFirstName();
                OwnerRepository.findById(ownerId3).getLastName();
                System.out.println(OwnerRepository.findById(ownerId3).getFirstName() + " "
                        + OwnerRepository.findById(ownerId3).getLastName() + " " + OwnerRepository.findById(ownerId3).getAddress()
                        + " " + OwnerRepository.findById(ownerId3).getTelephoneNumber() + " " + OwnerRepository.findById(ownerId3).getEmail());
                break;
            case 4:
                System.out.println("Enter the owner Id: ");
                int ownerId4 = sc.nextInt();
                OwnerRepository.findById(ownerId4);
                System.out.println(OwnerRepository.findById(ownerId4).getFirstName() +" "
                        + OwnerRepository.findById(ownerId4).getLastName());
                Owner owner4 = OwnerRepository.findById(ownerId4);
                sc.nextLine(); //Read empty line
                System.out.println("Enter the first name: ");
                String firstName5 = sc.nextLine();
                owner4.setFirstName(firstName5);
                System.out.println("Enter the last name: ");
                String lastName5 = sc.nextLine();
                owner4.setLastName(lastName5);
                System.out.println("Enter date of birth as yyyy-MM-dd:");
                String date4 = sc.next();
                DateFormat dateFormat4 = new SimpleDateFormat("yyyy-MM-dd");
                Date dateOfBirth4=null;
                try {
                    //Parsing the String
                    dateOfBirth4 = dateFormat4.parse(date4);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                owner4.setDateOfBirth(dateOfBirth4);
                System.out.println("Enter the address: ");
                String address4 = sc.nextLine();
                sc.nextLine(); //Read empty line
                owner4.setAddress(address4);
                System.out.println("Enter the phone number: ");
                String phoneNumber4 = sc.nextLine();
                sc.nextLine(); //Read empty line
                owner4.setTelephoneNumber(phoneNumber4);
                System.out.println("Enter the email: ");
                String email4 = sc.nextLine();
                sc.nextLine(); //Read empty line
                owner4.setEmail(email4);
                OwnerRepository.update(owner4);
                break;
            case 5:
                OwnerRepository.findAll().forEach(owner5 -> {
                    System.out.println(owner5.getOwnerId() + " " + owner5.getFirstName()
                            + " " + owner5.getLastName());
                });
                System.out.print("Enter the Id of an owner to delete: ");
                int ownerId5 = sc.nextInt();
                Owner owner5 = OwnerRepository.findById(ownerId5);
                OwnerRepository.delete(owner5);
                break;
            case 6:
                System.out.println("Enter an owner Id: ");
                int ownerId6 = sc.nextInt();
                Owner owner6 = OwnerRepository.findById(ownerId6);
                OwnerRepository.deleteById(owner6);
                break;
            default:
                System.out.println("Invalid option.");
        }

    }
}
