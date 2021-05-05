package com.company.Services;

import com.company.Entitys.Address;
import com.company.Repositotys.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public String addNewAddress(String district, String street, Integer numberOfHouse, String map){
        Address address = new Address();
        address.setDistrict(district);
        address.setStreet(street);
        address.setNumberOfHouse(numberOfHouse);
        address.setMap(map);
        addressRepository.save(address);
        return "ok";
    }

    public String deleteAddress(Address address){
        addressRepository.delete(address);
        return "ok";
    }

    public Address findAddress(Integer id){
        return addressRepository.getOne(id);
    }
}
