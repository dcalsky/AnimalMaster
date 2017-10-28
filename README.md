AnimalMaster
=======
Custom Framework project for design pattern course.

# Usage
## Start your farm life
In your main function, define a farm object to manage your farm. Farm class is a singleton class, 
just implement a public static method to create and get the unique farm instance.

For avoiding fetch farm instance under multiple thread env, we set the sync lock to insure you can only get farm 
instance only once.
```java
Farm myFarm = Farm.getInstance();
```

Once you get the singleton farm instance, you can add object(living or unliving things) into it.
```java
myFarm.add(...)
```

If you don't add objects into the farm, just initialize them. That means, these objects are not included in your farm.

## Create your first animal
There are two ways to define and initialize your custom animal(object). But, first at all, you should realize that 
framework has provided your **two base classes**, `Living` and `unliving`. They are factory class, and build in some 
basic methods.

Using `living` class, means that you wanna create a living object(animal). There are also two ways to define 
your custom animals.

- Inherit Living class
- Using factory method

Just define your class (Animal), and inherit living class.
```java
// Inherit living class
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
If you wanna create a living object by using simple way: 
```java
Living some_living_obj = Living.create();
```

By the way, `Living::create` method receives a argument which is a special tag of this object.

If you do not pass the special tag to this method, framework will dispatch a default tag for your object automatically. Auto tag format is: `living<total_living_count>`.

## Actions coming
Each living have their own action. But we don't implement all them to you(Because we are framework >_<)

Although there are no build-in action offered to you. But you can define it by yourself in the simplest approach. If we wanna the pig which have been defined above to fly. We must define a fly action, it's can wrap the pig wings.

Implement action interface to define your custom action class:
```java
public class FlyAction implements Action {
    @Override
    public void wrap(Node n) {
        System.out.println("Fly");
    }
}
```

Until to now, pig is ready to fly. Because living instance supports do an action actively:
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
created by `Animal` class, all of them will do this action either.
```java
Animal.all_do_action(flyAction);
```

All animals will fly in the sky currently.

### Gather a crowd
A pig and a dog, they are best friend with each other. But they are different instance which created by different class. 
PigA created by `Pig` class and DogB created by `Dog` class. However, there two classes both inherit `Living` class

There are the simplest way to gather them to a group:

Create a group which only collects instances created by `living` class, and limit it's capacity is **10**
```java
Group<Living> living_group = new Group<>(10);
```
Now, pigA and dogB are coming.
```java
Living pigA = Living.create("pigA");
Living dogB = Living.create("dogB");
```
Then we add them into this group. pigA and dogB are in our group now.
```java
living_group.add(pigA);
living_group.add(dogB);
```

This moment, both of them wanna fly suddenly. Just a little case. Invoking allDoAction method of group instance will 
solve this issue.
```java
FlyAction flyAction = new FlyAction();
living_group.allDoAction(flyAction);
```

### Record farm state
It's a big problem that you wanna record your farm state before rebuilding your farm. 
Because you think you will feel regretful once rebuilding the farm.

Does't matter. FarmState class will solve this problem. Just record current state of your farm.

```java
// Record farm state
FarmMemento farm_state = new FarmMemento(myFarm);


// Rebuild your farm
myFarm.rebuild(new SmallFarmLevel());


// feel regretul? Restore farm state!
myFarm.restore(farm_state.get_state());
```

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
