package org.task.planner.userinterface;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Deprecated
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserInterfaceWebService {

    @WebMethod
    public String getHello(String name);
}
