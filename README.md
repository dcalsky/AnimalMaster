AnimalMaster
=======
Custom Framework project for design pattern course.

# Get started
1. Open java IDE
2. Access `example` package
3. Run main static function to start sample program

# Usage
## Start your farm life
In your main function, define a farm object to manage your farm. 
Farm class is a singleton class, and you can just implement a public static method to create and get the unique farm instance like this

```java
Farm myFarm = Farm.getInstance();
```
For avoiding fetch farm instance under multiple thread env, we set the sync lock to insure you can only get farm instance only once.


Once you get the singleton farm instance, you are supposed to add object(living or unliving things) into it.
```java
myFarm.add(...)
```

What your should pay attention to is, if you don't add your newly created objects into the farm instance, and just initialize them without this binding action, these objects will not included in your farm.
## Whose farm?
Now your program creates a farm, but it is a aborted farm because nobody manages it, works for it and care about it!
So why don't we find our farm a manager? Luckily, we provide you a abstract `Manger` Class to focus on the farm's management, which means that you can inherit it to create owners, cow keepers, sheepherder and so on（but we don't implement them all, because we are framework）. We provide a `Owner` class for every farm's basic need, and you can create your other managers like the same way:
```java
public class Owner extends Manager
{
    private ArrayList<ManagerWorkFlow> work_flow = new ArrayList<ManagerWorkFlow>();

    public Owner(String name)
    {
        super(name);
    }
    @Override
    public void manage_work(ArrayList<ManagerWorkFlow> s)
    {
        this.work_flow = s;
    }

    @Override
    public void custom_work()
    {
        for(ManagerWorkFlow a : work_flow)
        {
            a.wrap(this);
        }
    }
}
```
Then you can define your owner in your main class or whatever:
```java
private Owner jjh = new Owner("jjh");
```
### Managers have to work
Now back to the meaning of manager. Every manager should have his work duty, but how to make them work? Don't worry, we have implemented a work system for you.
All you need to focus on are there two things:

- ManagerWorkFlow
- WorkFactory

`WorkFactory` is a singleton class, and it manages all the work behaviors defines by user, while `ManagerWorkFlow` is a class inherited from `Action` class, and it manages a work flow for a special manager.
So you can let jjh start his work in this way:
```java
WorkFactory wf = WorkFactory.get_instance();
ManagerWorkFlow feed_fish = wf.get_work("feed_fish",jjh);
ManagerWorkFlow feed_pig = wf.get_work("feed_pig",jjh);
ArrayList<ManagerWorkFlow>s = new ArrayList<ManagerWorkFlow>(){
    {
    add(feed_fish);
    add(feed_pig);
    }
};
jjh.manage_work(s);
jjh.work_flow();
```

## Create your first animal
There are two ways to define and initialize your custom animal(object). But, first of all, you should notice that 
**our framework** has provided your **two base classes**, `Living` and `unliving`. They are factory classes, and build in some 
basic methods.

Using `living` class means that you want to create a living object(typically, animal). There are also two ways to define 
your custom animals.

- Inherit Living class
- Using factory method

Just define your class (Animal), and inherit Living class.
```java
// Example for inheriting living class
public class Animal extends Living {
    public int volumn = 0; // Your custom property
    private AnimalState state = new AnimalState(this); // If you wanna define custom state
    String type; // Your custom property

    Animal(String type_name) {
        type = type_name;
    }

    
    public void eat() {
        state.grow();
        System.out.println("Eat eat!");
    }
}

// Initialize object

Animal pig = new Animal("pigpigpig");
```

---
If you want to create a living object through a most simple way, you can do this: 
```java
Living some_living_obj = Living.create();
```

By the way, `Living::create` method can receive a argument which is a special tag of this object.

If you do not pass the special tag to this method, framework will dispatch a default tag for your object automatically. Auto tag format is: `living<total_living_count>`.

## Actions coming
Each living objects have their own actions. But we don't implement all of them to you(Because we are framework >_<)

Although there is no build-in action offered to you. But you can define it by yourself in the simplest approach. If you want the pig, which has been defined from above, to fly, you must define a fly action, which can wrap the pig's wings.

Implement action interface to define your custom action class:
```java
public class FlyAction implements Action {
    @Override
    public void wrap(Node n) {
        System.out.println("Fly");
    }
}
```

Up to now, pig is ready to fly. Because living instance supports doing an action dynamically:
```java
FlyAction fly_action = new FlyAction();
pig.do_action(fly_action);
```

### Ooops, all pigs want to fly
Now that all pigs wanna fly, we should create them at first.
```java
Animal pig1 = new Animal("pig1");
Animal pig2 = new Animal("pig2");
```
Then we invoke all_do_action static method to make all pigs do fly action. It also means, all instances which are 
created by `Animal` class, all of them will do this action too.
```java
Animal.all_do_action(flyAction);
```

All animals will fly in the sky currently.

