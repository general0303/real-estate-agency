package com.company.Services;

import com.company.Entitys.Address;
import com.company.Repositotys.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс AddressService, который отвечает за бизнес-логику работы с адресами
 * Имеет приватное свойство addressRepository
 */
@Service
public class AddressService {
    /** Репозиторий, необходимый для работы с базой */
    @Autowired
    private AddressRepository addressRepository;

    /**
     * Метод добавления нового адреса в базу. Создает новый адрес и отдает его addressRepository, который и
     * производит добавление
     * @param district название округа
     * @param street название улицы
     * @param numberOfHouse номер дома
     * @param map строка, frame с отборажением введенного адреса на google map
     * @return сообщение "ok"
     */
    public String addNewAddress(String district, String street, Integer numberOfHouse, String map){
        Address address = new Address();
        address.setDistrict(district);
        address.setStreet(street);
        address.setNumberOfHouse(numberOfHouse);
        address.setMap(map);
        addressRepository.save(address);
        return "ok";
    }

    /**
     * Метод удаления адреса из базы. Получает на вход адрес и отдает его addressRepository, который и
     * производит удаление
     * @param address Объект класса Address, который и нужно удалить
     * @return сообщение "ok"
     */
    public String deleteAddress(Address address){
        addressRepository.delete(address);
        return "ok";
    }

    /**
     * Метод поиска адреса по его id
     * @param id - число, по которму и будет осуществлен поиск
     * @return найденный адрес
     */
    public Address findAddress(Integer id){
        return addressRepository.getOne(id);
    }
}
