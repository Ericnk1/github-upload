package ee.sdaacademy.petclinic;

import ee.sdaacademy.petclinic.models.Admin;
import ee.sdaacademy.petclinic.models.PetType;
import ee.sdaacademy.petclinic.repositories.*;

public class Application {
    public static void main(String[] args) {

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



    }
}
