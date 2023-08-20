package manager;

import model.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginDataClass() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{User.builder().email("medvedkovaalex@gmail.com").password("Alex456!").build()});
        return list.iterator();
    }
}
