package com.company.Controllers;

import com.company.Entitys.Housing;
import com.company.Services.AddressService;
import com.company.Services.HousingService;
import com.company.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private HousingService housingService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/add_new_address")
    public @ResponseBody String addNewAddress(@RequestParam String district, @RequestParam String street,
                                              @RequestParam Integer numberOfHouse){
        return addressService.addNewAddress(district, street, numberOfHouse);
    }

    @RequestMapping(path = "/add_new_housing")
    public @ResponseBody String addNewHousing(@RequestParam String type, @RequestParam Integer price,
                                               @RequestParam Integer square, @RequestParam Integer numberOfRooms,
                                              @RequestParam String nearestMetro, @RequestParam Integer address_id){
        return housingService.addNewHousing(type, price, square, numberOfRooms, nearestMetro, address_id);
    }

    @RequestMapping(path = "/delete_a_housing")
    public @ResponseBody String deleteHousing(Integer housing_id){
        return housingService.deleteHousing(housing_id);
    }

    @RequestMapping(path = "/all_housings")
    public @ResponseBody List<Housing> findAll(){
        return housingService.findAll();
    }

    @RequestMapping(path = "/find_housing_by_type")
    public @ResponseBody List<Housing> findByType(@RequestParam String type){
        return housingService.findByType(type);
    }

    @RequestMapping(path = "/find_housing_by_price")
    public @ResponseBody List<Housing> findByPrice(@RequestParam Integer minPrice, @RequestParam Integer maxPrice){
        return housingService.findByPrice(minPrice, maxPrice);
    }

    @RequestMapping(path = "/find_housing_by_square")
    public @ResponseBody List<Housing> findBySquare(@RequestParam Integer minSquare, @RequestParam Integer maxSquare){
        return housingService.findBySquare(minSquare, maxSquare);
    }

    @RequestMapping(path = "/find_housing_by_number_of_rooms")
    public @ResponseBody List<Housing> findByNumberOfRooms(@RequestParam Integer numberOfRooms){
        return housingService.findByNumberOfRooms(numberOfRooms);
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro")
    public @ResponseBody List<Housing> findByNearestMetro(@RequestParam String nearestMetro){
        return housingService.findByNearestMetro(nearestMetro);
    }

    @RequestMapping(path = "/find_housing_by_number_of_rooms_and_price")
    public @ResponseBody List<Housing> findByNumberOfRoomsAndPrice(@RequestParam Integer numberOfRooms,
                                                                   @RequestParam Integer minPrice,
                                                                   @RequestParam Integer maxPrice){
        return housingService.findByNumberOfRoomsAndPrice(numberOfRooms, minPrice, maxPrice);
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro_and_type")
    public @ResponseBody List<Housing> findByNearestMetroAndType(@RequestParam String nearestMetro,
                                                                 @RequestParam String type){
        return housingService.findByNearestMetroAndType(nearestMetro, type);
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro_and_price")
    public @ResponseBody List<Housing> findByNearestMetroAndPrice(@RequestParam String nearestMetro,
                                                                  @RequestParam Integer minPrice,
                                                                  @RequestParam Integer maxPrice){
        return housingService.findByNearestMetroAndPrice(nearestMetro, minPrice, maxPrice);
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro_and_square")
    public @ResponseBody List<Housing> findByNearestMetroAndSquare(@RequestParam String nearestMetro,
                                                                   @RequestParam Integer minSquare,
                                                                   @RequestParam Integer maxSquare){
        return housingService.findByNearestMetroAndSquare(nearestMetro, minSquare, maxSquare);
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro_and_number_of_rooms")
    public @ResponseBody List<Housing> findByNearestMetroAndNumberOfRooms(@RequestParam String nearestMetro,
                                                                          @RequestParam Integer numberOfRooms){
        return housingService.findByNearestMetroAndNumberOfRooms(nearestMetro, numberOfRooms);
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro_and_type_and_square")
    public @ResponseBody List<Housing> findByNearestMetroAndTypeAndSquare(@RequestParam String nearestMetro,
                                                                          @RequestParam String type,
                                                                          @RequestParam Integer minSquare,
                                                                          @RequestParam Integer maxSquare){
        return housingService.findByNearestMetroAndTypeAndSquare(nearestMetro, type, minSquare, maxSquare);
    }
}
