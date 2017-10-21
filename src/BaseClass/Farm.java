package BaseClass;

import Extend.ClassUtil;
import Root.GameObject;

import java.awt.*;
import java.sql.Struct;
import java.util.List;

/**
 * 农场类，用到设计模式singleton
 *
 * Created by LSL on 2017/10/19
 */

//标志此农场的等级，可以代表面积大小等数值，同时在一定程度上反映了最大环境容纳量
enum FarmLevel
{
	//PERSONAL, ORGANIZATION, CORPORATION, CITY, PROVINCE, NATIONAL
	LITTLE, MEDIUM, LARGE, SUPER
}


public class Farm
{
	/*
		用到时再创建，节省内存开销
	 */
	private static Farm farmInstance = null;

	//private float area;                                 //农场面积
	private FarmLevel level;
	//private Manager owner;                              //农场拥有者
	private int maximum;                                  //最大动物容量，考虑到生物学中最大环境容纳量这一概念，需要进一步优化

	//扩大农场，不同等级可能会有不同操作
	public void extendFarm(FarmLevel newLevel)
	{
		switch (newLevel)
		{
			case LITTLE:
				maximum = 30;
				break;
			case MEDIUM:
				maximum = 100;
				break;
			case LARGE:
				maximum = 500;
				break;
			case SUPER:
				maximum = 1000;
				break;
			default:
				maximum = 0;
		}
	}

	//初始化农场对象
	public void initialize()
	{
		//获取单根的所有子类
		List<Class> packageClass = ClassUtil.getSonClass(GameObject.class);
		for(Class item : packageClass)
		{
			//随便调用一下这个类，使之初始化目的是添加到单根GameObject的prototype中
			item.getName();
		}
	}

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
		level = FarmLevel.LITTLE;
		maximum = 30;
	}
}
