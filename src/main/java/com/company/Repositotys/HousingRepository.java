package com.company.Repositotys;

import com.company.Entitys.Housing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HousingRepository extends JpaRepository<Housing, Integer> {
    List<Housing> findAllByOrderByPrice();

    List<Housing> findAllByTypeOrderByPrice(String type);
    List<Housing> findAllByPriceBetweenOrderByPrice(Integer minPrice, Integer maxPrice);
    List<Housing> findAllBySquareBetweenOrderByPrice(Integer minSquare, Integer maxSquare);
    List<Housing> findAllByNumberOfRoomsOrderByPrice(Integer numberOfRooms);
    List<Housing> findAllByNearestMetroOrderByPrice(String nearestMetro);

    List<Housing> findAllByNumberOfRoomsAndPriceBetweenOrderByPrice(Integer numberOfRooms, Integer minSquare,
                                                                    Integer maxSquare);
    List<Housing> findAllByNearestMetroAndTypeOrderByPrice(String nearestMetro, String type);
    List<Housing> findAllByNearestMetroAndPriceBetweenOrderByPrice(String nearestMetro, Integer minPrice,
                                                                   Integer maxPrice);
    List<Housing> findAllByNearestMetroAndSquareBetweenOrderByPrice(String nearestMetro, Integer minSquare,
                                                                    Integer maxSquare);
    List<Housing> findAllByNearestMetroAndNumberOfRoomsOrderByPrice(String nearestMetro, Integer numberOfRooms);

    List<Housing> findAllByNearestMetroAndTypeAndSquareBetweenOrderByPrice(String nearestMetro, String type,
                                                                           Integer minSquare, Integer maxSquare);
}
