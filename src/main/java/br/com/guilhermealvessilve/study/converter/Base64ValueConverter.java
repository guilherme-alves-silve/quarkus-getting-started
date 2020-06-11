package br.com.guilhermealvessilve.study.converter;

import br.com.guilhermealvessilve.study.config.Base64Value;
import org.eclipse.microprofile.config.spi.Converter;

public class Base64ValueConverter implements Converter<Base64Value> {

    @Override
    public Base64Value convert(String value) {
        return new Base64Value(value);
    }
}
