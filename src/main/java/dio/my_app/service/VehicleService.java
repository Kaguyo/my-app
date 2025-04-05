package dio.my_app.service;

import dio.my_app.domain.Vehicle;
import dio.my_app.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Listar todos os veículos
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Adicionar um veículo
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Atualizar um veículo
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id);
        if (existingVehicle != null) {
            // Atualizando as informações do veículo
            existingVehicle.setMake(vehicle.getMake());
            existingVehicle.setModel(vehicle.getModel());
            existingVehicle.setColor(vehicle.getColor());
            existingVehicle.setYear(vehicle.getYear());
            return vehicleRepository.save(existingVehicle);
        } else {
            // Lançar exceção ou retornar erro caso o veículo não exista
            throw new RuntimeException("Vehicle not found with id " + id);
        }
    }

    // Deletar um veículo
    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        if (vehicle != null) {
            vehicleRepository.deleteById(id);
        } else {
            // Lançar exceção ou retornar erro caso o veículo não exista
            throw new RuntimeException("Vehicle not found with id " + id);
        }
    }

    // Buscar veículos por marca
    public List<Vehicle> getVehiclesByMake(String make) {
        return vehicleRepository.findByMake(make);
    }

    // Buscar veículos por modelo
    public List<Vehicle> getVehiclesByModel(String model) {
        return vehicleRepository.findByModel(model);
    }

    // Buscar veículos por cor
    public List<Vehicle> getVehiclesByColor(String color) {
        return vehicleRepository.findByColor(color);
    }
}
