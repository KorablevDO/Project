package ProjectServer.Metrics.MetricsCPU;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Map;
import java.util.Properties;




//import org.runtimemonitoring.tracing.ITracer;


public class MetricsCPU {
    public void get(){
        String getOS = System.getenv("OS");
        Map<String, String> map = System.getenv();
//        Runtime.getRuntime().
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());

        Properties test = System.getProperties();



        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(operatingSystemMXBean.getVersion());
        System.out.println(operatingSystemMXBean.getName());
        System.out.println(operatingSystemMXBean.getArch());
        System.out.println(operatingSystemMXBean.getAvailableProcessors());
//        System.out.println(operatingSystemMXBean.getSystemLoadAverage());



    }
}
