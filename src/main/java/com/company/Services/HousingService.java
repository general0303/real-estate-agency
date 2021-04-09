package com.company.Services;

import com.company.Entitys.Address;
import com.company.Entitys.Housing;
import com.company.Repositotys.AddressRepository;
import com.company.Repositotys.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousingService {
    @Autowired
    HousingRepository housingRepository;

    @Autowired
    AddressRepository addressRepository;

    public String addNewHousing(String type, Integer price, Integer square, Integer numberOfRooms, String nearestMetro,
                                Integer address_id){
        Housing housing = new Housing();
        housing.setType(type);
        housing.setPrice(price);
        housing.setSquare(square);
        housing.setNumberOfRooms(numberOfRooms);
        housing.setNearestMetro(nearestMetro);
        Address address = addressRepository.getOne(address_id);
        housing.setAddress(address);
        housingRepository.save(housing);
        return "ok";
    }

    public String deleteHousing(Integer housing_id){
        Housing housing = housingRepository.getOne(housing_id);
        Address address = housing.getAddress();
        housingRepository.delete(housing);
        if (address.getHousings().size() == 0)
            addressRepository.delete(address);
        return "ok";
    }

    public List<Housing> findAll(){
        return housingRepository.findAllByOrderByPrice();
    }

    public List<Housing> findByType(String type){
        return housingRepository.findAllByTypeOrderByPrice(type);
    }

    public List<Housing> findByPrice(Integer minPrice, Integer maxPrice){
        return housingRepository.findAllByPriceBetweenOrderByPrice(minPrice, maxPrice);
    }

    public List<Housing> findBySquare(Integer minSquare, Integer maxSquare){
        return housingRepository.findAllBySquareBetweenOrderByPrice(minSquare, maxSquare);
    }

    public List<Housing> findByNumberOfRooms(Integer numberOfRooms){
        return housingRepository.findAllByNumberOfRoomsOrderByPrice(numberOfRooms);
    }

    public List<Housing> findByNearestMetro(String nearestMetro){
        return housingRepository.findAllByNearestMetroOrderByPrice(nearestMetro);
    }

    public List<Housing> findByNumberOfRoomsAndPrice(Integer numberOfRooms, Integer minPrice, Integer maxPrice){
        return housingRepository.findAllByNumberOfRoomsAndPriceBetweenOrderByPrice(numberOfRooms, minPrice, maxPrice);
    }

    public List<Housing> findByNearestMetroAndType(String nearestMetro, String type){
        return housingRepository.findAllByNearestMetroAndTypeOrderByPrice(nearestMetro, type);
    }

    public List<Housing> findByNearestMetroAndPrice(String nearestMetro, Integer minPrice, Integer maxPrice){
        return housingRepository.findAllByNearestMetroAndPriceBetweenOrderByPrice(nearestMetro, minPrice, maxPrice);
    }

    public List<Housing> findByNearestMetroAndSquare(String nearestMetro, Integer minSquare, Integer maxSquare){
        return housingRepository.findAllByNearestMetroAndSquareBetweenOrderByPrice(nearestMetro, minSquare, maxSquare);
    }

    public List<Housing> findByNearestMetroAndNumberOfRooms(String nearestMetro, Integer numberOfRooms){
        return housingRepository.findAllByNearestMetroAndNumberOfRoomsOrderByPrice(nearestMetro, numberOfRooms);
    }

    public List<Housing> findByNearestMetroAndTypeAndSquare(String nearestMetro, String type, Integer minSquare,
                                                            Integer maxSquare){
        return housingRepository.findAllByNearestMetroAndTypeAndSquareBetweenOrderByPrice(nearestMetro, type, minSquare,
                maxSquare);
    }
}
