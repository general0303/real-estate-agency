import com.company.Entitys.Address;
import com.company.Entitys.Housing;
import com.company.Repositotys.HousingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HousingServiceTest {
    @Mock
    HousingRepository housingRepository;


    @Captor
    ArgumentCaptor<Housing> captor;

    Housing createHousing(String type, Integer price, Integer square, Integer numberOfRooms, String nearestMetro,
                          String image){
        Address address = new Address();
        address.setDistrict("West");
        address.setStreet("Kuntsevskaya");
        address.setNumberOfHouse(1);
        address.setMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d17974.49938569515!2d37." +
                "4098515488849!3d55.72701192590375!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46b54ee9085" +
                "1b1c5%3A0xc2436b04ac4f843a!2z0JrRg9C90YbQtdCy0YHQutCw0Y8g0YPQuy4sIDEsINCc0L7RgdC60LLQsCwgMTIxMzUx!" +
                "5e0!3m2!1sru!2sru!4v1620484206904!5m2!1sru!2sru");
        Housing housing = new Housing();
        housing.setType(type);
        housing.setPrice(price);
        housing.setSquare(square);
        housing.setNumberOfRooms(numberOfRooms);
        housing.setNearestMetro(nearestMetro);
        housing.setAddress(address);
        housing.setImage(image);
        return housing;
    }

    @Test
    void getAllHousings(){
        Housing housing1 = createHousing("flat", 11000000, 95, 3,
                "Kuntsevskaya", "https://extpic3.kf.expert/images/4CA17146-8ED9-EA11-B810-" +
                        "0050568C58C5/preview_wm/3FF952B3-25DA-EA11-B810-0050568C58C5.jpg");
        Housing housing2 = createHousing("flat", 7000000, 62, 2,"Kuntsevskaya",
                "https://ptzgovorit.ru/sites/default/files/styles/700x400/public/original_nodes/15_15.jpg?itok=" +
                        "XIpCcev3");
        Mockito.when(housingRepository.findAll()).thenReturn(List.of(housing1, housing2));
        Assertions.assertEquals(2, housingRepository.findAll().size());
    }

    @Test
    void addNewHousing(){
        Housing housing = createHousing("flat", 11000000, 95, 3,
                "Kuntsevskaya", "https://extpic3.kf.expert/images/4CA17146-8ED9-EA11-B810-" +
                        "0050568C58C5/preview_wm/3FF952B3-25DA-EA11-B810-0050568C58C5.jpg");
        housingRepository.save(housing);
        Mockito.verify(housingRepository).save(captor.capture());
        Housing captured = captor.getValue();
        Assertions.assertEquals("flat", captured.getType());
    }

    @Test
    void deleteHousing(){
        Housing housing = createHousing("flat", 11000000, 95, 3,
                "Kuntsevskaya", "https://extpic3.kf.expert/images/4CA17146-8ED9-EA11-B810-" +
                        "0050568C58C5/preview_wm/3FF952B3-25DA-EA11-B810-0050568C58C5.jpg");
        housingRepository.save(housing);
        housingRepository.delete(housing);
        Mockito.verify(housingRepository).save(captor.capture());
        Housing captured = captor.getValue();
        Assertions.assertEquals("flat", captured.getType());
        Assertions.assertEquals(0, housingRepository.findAll().size());
    }

}
