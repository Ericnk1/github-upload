package ee.sdaacademy.petclinic;

import ee.sdaacademy.petclinic.models.*;
import ee.sdaacademy.petclinic.repositories.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*PetTypeRepository petTypeRepository = new PetTypeRepository();
        petTypeRepository.findAll().stream().forEach(petTypes -> {
            System.out.println(petTypes.getPetTypeId() + " " + petTypes.getName());
        });*/
        //AdminRepository adminRepository = new AdminRepository();
        //System.out.println(adminRepository.findById(2).getFirstName());


        //Admin admin = new Admin();
        /*admin.setFirstName("Eric");
        admin.setLastName("Bass");
        admin.setTelephoneNumber("890-678-909");
        admin.setEmail("eric@bass.com");
        adminRepository.save(admin);*/

        /*Admin admin1 = adminRepository.findById(3);
        admin1.setLastName("Jack");
        adminRepository.delete(admin1);*/


        //VetRepository vetRepository = new VetRepository();
        /*vetRepository.findAll().stream().forEach(vet -> {
            System.out.println(vet.getFirstName() + " " + vet.getLastName() + " " + vet.getTelephoneNumber()
             + " " + vet.getAddress() + " " + vet.getEmail());
        });*/

        //System.out.println(vetRepository.findById(2).getFirstName());

        /*AppointmentRepository appointmentRepository = new AppointmentRepository();
        appointmentRepository.findAll().stream().forEach(appointment -> {
            System.out.println(appointment.getConsultant().getName());
        });*/

        /*OwnerRepository ownerRepository = new OwnerRepository();
        ownerRepository.findAll().stream().forEach(owner -> {
            System.out.println(owner.getFirstName() + " " + owner.getLastName() + " " + owner.getAddress());});*/


        /*ownerRepository.findAllAlphabetically().stream().forEach(owner1 -> {
            System.out.println(owner1.getFirstName() + " " + owner1.getLastName());
        });*/




            // THIS PART IS FOR petType USER INPUT

            System.out.println("Welcome to PetTypeRepository!");
            System.out.println("Select 0 to exit ");
            System.out.println("Select 1 to add a petType ");
            System.out.println("Select 2 to view all petType ");
            System.out.println("Select 3 to update petType ");
            System.out.println("Select 4 to delete petType ");
            System.out.println("Select 5 to delete petType by Id ");


            PetType petType = new PetType();
            int selectedOption = sc.nextInt();
            switch (selectedOption) {
                case 0:
                    System.out.println("Thank you and Good bye!");
                    return;
                case 1:
                    System.out.println("Enter petType name: ");
                    String Name = sc.next();
                    petType.setName(Name);
                    PetTypeRepository.save(petType);
                    break;
                case 2:
                    PetTypeRepository.findAll().stream().forEach(pet2 -> {
                        System.out.println(pet2.getPetTypeId() + " " + pet2.getName());
                    });
                    break;
                case 3:
                    System.out.println("please enter the petId ");
                    int petTypeId3 = sc.nextInt();
                    PetTypeRepository.findById(petTypeId3).getName();
                    System.out.println(PetTypeRepository.findById(petTypeId3).getName());
                    System.out.printf("Enter the new type name: ");
                    sc.nextLine(); //Read empty line
                    String petTypeName3 = sc.nextLine();
                    PetType petType3 = PetTypeRepository.findById(petTypeId3);
                    petType3.setName(petTypeName3);
                    PetTypeRepository.update(petType3);
                    break;
                case 4:
                    PetTypeRepository.findAll().forEach(petType4 -> {
                        System.out.println(petType4.getPetTypeId() + " " + petType4.getName());
                    });
                    System.out.println("Enter the Id petType to delete: ");
                    int petTypeId4 = sc.nextInt();
                    PetType petType4 = PetTypeRepository.findById(petTypeId4);
                    PetTypeRepository.deleteById(petType4);
                    break;
                case 5:
                    System.out.println("Enter the Id petType to delete: ");
                    int petTypeId5 = sc.nextInt();
                    PetType petType5 = PetTypeRepository.findById(petTypeId5);
                    PetTypeRepository.deleteById(petType5);
                    break;
                default:
                    System.out.println("Invalid option.");
            }



    }
}
