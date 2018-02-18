package ProjectServer.Metrics.MetricsCPU;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Map;
import java.util.Properties;




//import org.runtimemonitoring.tracing.ITracer;

/**
 *
 https://stackoverflow.com/questions/25552/get-os-level-system-information#25583

 http://nadeausoftware.com/articles/2008/03/java_tip_how_get_cpu_and_user_time_benchmarking#UsingaSuninternalclasstogetJVMCPUtime

 https://stackoverflow.com/questions/47177/how-do-i-monitor-the-computers-cpu-memory-and-disk-usage-in-java

 https://www.javaworld.com/article/2073044/java-se/access-windows-performance-monitor-counters-from-java--part-1.html

 https://www.javaworld.com/article/2072116/java-se/access-windows-performance-monitor-counters-from-java--part-2.html

 https://www.ibm.com/developerworks/ru/library/j-rtm3/index.html

 https://docs.oracle.com/javase/7/docs/technotes/guides/management/

 https://github.com/richardfriedman/bluecode/blob/master/java/plugins/src/org/blue/star/plugins/check_cpu.java

 https://sourceforge.net/projects/sigar/

 http://itech-notes.blogspot.ru/2012/08/hyperic-sigar-java.html

 http://qaru.site/questions/315656/cpu-load-from-java

 java API System Monitor

 String getOS = System.getenv("OS");
 */
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
