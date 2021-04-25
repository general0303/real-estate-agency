package com.company.Controllers;

import com.company.Entitys.Housing;
import com.company.Services.AddressService;
import com.company.Services.HousingService;
import com.company.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String findAll(Model model){
        List<Housing> housings = housingService.findAll();
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_type")
    public String findHousingByType(Model model){
        String type="";
        model.addAttribute("type", type);
        return "filter_type";
    }

    @RequestMapping(path = "/find_by_type")
    public String findByType(@RequestParam String type, Model model){
        List<Housing> housings = housingService.findByType(type);
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_price")
    public String findHousingByPrice(Model model){
        Integer minPrice=0, maxPrice=0;
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "filter_price";
    }

    @RequestMapping(path = "/find_by_price")
    public String findByPrice(@RequestParam Integer minPrice, @RequestParam Integer maxPrice, Model model){
        List<Housing> housings = housingService.findByPrice(minPrice, maxPrice);
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_square")
    public String findHousingBySquare(Model model){
        Integer minSquare=0, maxSquare=0;
        model.addAttribute("minSquare", minSquare);
        model.addAttribute("maxSquare", maxSquare);
        return "filter_square";
    }

    @RequestMapping(path = "/find_by_square")
    public String findBySquare(@RequestParam Integer minSquare, @RequestParam Integer maxSquare,
                                                    Model model){
        List<Housing> housings = housingService.findBySquare(minSquare, maxSquare);
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_number_of_rooms")
    public String findHousingByNumberOfRooms(Model model){
        Integer numberOfRooms=0;
        model.addAttribute("numberOfRooms", numberOfRooms);
        return "filter_number_of_rooms";
    }

    @RequestMapping(path = "/find_by_number_of_rooms")
    public String findByNumberOfRooms(@RequestParam Integer numberOfRooms, Model model){
        List<Housing> housings = housingService.findByNumberOfRooms(numberOfRooms);
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro")
    public String findHousingByNearestMetro(Model model){
        String nearestMetro="";
        model.addAttribute("nearestMetro", nearestMetro);
        return "filter_nearest_metro";
    }

    @RequestMapping(path = "/find_by_nearest_metro")
    public String findByNearestMetro(@RequestParam String nearestMetro, Model model){
        List<Housing> housings = housingService.findByNearestMetro(nearestMetro);
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_number_of_rooms_and_price")
    public String findHousingByNumberOfRoomsAndPrice(Model model){
        Integer minPrice=0, maxPrice=0, numberOfRooms=0;
        model.addAttribute("numberOfRooms", numberOfRooms);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "filter_number_of_rooms_and_price";
    }

    @RequestMapping(path = "/find_by_number_of_rooms_and_price")
    public String findByNumberOfRoomsAndPrice(@RequestParam Integer numberOfRooms, @RequestParam Integer minPrice,
                                                                   @RequestParam Integer maxPrice, Model model){
        List<Housing> housings = housingService.findByNumberOfRoomsAndPrice(numberOfRooms, minPrice, maxPrice);
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro_and_type")
    public String findHousingByNearestMetroAndType(Model model){
        String nearestMetro="", type="";
        model.addAttribute("nearestMetro", nearestMetro);
        model.addAttribute("type", type);
        return "filter_nearest_metro_and_type";
    }

    @RequestMapping(path = "/find_by_nearest_metro_and_type")
    public String findByNearestMetroAndType(@RequestParam String nearestMetro, @RequestParam String type, Model model){
        List<Housing> housings = housingService.findByNearestMetroAndType(nearestMetro, type);
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro_and_price")
    public String findHousingByNearestMetroAndPrice(Model model){
        String nearestMetro="";
        Integer minPrice=0, maxPrice=0;
        model.addAttribute("nearestMetro", nearestMetro);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "filter_nearest_metro_and_price";
    }

    @RequestMapping(path = "/find_by_nearest_metro_and_price")
    public String findByNearestMetroAndPrice(@RequestParam String nearestMetro, @RequestParam Integer minPrice,
                                                                  @RequestParam Integer maxPrice, Model model){
        List<Housing> housings = housingService.findByNearestMetroAndPrice(nearestMetro, minPrice, maxPrice);
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro_and_square")
    public String findHousingByNearestMetroAndSquare(Model model){
        String nearestMetro="";
        Integer minSquare=0, maxSquare=0;
        model.addAttribute("nearestMetro", nearestMetro);
        model.addAttribute("minSquare", minSquare);
        model.addAttribute("maxSquare", maxSquare);
        return "filter_nearest_metro_and_square";
    }

    @RequestMapping(path = "/find_by_nearest_metro_and_square")
    public String findByNearestMetroAndSquare(@RequestParam String nearestMetro, @RequestParam Integer minSquare,
                                                                   @RequestParam Integer maxSquare, Model model){
        List<Housing> housings = housingService.findByNearestMetroAndSquare(nearestMetro, minSquare, maxSquare);
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro_and_number_of_rooms")
    public String findHousingByNearestMetroAndNumberOfRooms(Model model){
        String nearestMetro="";
        Integer numberOfRooms=0;
        model.addAttribute("nearestMetro", nearestMetro);
        model.addAttribute("numberOfRooms", numberOfRooms);
        return "filter_nearest_metro_and_number_of_rooms";
    }

    @RequestMapping(path = "/find_by_nearest_metro_and_number_of_rooms")
    public String findByNearestMetroAndNumberOfRooms(@RequestParam String nearestMetro,
                                                     @RequestParam Integer numberOfRooms, Model model){
        List<Housing> housings = housingService.findByNearestMetroAndNumberOfRooms(nearestMetro, numberOfRooms);
        model.addAttribute("housings", housings);
        return "housing";
    }

    @RequestMapping(path = "/find_housing_by_nearest_metro_and_type_and_square")
    public String findHousingByNearestMetroAndTypeAndSquare(Model model){
        String nearestMetro="", type="";
        Integer minSquare=0, maxSquare=0;
        model.addAttribute("nearestMetro", nearestMetro);
        model.addAttribute("type", type);
        model.addAttribute("minSquare", minSquare);
        model.addAttribute("maxSquare", maxSquare);
        return "filter_nearest_metro_and_type_and_square";
    }

    @RequestMapping(path = "/find_by_nearest_metro_and_type_and_square")
    public String findByNearestMetroAndTypeAndSquare(@RequestParam String nearestMetro, @RequestParam String type,
                                                                          @RequestParam Integer minSquare,
                                                                          @RequestParam Integer maxSquare, Model model){
        List<Housing> housings = housingService.findByNearestMetroAndTypeAndSquare(nearestMetro, type, minSquare,
                maxSquare);
        model.addAttribute("housings", housings);
        return "housing";
    }
}
