package ds.jmDNS;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Discovery {

    private ServiceInfo serviceInfo;

    public void discoverService(String service_type) {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost().getHostAddress());


            jmdns.addServiceListener(service_type, new ServiceListener() {

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("service resolved: " + event.getInfo());

                    serviceInfo = event.getInfo();

                    int port = serviceInfo.getPort();

                    System.out.println("resolving " + service_type + " with properties ...");
                    System.out.println("\t port: " + port);
                    System.out.println("\t type:" + event.getType());
                    System.out.println("\t name: " + event.getName());
                    System.out.println("\t description/properties: " + serviceInfo.getNiceTextString());
                    System.out.println("\t host: " + serviceInfo.getHostAddresses()[0]);


                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: " + event.getInfo());


                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Service added: " + event.getInfo());


                }
            });

            // Wait a bit
//            Thread.sleep(15000);

//            jmdns.close();

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
