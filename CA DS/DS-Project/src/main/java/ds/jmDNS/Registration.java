package ds.jmDNS;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Registration {


    public Registration() {
    }

    public void registerService(Properties prop) {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost().getHostAddress());

            String service_type = prop.getProperty("service_type");//"_http._tcp.local.";
            String service_name = prop.getProperty("service_name");// "example";
            int service_port = Integer.parseInt(prop.getProperty("service_port"));// #.50051;


            String service_description_properties = prop.getProperty("service_description");//"path=index.html";

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);

            System.out.printf("registering service with type %s and name %s \n", service_type, service_name);

            // Wait a bit
            Thread.sleep(1000);

            // Unregister all services
            //jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Properties getProperties(String name) throws IOException, NullPointerException {

        Properties prop;
        InputStream input = null;
        if (name.equals("Lighting")) {
            input = Files.newInputStream(Paths.get("C:/Users/magui/Desktop/Learning stuff/DS-CA-/CA DS/DS-Project/src/main/resources/SmartLighting.properties"));
        } else if (name.equals("Management")) {
            input = Files.newInputStream(Paths.get("C:/Users/magui/Desktop/Learning stuff/DS-CA-/CA DS/DS-Project/src/main/resources/SmartManagement.properties"));
        } else {
            input = Files.newInputStream(Paths.get("C:/Users/magui/Desktop/Learning stuff/DS-CA-/CA DS/DS-Project/src/main/resources/SmartTill.properties"));
        }

        prop = new Properties();
        // load a properties file
        prop.load(input);

        // get the property value and print it out
        System.out.println("Service properies ...");
        System.out.println("\t service_type: " + prop.getProperty("service_type"));
        System.out.println("\t service_name: " + prop.getProperty("service_name"));
        System.out.println("\t service_description: " + prop.getProperty("service_description"));
        System.out.println("\t service_port: " + prop.getProperty("service_port"));

        return prop;
    }
}
