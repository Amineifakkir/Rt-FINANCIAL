package com.rtfinancial.constant;

public class SecurityConstant {

    //	public static final long EXPIRATION_TIME = 1_800_000; // 30 minutes
    public static final long EXPIRATION_TIME = 900_000; // 15 minutes
    public static final long EXPIRATION_REFRESH_TIME = 1_209_600_000; // 14 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String REFRESH_TOKEN_HEADER = "Refresh-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String SOFTCODE_LLC = "SoftCode, LLC"; //limited liability company
    public static final String SOFTCODE_ADMINISTRATION = "A1 Business Group";
    public static final String AUTHORITIES = "authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String[] PUBLIC_URLS = {"/user/login", "/api/login", "/user/register", "/user/refresh", "/user/resetpassword/**", "/user/image/**", "/error", "/api/products/images/**"};
}
