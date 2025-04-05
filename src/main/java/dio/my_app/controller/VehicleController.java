package dio.my_app.controller;

import dio.my_app.domain.Vehicle;
import dio.my_app.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Endpoint para listar todos os veículos
    @GetMapping("/")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // Endpoint para adicionar um veículo
    @PostMapping("/")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    // Endpoint para atualizar um veículo
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    // Endpoint para excluir um veículo
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }

    // Endpoint para buscar veículos por marca
    @GetMapping("/make/{make}")
    public List<Vehicle> getVehiclesByMake(@PathVariable String make) {
        return vehicleService.getVehiclesByMake(make);
    }

    // Endpoint para buscar veículos por modelo
    @GetMapping("/model/{model}")
    public List<Vehicle> getVehiclesByModel(@PathVariable String model) {
        return vehicleService.getVehiclesByModel(model);
    }

    // Endpoint para buscar veículos por cor
    @GetMapping("/color/{color}")
    public List<Vehicle> getVehiclesByColor(@PathVariable String color) {
        return vehicleService.getVehiclesByColor(color);
    }
}
