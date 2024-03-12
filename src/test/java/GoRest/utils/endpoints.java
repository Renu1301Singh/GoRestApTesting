package GoRest.utils;

import GoRest.Config.Config;

public class endpoints {
    public static final String USERS = "/public/v2/users";
    public static final String DELETE_NON_EXISTENT_END_POINT = "/public/v2/users/999999900";
    public static final String CREATE_USER= "/public/v2/users";
    public static final String UPDATE_USER = "/public/v2/users/"+Config.userId;
    public static final String PATCH_USER = "/public/v2/users/"+Config.userId;
    public static final String DELETE_USER = "/public/v2/users/"+ Config.userId;
    public static final String INVALID_ENDPOINT = "/public/v2/ ";
}
