package com.company.Services;

import com.company.Entitys.Address;
import com.company.Entitys.Housing;
import com.company.Repositotys.AddressRepository;
import com.company.Repositotys.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * класс HousingService, который отвечат за бизнес-логику работы с жильем
 * Имеет два приватных свойства - housingRepository и addressService
 */
@Service
public class HousingService {

    /** Репозиторий, необходимый для работы с базой */
    @Autowired
    HousingRepository housingRepository;

    /** Обект класса AddressService
     * @see AddressService
     */
    @Autowired
    AddressService addressService;

    /**
     * Метод добавления нового жилья в базу. Создает новое жилье и отдает его housingRepository, который и
     * производит добавление
     * @param type строка, обозначающая тип жилья. Например, квартира или жилой дом
     * @param price цена
     * @param square площадь
     * @param numberOfRooms кол-во комнат
     * @param nearestMetro название ближайшей станции метро
     * @param image строка, ссылка на изображение этого жилья в интернете
     * @param addressId id адреса этого жилья
     * @return сообщение "ok"
     */
    public String addNewHousing(String type, Integer price, Integer square, Integer numberOfRooms, String nearestMetro,
                                String image, Integer addressId){
        Housing housing = new Housing();
        housing.setType(type);
        housing.setPrice(price);
        housing.setSquare(square);
        housing.setNumberOfRooms(numberOfRooms);
        housing.setNearestMetro(nearestMetro);
        housing.setImage(image);
        Address address = addressService.findAddress(addressId);
        housing.setAddress(address);
        housingRepository.save(housing);
        return "ok";
    }

    /**
     * Метод удаления жилья. Получает id жилья, при помощи housingRepository находит жилье с таким id в базе,
     * сохраняет его адрес и отдает его addressRepository, который  и производит удаление. Затем метод смотрит,
     * сколько объектов недвижимомти осталось по данному адресу. Если их не осталось, сообщает addressService,
     * что необходимо удалить данный адрес из базы
     * @param id id жилья
     * @return сообщение "ok"
     */
    public String deleteHousing(Integer id){
        Housing housing = housingRepository.getOne(id);
        Address address = housing.getAddress();
        housingRepository.delete(housing);
        if (address.getHousings().size() == 0)
            addressService.deleteAddress(address);
        return "ok";
    }

    /**
     * Метод поиска жилья по id
     * @param id id жилья
     * @return объект класса Housing
     */
    public Housing find(Integer id){
        return housingRepository.getOne(id);
    }

    /**
     * Метод получения всех записей о жилье из базы
     * @return список объектов класса Housing
     */
    public List<Housing> findAll(){
        return housingRepository.findAllByOrderByPrice();
    }

    /**
     * Метод поиска жилья по типу
     * @param type тип жилья
     * @return список объектов класса Housing, тип которых совпадает с переданным
     */
    public List<Housing> findByType(String type){
        return housingRepository.findAllByTypeOrderByPrice(type);
    }

    /**
     * Метод поиска жилья по цене
     * @param minPrice минимльная цена
     * @param maxPrice максимальная цена
     * @return список объектов класса Housing, цена которых входит в указанный диапазон
     */
    public List<Housing> findByPrice(Integer minPrice, Integer maxPrice){
        return housingRepository.findAllByPriceBetweenOrderByPrice(minPrice, maxPrice);
    }

    /**
     * Метод поиска жилья по площади
     * @param minSquare минимальная площадь
     * @param maxSquare максимальная площадь
     * @return список объектов класса Housing, площадь которых входит в указанный диапазон
     */
    public List<Housing> findBySquare(Integer minSquare, Integer maxSquare){
        return housingRepository.findAllBySquareBetweenOrderByPrice(minSquare, maxSquare);
    }

    /**
     * Метод поиска жилья по кол-ву комнат
     * @param numberOfRooms кол-во комнат
     * @return список объектов класса Housing, кол-во комнат которых совпадает с переданным
     */
    public List<Housing> findByNumberOfRooms(Integer numberOfRooms){
        return housingRepository.findAllByNumberOfRoomsOrderByPrice(numberOfRooms);
    }

