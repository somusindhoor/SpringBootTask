package com.example.veh.repo;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.veh.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{

	//To get based on color
	@Query(value="select * from vehicle where v_color='Red'", nativeQuery = true)
	List<Vehicle> getByColor();


	//Sorted by Price
	@Query(value = "select * from vehicle order by v_price", nativeQuery = true)
	List<Vehicle> getByPriceSorted(Pageable pageable);

	//Price more than 10,00,000
	@Query(value = "select * from vehicle where v_price > 1000000", nativeQuery = true)
	List<Vehicle> morethan10L();

}