## Evolution of your animal
With time going by, your animal may evolute into a new type of animal.
You can use `Adapter` to make your animal evolute. And what happens after evolute is defined in `AfterEvolution` class
```java
//进化
pig1 = new Adapter(new AfterEvolution("SmartPig"));
pig1.speak();
```
## Your animal needs Equipment
Reasonably, your animal may need some equipment to equip theirselves. For example, horse may need to wear horseshoe to run faster. So you can define a `Equipment` class which inherits node to satisfy this need.
A way of implementation maybe like this:
```java
//继承自node类的自定义装备类
public class Equipment extends Node
{
	//描述这个装备的类型
	private String equipType;

	//穿戴这件装备的animal
	private Animal  dresser;

	public void setEquipType(String equipType)
	{
		this.equipType = equipType;
	}

	public String getEquipType()
	{
		return equipType;
	}
	Equipment(String type)
	{
		equipType = type;
	}

	public void setDresser(Animal dresser)
	{
		this.dresser = dresser;
	}

	public void printStatus()
	{
		System.out.println( equipType+"(ID:"+this.getID()+")" + "is dressed by "+ dresser.type+"(ID:"+dresser.getID()+")");
	}
}
```

And then you may test it like this:
```java
//test for equipment
Equipment pig1Equip = new Equipment("pig's sty");
pig1Equip.setDresser(pig1);
pig1Equip.printStatus();
```

## Gather a crowd
A pig and a dog, they are best friend with each other. But they are different instances created by different classes. 
Think of this situation, PigA created by `Pig` class and DogB created by `Dog` class, and the two classes both inherit `Living` class:
```java
Living pigA = Living.create("pigA");
Living dogB = Living.create("dogB");
```

Here is the simplest way to gather them to a group:

Create a group which only collects instances created by `living` class, and limit it's capacity is **10**
```java
Group<Living> living_group = new Group<>(10);

```
Then we add the dog and the pig into this group. pigA and dogB are in our group now.
```java
living_group.add(pigA);
living_group.add(dogB);
```

This moment, both of them wanna fly. Just a little case. Invoking allDoAction method of group instance will 
solve this issue.
```java
FlyAction flyAction = new FlyAction();
living_group.allDoAction(flyAction);
```


## Record farm state
It's a big problem that you wanna record your farm state before rebuilding your farm. 
Because you think you will feel regretful once rebuilding the farm.

Does't matter. FarmState class will solve this problem. Just record current state of your farm.

```java
// Record farm state
FarmMemento farm_state = new FarmMemento(myFarm);


// Rebuild your farm
myFarm.rebuild(new SmallFarmLevel());


// regret? Restore farm state!
myFarm.restore(farm_state.get_state());
```

## Manger's round
Create your manager class and do not let it inherit `Manager` class but set a private member variable of `Owner` class.

And define a set of work flow which belong to this manager. 
```java
public class TestManager {
    private Owner jjh = new Owner("jjh");

    public TestManager(String name) {

        WorkFactory wf = WorkFactory.get_instance();
        ManagerWorkFlow feed_fish = wf.get_work("feed_dog", jjh);
        ManagerWorkFlow feed_pig = wf.get_work("feed_pig", jjh);
        ArrayList<ManagerWorkFlow> s = new ArrayList<ManagerWorkFlow>() {
            {
                add(feed_fish);
                add(feed_pig);
            }
        };
        jjh.manage_work(s);
    }
}
```
This manager `jjh` wants to kill a pig, but he can't kill this pig by his hands, he must have some tools.

`Tool` class is born for this situation. Define a `Knife` custom class inherited `Tool` abstract class. And implement the `do_action`
 method. In this method, you can get the actual node which is this tool used for. You can judge the type of it and handle it.
```java
public class Knife extends Tool {
    @Override
    public void do_action(Node node) {
        if (node instanceof Animal) {
            ((Animal) node).state.dead();
            System.out.println(((Animal) node).type + " has been killed!");
        } else {
            System.out.println("Knife can only use for animals!");
        }
    }
}
```

After defining the custom tool class, our manager should wear it now.
```java
// jjh get a knife
test_manager.jjh.mount_equipment(new Knife());

// initialize a pig instance
Animal pig = new Animal("pigA");
test_manager.jjh.use_equipment_to(pig);
```
At the moment, pigA is killed by jjh.

# For contributors

## Suggested Branch name

### `<type>/<name>`

### `<type>`
```
feat   - New feature.
hotfix - Quick fixes to the codebase.
chore  - Normal modification
style  - Update code style(indent, semi, etc...)
```

### `<name>`
Always use dashes to seperate words, and keep it short.

### Examples
```
feat/kernal
hotfix/base-image
bug/abc
```

### Main Branch

#### `Master`
Keep stable and workable version. Submit PR to this branch once your jobs are done.

#### `Feat/*`
New experimental feature for this project. For personal development

# Serious
因为有些同学先参与开发，有些同学晚参与。所以请大家要遵守上述开发流程。
不懂的可以来307寝室问同学
```
git checkout master
git pull
git checkout -b <your_branch_name>
(develop features and commit)
git push origin <your_branch_name>
(apply PR to master branch)
(wait for check)
```


