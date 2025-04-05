package dio.my_app;

import dio.my_app.domain.Vehicle;
import dio.my_app.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final VehicleRepository vehicleRepository;

    public DataLoader(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Adiciona veículos de exemplo ao banco de dados H2
        vehicleRepository.save(new Vehicle("Ford", "Mustang", 2021, "Red"));
        vehicleRepository.save(new Vehicle("Chevrolet", "Camaro", 2020, "Yellow"));
        vehicleRepository.save(new Vehicle("Tesla", "Model S", 2022, "Black"));
        vehicleRepository.save(new Vehicle("BMW", "M3", 2021, "Blue"));
        
        System.out.println("Dados de veículos iniciais carregados.");
    }
}
