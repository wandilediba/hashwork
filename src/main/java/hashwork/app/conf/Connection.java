package hashwork.app.conf;

import org.redisson.Config;
import org.redisson.Redisson;

/**
 * Created by hashcode on 2015/08/24.
 */
public class Connection {
    public static Redisson getCinnection() {
        // connects to single Redis server via Config
        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379");
        return Redisson.create(config);
    }
}
