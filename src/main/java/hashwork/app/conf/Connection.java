package hashwork.app.conf;

import org.redisson.Config;
import org.redisson.Redisson;

/**
 * Created by hashcode on 2015/08/24.
 */
public class Connection {
    public static Redisson getConnection() {
        // connects to single Redis server via Config
        Config config = new Config();
        config.useSingleServer().setAddress("redis.hashcode.zm:6379");
        return Redisson.create(config);
    }
}
