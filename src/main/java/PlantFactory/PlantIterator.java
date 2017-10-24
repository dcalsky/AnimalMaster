package PlantFactory;

/****
 *
 * 声明iterator接口用于遍历plantcontainer中的植物
 *
 * Created by VentusXu on 2017/10/23
 *
 */

import BaseClass.Plant;

public interface PlantIterator {
    boolean hasNext();

    Plant next();
}
