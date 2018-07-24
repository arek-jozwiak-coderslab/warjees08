package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.DrinkDao;
import pl.coderslab.dao.StudentGroupDao;
import pl.coderslab.entity.Drink;
import pl.coderslab.entity.StudentGroup;

public class DrinkConverter implements Converter<String, Drink> {

    @Autowired
    DrinkDao drinkDao;

    @Override
    public Drink convert(String s) {
        return drinkDao.findById(Long.parseLong(s));
    }
}