    /**
     * Метод поиска жилья по названию ближайшей станции метро
     * @param nearestMetro название ближайшей станции метро
     * @return список объектов класса Housing, ближайшее метро которых совпадает с переданным
     */
    public List<Housing> findByNearestMetro(String nearestMetro){
        return housingRepository.findAllByNearestMetroOrderByPrice(nearestMetro);
    }

    /**
     * Метод поиска жилья по кол-ву комнат и цене
     * @param numberOfRooms кол-во комнат
     * @param minPrice минимальная цена
     * @param maxPrice максимальная цена
     * @return список объектов класса Housing, кол-во комнат и цена которых совпадает с переданными
     */
    public List<Housing> findByNumberOfRoomsAndPrice(Integer numberOfRooms, Integer minPrice, Integer maxPrice){
        return housingRepository.findAllByNumberOfRoomsAndPriceBetweenOrderByPrice(numberOfRooms, minPrice, maxPrice);
    }

    /**
     * Метод поиска жилья по названию ближайшей станции метро и типу
     * @param nearestMetro название ближайшей станции метро
     * @param type тип жилья
     * @return список объектов класса Housing, ближайшее метро и тип которых совпадает с переданными
     */
    public List<Housing> findByNearestMetroAndType(String nearestMetro, String type){
        return housingRepository.findAllByNearestMetroAndTypeOrderByPrice(nearestMetro, type);
    }

    /**
     * Метод поиска жилья по названию ближайшей станции метро и цене
     * @param nearestMetro название ближайшей станции метро
     * @param minPrice минимальная цена
     * @param maxPrice максимальная цена
     * @return список объектов класса Housing, ближайшее метро и цена которых совпадает с переданными
     */
    public List<Housing> findByNearestMetroAndPrice(String nearestMetro, Integer minPrice, Integer maxPrice){
        return housingRepository.findAllByNearestMetroAndPriceBetweenOrderByPrice(nearestMetro, minPrice, maxPrice);
    }

    /**
     * Метод поиска жилья по названию ближайшей станции метро и площади
     * @param nearestMetro название ближайшей станции метро
     * @param minSquare минимальная площадь
     * @param maxSquare максимальная площадь
     * @return список объектов класса Housing, ближайшее метро и площадь которых совпадает с переданными
     */
    public List<Housing> findByNearestMetroAndSquare(String nearestMetro, Integer minSquare, Integer maxSquare){
        return housingRepository.findAllByNearestMetroAndSquareBetweenOrderByPrice(nearestMetro, minSquare, maxSquare);
    }

    /**
     * Метод поиска жилья по названию ближайшей станции метро и кол-ву комнат
     * @param nearestMetro название ближайшей станции метро
     * @param numberOfRooms кол-во комнат
     * @return список объектов класса Housing, ближайшее метро и кол-во комнат которых совпадает с переданными
     */
    public List<Housing> findByNearestMetroAndNumberOfRooms(String nearestMetro, Integer numberOfRooms){
        return housingRepository.findAllByNearestMetroAndNumberOfRoomsOrderByPrice(nearestMetro, numberOfRooms);
    }

    /**
     * Метод поиска жилья по названию ближайшей станции метро, типу и площади
     * @param nearestMetro название ближайшей станции метро
     * @param type тип жилья
     * @param minSquare минимальная площадь
     * @param maxSquare максимальная площадь
     * @return список объектов класса Housing, ближайшее метро, площадь и тип которых совпадает с переданными
     */
    public List<Housing> findByNearestMetroAndTypeAndSquare(String nearestMetro, String type, Integer minSquare,
                                                            Integer maxSquare){
        return housingRepository.findAllByNearestMetroAndTypeAndSquareBetweenOrderByPrice(nearestMetro, type, minSquare,
                maxSquare);
    }
}
