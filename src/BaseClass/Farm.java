package BaseClass;

import java.awt.*;

/**
 * 农场类，用到设计模式singleton
 *
 * Created by LSL on 2017/10/19
 */

public class Farm
{
	/*
		用到时再创建，节省内存开销
	 */
	private static Farm farmInstance = null;

	//获取单例
	public static Farm getInstance()
	{
		try
		{
			if(farmInstance != null)
			{
				//直接返回
			}
			else
			{
				// 避免多线程下重复创建单例，为单例加锁（DCL）
				synchronized (Farm.class)
				{
					Thread.sleep(300);
					if(farmInstance == null)    //二次检查
					{
						farmInstance = new Farm();
					}
				}
			}
		}
		catch (InterruptedException error)
		{
			error.printStackTrace();
		}

		return farmInstance;
	}

	private Farm()
	{

	}
}
