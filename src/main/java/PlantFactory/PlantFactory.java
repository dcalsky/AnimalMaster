package PlantFactory;

/****
 *
 * 实现Abstract Factory
 * 用于生产不同季节不同的植物
 *
 * Created by VentusXu on 2017/10/23
 *
 */

import BaseClass.Plant;


public interface PlantFactory {
    Plant createPlant();
}
