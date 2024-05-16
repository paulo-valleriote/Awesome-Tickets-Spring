package valleriote.paulo.awesometickets.infra.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JwtService {
    private final static String secret = "36970c3f75ac9b16c2645d5836f174771bc1a2f94c92a2c6a92fb0839502cf57";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    private static final int MINUTES = 60;

    public static String generateToken(String login, Long id) {
        var now = Instant.now();
        return Jwts.builder()
                .subject(login + "_" + id)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(MINUTES, ChronoUnit.MINUTES)))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static String extractLogin(String token) {
        String tokenSub = getTokenBody(token).getSubject();
        String[] parts = tokenSub.split("_");
        return parts[0];
    }

    public static String extractId(String token) {
        String tokenSub = getTokenBody(token).getSubject();
        String[] parts = tokenSub.split("_");
        return parts[1];
    }

    public static Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractLogin(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private static Claims getTokenBody(String token) {
        return Jwts
                .parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private static boolean isTokenExpired(String token) {
        Claims claims = getTokenBody(token);
        return claims.getExpiration().before(new Date());
    }

}
