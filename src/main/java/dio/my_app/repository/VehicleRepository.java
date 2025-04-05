package dio.my_app.repository;

import dio.my_app.domain.Vehicle;

import java.util.List;

public interface VehicleRepository {
    <S extends Vehicle> S save(S entity);

    List<Vehicle> findByMake(String make);

    List<Vehicle> findByModel(String model);

    List<Vehicle> findByColor(String color);

    List<Vehicle> findAll();

    void deleteById(Long id);

    void deleteAll();

    boolean existsById(Long id);

    Vehicle findById(Long id);
}
