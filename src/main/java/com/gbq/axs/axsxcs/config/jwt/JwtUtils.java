package com.gbq.axs.axsxcs.config.jwt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gbq.axs.axsxcs.mapper.AccountMapper;
import com.gbq.axs.axsxcs.pojo.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtUtils
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/21 11:07
 */
@Component
public class JwtUtils {
    @Autowired
    private AccountMapper accountMapper;

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String ClAIM_KEY_USERID = "userId";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    //过期时间
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     *@Author: guobenqi
     *@Description 根据用户信息生成token
     *@Date: 8:42 2022/1/21
     *@Param
     *@return
     */
    public String generateToken(Account userDetails){
        HashMap<String,Object> claims = new HashMap<>();
        System.out.println("登录的人\n"+userDetails);
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(ClAIM_KEY_USERID,userDetails.getId());
        claims.put(CLAIM_KEY_CREATED,new Date());
        System.out.println(generateToken(claims));
        return generateToken(claims);
    }

    /**
     *@Description 根据荷载生成token
     *@Date: 8:51 2022/1/21
     *@Param
     *@return
     */
    private String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                //声明信息
                .setClaims(claims)
                //过期时间
                .setExpiration(generateExpiration())
                //签名算法，密钥
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * 生成过期时间
     * */

    private Date generateExpiration() {
        return new Date(System.currentTimeMillis()+expiration*1000);
    }


    /**
     *@Description 根据token获用户名
     *@Param
     *@return
     */
    public String getUsernameFromToken(String token){
        String username = null;
        Claims claims = getClaimsFromToken(token);
        System.out.println(claims);
        try{
            username = claims.getSubject();
            System.out.println(claims.get("userId"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return username;

    }
    public Integer getUUIDFromToken(String token){
        Integer userid = null;
        Claims claims = getClaimsFromToken(token);
        System.out.println(claims);
        try{
            userid = (Integer) claims.get("userId");

        }catch (Exception e){
            e.printStackTrace();
        }
        return userid;

    }

    /**
     *@Description 根据token获取荷载
     *@Param
     *@return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

        }catch (ExpiredJwtException e){
//            e.printStackTrace();
            claims= e.getClaims();
        }
        return claims;
    }

    /**
     *@Description 判断token是否有效
     *@Param
     *@return
     */
    public Boolean validateToken(String token){
        Integer userid = getUUIDFromToken(token);
        String username = getUsernameFromToken(token);
//        List<User> userByName = userMapper.findUserByName(username);
        Account account = accountMapper.selectOne(new QueryWrapper<Account>().eq("id", userid));

        if (account.getUsername().equals(username) && account != null ){
            return !isTokenExpired(token);
        }
        return false;
    }

    /**
     *@Description 验证token是否在有效时间内
     *@Param
     *@return
     */
    public boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());

    }
    /**
     *@Description 根据token获取过期时间
     *@Param
     *@return
     */
    public Date getExpiredDateFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        System.out.println(claims);
        return claims.getExpiration();
    }

    /**
     * 判断token是否可以被刷新
     * */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }
    /**
     *@Description 刷新token
     *@param
     *@return
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);

    }


}
