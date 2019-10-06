package main.java.be.ipeters.ottoz.cpbelcar.mappers;

import java.util.List;

import main.java.be.ipeters.ottoz.cpbelcar.domain.CarProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface CarProductMapper {
	@Select("select * from car_product")
	@Results(id = "carproductResult", value = { 
			@Result(property = "carId", column = "car_id"),
			@Result(property = "productId", column = "product_id")
	})
	List<CarProduct> findAll();
	//----------------------------------------------------------
	@Select  ("select * from car_product where car_id=#{prefix}") // 
	@ResultMap("carproductResult")
	List<CarProduct> getAllProductsWithCarId(Integer prefix);
	
	//----------------------------------------------------------


}
