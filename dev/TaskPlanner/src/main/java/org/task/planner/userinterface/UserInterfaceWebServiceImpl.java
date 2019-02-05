package org.task.planner.userinterface;

import javax.jws.WebService;

@Deprecated
@WebService(endpointInterface = "org.task.planner.userinterface.UserInterfaceWebService")
public class UserInterfaceWebServiceImpl implements UserInterfaceWebService{
    @Override
    public String getHello(String name) {
        return "Hello" + name;
    }
}
