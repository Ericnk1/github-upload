package ee.sdaacademy.petclinic;

import ee.sdaacademy.petclinic.models.*;
import ee.sdaacademy.petclinic.repositories.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {
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

       while(true) {
            System.out.println("Welcome to PetRepository!");
            System.out.println("Select 0 to exit ");
            System.out.println("Select 1 to add or register a pet ");
            System.out.println("Select 2 to view all pet ");
            System.out.println("Select 3 to view pet by Id ");
            System.out.println("Select 4 to view all alphabetically ");
            System.out.println("Select 5 to update pet ");
            System.out.println("Select 6 to delete pet ");
            System.out.println("Select 7 to delete pet by Id ");


            Pet pet = new Pet();
            int selectedOption = sc.nextInt();
            switch (selectedOption) {
                case 0:
                    System.out.println("Thank you and Good bye!");
                    return;
                case 1:
                    System.out.println("Enter pet name: ");
                    String Name = sc.next();
                    pet.setName(Name);
                    System.out.println("Enter date of birth as 'yyyy-mm-dd': ");
                    String date = sc.nextLine();
                    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
                    Date dateOfBirth = format.parse(date);
                    //Date dateOfBirth = Date.from(Instant.parse(sc.next()));
                    pet.setDateOfBirth(dateOfBirth);
                    System.out.println("Enter petTypeId: ");
                    int petTypeId = sc.nextInt();
                    pet.setPetId(petTypeId);
                System.out.println("Enter owner Id: ");
                //sc.nextLine(); //Read empty line
                    int ownerId = sc.nextInt();
                    Owner owner = new Owner();
                    owner.setOwnerId(ownerId);
                    pet.setOwner(owner);
                    System.out.println("Enter 1 if the pet is vaccinated and 0 if not: ");
                    int isVaccinated = sc.nextInt();
                    pet.setIsVaccinated(isVaccinated);
                    System.out.println("Enter the vet Id: ");
                    int vetId = sc.nextInt();
                    Vet vet = new Vet();
                    vet.setVetId(vetId);
                    pet.setVet(vet);
                    System.out.println("Enter the consultant Id: ");
                    int consultantId = sc.nextInt();
                    Consultant consultant = new Consultant();
                    consultant.setConsultantId(consultantId);
                    pet.setConsultant(consultant);
                    PetRepository.save(pet);
                    break;
                case 2:
                    PetRepository.findAll().stream().forEach(pet2 -> {
                        System.out.println(pet2.getName() + " " + pet2.getDateOfBirth() + " " + pet2.getPetType().getPetTypeId()
                                + " " + pet2.getOwner().getOwnerId() + " " + pet2.getIsVaccinated() + " " + pet2.getVet().getVetId() + " " +
                                pet2.getConsultant().getConsultantId());
                    });
                    break;
                case 3:
                    System.out.println("please enter the petId ");
                    int petId = sc.nextInt();
                    PetRepository.findById(petId).getName();
                    System.out.println(PetRepository.findById(petId).getName());
                    break;
                case 4:
                    PetRepository.findAllAlphabetically().stream().forEach(pet4 -> {
                        System.out.println(pet4.getName() + " " + pet4.getDateOfBirth() + " " + pet4.getPetType().getPetTypeId()
                                + " " + pet4.getOwner().getOwnerId() + " " + pet4.getIsVaccinated()  + " " + pet4.getVet().getVetId()
                                        + " " + pet4.getConsultant().getConsultantId());
                    });
                    break;
                case 5:
                    //PetType petType5 = new PetType();
                    System.out.println("Enter the pet Id: ");
                    int petId5 = sc.nextInt();
                    PetRepository.findById(petId5);
                    System.out.println(PetRepository.findById(petId5).getName());
                    Pet pet5 = PetRepository.findById(petId5);
                    System.out.println("Enter the name: ");
                    String name5 = sc.nextLine();
                    pet5.setName(name5);
                    System.out.println("Enter date of birth as 'yyyy-mm-dd': ");
                    Date dateOfBirth5 = Date.from(Instant.parse(sc.next()));
                    pet.setDateOfBirth(dateOfBirth5);
                    System.out.println("Enter petTypeId: ");
                    int petTypeId5 = sc.nextInt();
                    pet.setPetId(petTypeId5);
                    System.out.println("Enter owner Id: ");
                    //sc.nextLine(); //Read empty line
                    int ownerId5 = sc.nextInt();
                    Owner owner5 = new Owner();
                    owner5.setOwnerId(ownerId5);
                    pet.setOwner(owner5);
                    System.out.println("Enter 1 if the pet is vaccinated and 0 if not: ");
                    int isVaccinated5 = sc.nextInt();
                    pet.setIsVaccinated(isVaccinated5);
                    System.out.println("Enter the vet Id: ");
                    int vetId5 = sc.nextInt();
                    Vet vet5 = new Vet();
                    vet5.setVetId(vetId5);
                    pet.setVet(vet5);
                    System.out.println("Enter the consultant Id: ");
                    int consultantId5 = sc.nextInt();
                    Consultant consultant5 = new Consultant();
                    consultant5.setConsultantId(consultantId5);
                    pet.setConsultant(consultant5);
                    PetRepository.save(pet);
                    break;
                case 6:
                    PetRepository.findAllAlphabetically().forEach(pet6 -> {
                        System.out.println(pet6.getName());
                    });
                    System.out.print("select the pet name: ");
                    String name6 = sc.next();
                    pet.setName(name6);
                    PetRepository.delete(pet);

                    break;
                case 7:
                    System.out.println("Enter the pet Id: ");
                    int petId7 = sc.nextInt();
                    Pet pet7 = PetRepository.findById(petId7);
                    PetRepository.deleteById(pet7);
                default:
                    System.out.println("Invalid option.");
            }
        }


            // THIS PART IS FOR petType USER INPUT NOT TESTED

            /*System.out.println("Welcome to PetTypeRepository!");
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
                    int petId = sc.nextInt();
                    PetRepository.findById(petId).getName();
                    System.out.println(petId);
                    break;
                case 4:
                    PetRepository.findAllAlphabetically().forEach(pet6 -> {
                        System.out.println(pet6.getName());
                    });
                    System.out.print("select the pet name: ");
                    String name6 = sc.next();
                    petType.setName(name6);
                    PetTypeRepository.delete(petType);

                    break;
                case 5:
                    System.out.println("Enter the petType Id: ");
                    int petTypeId7 = sc.nextInt();
                    PetType petType7 = PetTypeRepository.findById(petTypeId7);
                    PetTypeRepository.deleteById(petType7);
                default:
                    System.out.println("Invalid option.");
            }*/



    }
}
