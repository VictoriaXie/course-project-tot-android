##SOLID:

#The Single-responsibility principle

Classes were designed such that each only has one responsibility. For instance, the UserModel class gets changed only when we need to change the rule of setting user name or their login password (ex: change the password length requirement to at least 12 characters instead of 8), and it won’t affect other classes.
We are using MVC architecture to ensure that each class follows the Single responsibility principle. For instance, we have four controller classes, and for each controller class, we only have one corresponding UI class, so the only reason to change the controller class is when we make changes to the corresponding UI class.


#The Open–closed principle

Classes were written such that they are easy to extend. For instance, the PomodoroController class is open for adding extensions in order to make the timer have more functions, such as adding a function which allows the user to set up a break period between activities. We did not disobey the closed for modification principle. We might make the goal class be an abstract class, and have academic goal and everydayLife goal as its subclass. If we have a method which allows us to add goals into a goal list, then we don’t need to rewrite the ‘addGoal’ method for each academic goal class and everydayLife goal class. This is an example of closed for modification.

#The Liskov Substitution Principle

In Stats part, we have an abstract class called ‘ChartController’, and its subclasses ‘barchartController’ and ‘linechartController’ implement all methods in their superclass which is ‘ChartController’. Therefore, we can say ‘barchartController’ and ‘linechartController’ are subtypes of  ‘ChartController’, and they satisfy all properties contained in the super class.

The Interface segregation principle
The interfaces we created are quite small thereby allowing them to be fully used by the classes. For example getStatus just has the methods to get the status of the pomodoro timer and nothing else. This makes our interfaces easy to understand and none of the concrete classes are forced to implement any unnecessary methods.

#Dependency Inversion:

In order for inner layers of the clean architecture to communicate with outer layers, we used the dependency inversion principle. For instance, when we need to display a success login message, the ‘OnLoginSuccess’ will be called. It will retrieve necessary information from the ‘LoginController'. However, ‘LoginController’ is a controller class and it should not rely on the View class in the MVC model . Hence, the ‘ILoginView’ holds a reference to ‘OnLoginSuccess’, which is an interface that defines the interface of a controller.


##Clean Architecture:

The Pomodoro Timer class, User login class, and Goal class are using the MVC architecture pattern.
Model:
User-login: Model directly manages the data, logic and rules of the application. In the User-login part, Model sets the rules for user's email address and their password. It is responsible for managing data which is updating the app to reflect data.
Pomodoro Timer: There is a model class that stores the information of the pomodoro timer, such as the focusing time and the breaking time, and also whether the timer is running or not.
Goal: containing only data
View:
User-login: It is responsible for how we can display the user-login data to the User screen. It is for presenting data in a particular format. In the User login part, it is used to show whether a user logs in successfully or not.
Pomodoro Timer: The view part is the layout of the pomodoro timer, which contains the buttons and text that will display to the user.
Goal: The activity classes act as views and they are updated by their corresponding presenter classes.
Controller:
User-login: It receives data from View and notify Model about the data. For example, after receiving a user's action from View, it needs to justify the length of the password that user enters. If its length is shorter than 12 chars, then it needs to notify the Model. Model will then update the result.
Pomodoro Timer: The Pomodoro Controller class will update the layout when a user starts or pauses the timer, or the focusing time ends and needs to turn into a resting state. Also, we use a Pomodoro Activity class to display the view and use Pomodoro Controller to update the view.
Goal: User input is passed from activity classes to presenter classes which then interacts with the models.
Activity:
Use Controllers to manipulate Views.

##Design Patterns:

We have used the Builder design pattern by creating a Builder object that creates a complex structure. In this structure, there is only one builder and it’s the concrete builder. There’s no director involved in it. We chose to use this pattern because we have too many attributes when we are creating a goal, and most of them are not required. This design pattern helps us provide a flexible solution to various goal creation problems.

Although we did not achieve it, but in our discussion we want to use the memento design pattern for our goal part. The essential point of using this design pattern is to allow users to undo or restore the previous action. In the memento design pattern, the Originator class will be the goal class, and it has the state that we might want to save or restore. We will create a memento class to hold the internal state of the Originator and allow it to restore it.


##Use of GitHub Features:

Our group utilised various features of Github to keep ourselves organized. We set up different branches when developing various features for our program. When a feature has been developed, a pull request will be made. Reviewers of pull requests often provided feedback, which was implemented before merging.
In addition, we also take notes for the issues that rise on github so that we can better fix it in the future.

Packaging Strategies:

We used the strategy of by layer to organize our code. We managed to place all Model classes in Model package, all Controller classes in Controller package, all View classes in View package and all MainActivity class in Activity package. The reason we decided to use this strategy is because our project uses the MVC model. This strategy can help us organize all of the classes we have.

Code Style and Documentation:

We did not pay much attention to fixing warnings, using java doc and using the pull request before. But when we worked on phase 2, we ensured that code warnings are resolved and documented most of the methods, especially those that are not clear on what they do at first glance. The methods that are not documented were the methods we felt had sufficient explanation in their names, such as getters and setters.

##Testing:
We did not do a good job in phase1 for this part. Most of the components were not tested. When we write tests we found that most of the cases are not hard to test since we have followed the clean architecture which makes sure that all of our classes are decoupled. Many of the classes rely on other classes through interfaces. So we just used the Junit test to test them. But we didn’t test all cases, for example we did not test getters and setters for all model classes, since these testings are trivial to test.

Code Organization:
In phase 0, we organized our code by components(Calendar, Pomodoro Timer, Users, Stats). However, as all of us decided to use the MVC model, we found that packaging by features becomes confusing. So we repackaged our code in 4 packages: Model, View, Controller, and Activity. This helps us follow clean architecture closely. Moreover, when we need to 

## Work Distribution:
Shuyang Qiu: is responsible for the Calendar part and the goal part.
Yushan Xie: is responsible for the user part and work on goal part with Shuyang. Also responsible the paper work such as design documentation.
Boyu Zhu: is responsible for the pomodoro part.
Yihang Luo: is responsible for the Stats part. 