package ee.sdaacademy.petclinic.UserInterface;


import ee.sdaacademy.petclinic.models.Vet;
import ee.sdaacademy.petclinic.repositories.AdminRepository;
import ee.sdaacademy.petclinic.repositories.VetRepository;

import java.util.Scanner;

public class VetUsers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Vet Repository!");
        System.out.println("Select 0 to exit ");
        System.out.println("Select 1 to add a new vet ");
        System.out.println("Select 2 to view all vet ");
        System.out.println("Select 3 to view vet by Id ");
        System.out.println("Select 4 to update vet ");
        System.out.println("Select 5 to delete vet ");
        System.out.println("Select 6 to delete vet by Id ");


        Vet vet1 = new Vet();
        int selectedOption = sc.nextInt();
        switch (selectedOption) {
            case 0:
                System.out.println("Thank you and Good bye!");
                return;
            case 1:
                System.out.println("Enter vet first name: ");
                String firstName = sc.next();
                vet1.setFirstName(firstName);
                System.out.println("Enter vet last name: ");
                String lastName = sc.next();
                vet1.setLastName(lastName);
                System.out.println("Enter the address: ");
                sc.nextLine(); //Read empty line
                String address1 = sc.nextLine();
                vet1.setAddress(address1);
                System.out.println("Enter the phone number: ");
                String telephoneNumber = sc.nextLine();
                sc.nextLine(); //Read empty line
                vet1.setTelephoneNumber(telephoneNumber);
                System.out.println("Enter the email address: ");
                String email = sc.nextLine();
                sc.nextLine(); //Read empty line
                vet1.setEmail(email);
                VetRepository.save(vet1);
                break;
            case 2:
                VetRepository.findAll().stream().forEach(vet2 -> {
                    System.out.println(vet2.getVetId() + " " + vet2.getFirstName() + " " + vet2.getLastName()
                            + " " + vet2.getTelephoneNumber() + " " + vet2.getEmail());
                });
                break;
            case 3:
                System.out.println("please enter the vet Id: ");
                int vetId3 = sc.nextInt();
                VetRepository.findById(vetId3).getFirstName();
                VetRepository.findById(vetId3).getLastName();
                System.out.println(VetRepository.findById(vetId3).getFirstName() + " "
                        + VetRepository.findById(vetId3).getLastName() + " " + VetRepository.findById(vetId3).getAddress()
                 + " " + VetRepository.findById(vetId3).getTelephoneNumber() + " " + VetRepository.findById(vetId3).getEmail());
                break;
            case 4:
                System.out.println("Enter the vet Id: ");
                int vetId4 = sc.nextInt();
                VetRepository.findById(vetId4);
                System.out.println(VetRepository.findById(vetId4).getFirstName() +" "
                        + VetRepository.findById(vetId4).getLastName());
                Vet vet4 = VetRepository.findById(vetId4);
                sc.nextLine(); //Read empty line
                System.out.println("Enter the first name: ");
                String firstName5 = sc.nextLine();
                vet4.setFirstName(firstName5);
                System.out.println("Enter the last name: ");
                String lastName5 = sc.nextLine();
                vet4.setLastName(lastName5);
                System.out.println("Enter the address: ");
                String address4 = sc.nextLine();
                sc.nextLine(); //Read empty line
                vet4.setAddress(address4);
                System.out.println("Enter the phone number: ");
                String phoneNumber4 = sc.nextLine();
                sc.nextLine(); //Read empty line
                vet4.setTelephoneNumber(phoneNumber4);
                System.out.println("Enter the email: ");
                String email4 = sc.nextLine();
                sc.nextLine(); //Read empty line
                vet4.setEmail(email4);
                VetRepository.update(vet4);
                break;
            case 5:
                VetRepository.findAll().forEach(vet5 -> {
                    System.out.println(vet5.getVetId() + " " + vet5.getFirstName()
                            + " " + vet5.getLastName());
                });
                System.out.print("Enter the Id of the vet to delete: ");
                int vetId5 = sc.nextInt();
                Vet vet5 = VetRepository.findById(vetId5);
                VetRepository.delete(vet5);
                break;
            case 6:
                System.out.println("Enter the vet Id: ");
                int vetId6 = sc.nextInt();
                Vet vet6 = VetRepository.findById(vetId6);
                VetRepository.deleteById(vet6);
                break;
            default:
                System.out.println("Invalid option.");
        }

    }
}
