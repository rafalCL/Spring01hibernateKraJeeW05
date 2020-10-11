package pl.coderslab.spring01hibernatekrajeew05.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring01hibernatekrajeew05.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrajeew05.entity.Publisher;

public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    private PublisherDao pd;

    @Override
    public Publisher convert(String pubId) {
        return pd.findById(Long.parseLong(pubId));
    }
}
