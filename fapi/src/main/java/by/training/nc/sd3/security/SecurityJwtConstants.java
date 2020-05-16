package by.training.nc.sd3.security;

public class SecurityJwtConstants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final String SIGNING_KEY = "ethalon123sign";
    public static final String TOKEN_PREFIX = "my-auth-token";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";
}
