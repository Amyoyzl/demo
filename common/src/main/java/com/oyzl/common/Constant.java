package com.oyzl.common;

public class Constant {
    private final static String CLIENT_PORT = "8080";
    private final static String AUTH_PORT = "8081";
    private final static String RESOURCE_PORT = "8082";

    public final static String CLIENT_ID = "client_id";
    public final static String SECRET = "3ecret";
    public final static String SCOPES = "scopes";
    public final static String RESOURCE_ID = "resource_id";
    public final static String REDIRECT_URL = "http://client.server.com:" + CLIENT_PORT + "/login/oauth2/code/" + RESOURCE_ID;
    public final static String AUTHORIZATION_URL = "http://auth.server.com:"+ AUTH_PORT+"/oauth/authorize";
    public final static String TOKEN_URL = "http://auth.server.com:"+AUTH_PORT+"/oauth/token";
    public final static String CHECK_TOKEN_URL = "http://auth.server.com:"+AUTH_PORT+"/oauth/check_token";
    public final static String RESOURCE_URL = "http://resource.server.com:"+RESOURCE_PORT+"/oauth/user";

}
