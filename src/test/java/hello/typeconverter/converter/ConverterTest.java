package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @Test
    public void stringToInteger(){
        //given
        StringToIntegerConverter converter = new StringToIntegerConverter();
        //when
        Integer result = converter.convert("10");
        //then
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void IntegerToString() throws Exception {
        //given
        IntegerToStringConverter converter = new IntegerToStringConverter();
        //when
        String result = converter.convert(10);
        //then
        assertThat(result).isEqualTo("10");
    }

    @Test
    public void stringToIpPort() throws Exception {
        //given
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String ip = "127.0.0.1:8080";
        //when
        IpPort result = converter.convert(ip);
        //then
        assertThat(result.getIp()).isEqualTo("127.0.0.1");
        assertThat(result.getPort()).isEqualTo(8080);
    }

    @Test
    public void ipPortToString() throws Exception {
        //given
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        //when
        String result = converter.convert(ipPort);
        //then
        assertThat(result).isEqualTo("127.0.0.1:8080");

    }
}
