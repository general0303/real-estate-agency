import com.company.Entitys.Address;
import com.company.Repositotys.AddressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @Mock
    AddressRepository addressRepository;


    @Captor
    ArgumentCaptor<Address> captor;

    @Test
    void addNewAddress(){
        Address address = new Address();
        address.setDistrict("West");
        address.setStreet("Kuntsevskaya");
        address.setNumberOfHouse(1);
        address.setMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d17974.49938569515!2d37." +
                "4098515488849!3d55.72701192590375!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46b54ee9085" +
                "1b1c5%3A0xc2436b04ac4f843a!2z0JrRg9C90YbQtdCy0YHQutCw0Y8g0YPQuy4sIDEsINCc0L7RgdC60LLQsCwgMTIxMzUx!" +
                "5e0!3m2!1sru!2sru!4v1620484206904!5m2!1sru!2sru");
        addressRepository.save(address);
        Mockito.verify(addressRepository).save(captor.capture());
        Address captured = captor.getValue();
        Assertions.assertEquals("West", captured.getDistrict());
    }
}
