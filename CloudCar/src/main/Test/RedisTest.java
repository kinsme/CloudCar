import com.cloudcar.util.JedisUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2016/6/17.
 */
public class RedisTest {
    private Jedis jedis;
    @Before
    public void setUp(){
        jedis= JedisUtil.getJedis();
    }
    @Test
    public void testAdd(){
        jedis.set("test","123456");
    }
    @After
    public void setEnd(){
        JedisUtil.removeResource(jedis);
    }
    @Test
    public void testDel(){
        jedis.del("test");
    }
}
