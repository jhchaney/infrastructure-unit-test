import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.NTPClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Chaney on 1/4/17.
 */
@RunWith(value = Parameterized.class)
public class NTPTest {
    NTPUDPClient client;


    @Parameterized.Parameter(value=0)
    public String hostname;

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[]{"localhost","time.nist.gov","blah.example.com"});
    }

  @Before
    public void  setup(){
      client = new NTPUDPClient();
      try {
          client.open();
      }catch (Exception e){
            Assert.fail();
      }
  }

  @Test
    public void testConnectivity(){
        try {
            InetAddress hostAddr = InetAddress.getByName(hostname);

            TimeInfo info = client.getTime(hostAddr);
            Assert.assertNotNull(info);
        }catch (UnknownHostException uhe){
            Assert.fail();
        }catch(IOException ioe){
            Assert.fail();
        }
    }


    @After
    public void cleanup(){
        client.close();
    }
}
