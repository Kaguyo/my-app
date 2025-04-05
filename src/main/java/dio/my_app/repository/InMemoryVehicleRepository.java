package dio.my_app.repository;

import dio.my_app.domain.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryVehicleRepository implements VehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<>();
    private long nextId = 1; // Para simular a geração de IDs.

    @Override
    public <S extends Vehicle> S save(S entity) {
        if (entity.getId() == null) {
            entity.setId(nextId++); // Gerando um ID único.
        }
        vehicles.add(entity);
        return entity;
    }

    @Override
    public List<Vehicle> findByMake(String make) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByModel(String model) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByColor(String color) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findAll() {
        return new ArrayList<>(vehicles);
    }

    @Override
    public void deleteById(Long id) {
        vehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public void deleteAll() {
        vehicles.clear();
    }

    @Override
    public boolean existsById(Long id) {
        return vehicles.stream().anyMatch(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
